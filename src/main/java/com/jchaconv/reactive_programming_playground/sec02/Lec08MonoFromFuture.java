package com.jchaconv.reactive_programming_playground.sec02;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec08MonoFromFuture {

    private static final Logger log = LoggerFactory.getLogger(Lec08MonoFromFuture.class);

    public static void main(String[] args) throws InterruptedException {

        /*Mono.fromFuture(getName())
                .subscribe(
                        i -> log.info("received :: {}", i),
                        err -> log.error("error", err),
                        () -> log.info("completed!!!!!")
                );*/

        Mono.fromFuture(Lec08MonoFromFuture::getName)
                        .subscribe(Util.subscriber());

        Util.sleepSeconds(1);

    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> {
            log.info("generating name");
            return Util.faker().name().firstName();
        });
    }



}
