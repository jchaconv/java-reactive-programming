package com.jchaconv.reactive_programming_playground.sec05;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06ErrorHandling {

    private static Logger log = LoggerFactory.getLogger(Lec06ErrorHandling.class);

    public static void main(String[] args) {

        Flux.range(1, 10)
                .map(i -> i == 5 ? 5/0 : i)
                .onErrorContinue((ex, obj) -> {
                    log.error("This object causes the error ===> {}", obj);
                    log.error("This is the exception:", ex);
                })
                .subscribe(Util.subscriber());


    }

    private static void onErrorComplete() {

        Mono.error(new RuntimeException("oops"))
                .onErrorComplete()
                .subscribe(Util.subscriber());

        Mono.just(1)
                .onErrorComplete()
                .subscribe(Util.subscriber());

    }

    private static void onErrorResume() {
        Mono.error(new RuntimeException("oops"))
                .onErrorResume(ArithmeticException.class, ex -> fallback1())
                .onErrorResume(ex -> fallback2())
                .onErrorReturn(-5)
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback1() {
        log.info("fallback1 method invoked");
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(10, 100));
    }

    private static Mono<Integer> fallback2() {
        log.info("fallback2 method invoked");
        //return Mono.fromSupplier(() -> Util.faker().random().nextInt(10, 100));
        return Mono.error(new IllegalAccessError("new exception"));
    }

    private static void onErrorReturn() {
        //Mono.just(5)  ---> también funciona en Mono
        Flux.range(1, 10)
                .map(i -> i == 5 ? 5/0 : i)
                .onErrorReturn(IllegalArgumentException.class, -1)
                .onErrorReturn(ArithmeticException.class, -2)
                .onErrorReturn(-3)
                .subscribe(Util.subscriber());
    }


}
