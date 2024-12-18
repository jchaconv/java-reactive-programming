package com.jchaconv.reactive_programming_playground.sec05;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Lec10Transform {

    public static final Logger log = LoggerFactory.getLogger(Lec10Transform.class);

    record Customer(int id, String name) {}
    record PurchaseOrder(String productName, int price, int quantity){}

    public static void main(String[] args) {

        var isDebugEnabled = false;

        /*
        getCustomers()
                .doOnNext(i -> log.info("received {}", i))
                .doOnComplete(() -> log.info("completed!"))
                .doOnError(err -> log.error("error", err))
                .subscribe();

         */

        getCustomers()
                .transform(isDebugEnabled ? addDebugger() : Function.identity())
                .subscribe(i -> log.info("recibido {}", i));


        getPurchaseOrders()
                .transform(addDebugger())
                .subscribe();

    }

    private static Flux<Customer> getCustomers() {
        return Flux.range(1, 3)
                .map(i -> new Customer(i, Util.faker().name().firstName()));
    }

    private static Flux<PurchaseOrder> getPurchaseOrders() {
        return Flux.range(1, 5)
                .map(i -> new PurchaseOrder(Util.faker().commerce().productName(), i * 5, i));
    }


    private static <T>UnaryOperator<Flux<T>> addDebugger() {
        return flux -> flux
                .doOnNext(i -> log.info("received {}", i))
                .doOnComplete(() -> log.info("completed!"))
                .doOnError(err -> log.error("error", err));
    }


}
