package com.jchaconv.reactive_programming_playground.sec04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class Lec05FluxTakeOperator {

    private static final Logger log = LoggerFactory.getLogger(Lec05FluxTakeOperator.class);

    public static void main(String[] args) {

        takeUntil();


    }

    private static void takeUntil() {

        Flux.range(1, 10)
                .log("take")
                .takeUntil(num -> num > 6)
                .log("sub")
                .subscribe(
                        item -> log.info("received : {}", item),
                        err -> log.error("error: ", err),
                        () -> log.info("completed!!!")
                );
    }

    private static void takeWhile() {

        Flux.range(1, 10)
                .log("take")
                .takeWhile(num -> num < 5)
                .log("sub")
                .subscribe(
                        item -> log.info("received : {}", item),
                        err -> log.error("error: ", err),
                        () -> log.info("completed!!!")
                );
    }

    private static void take() {

        IntStream.rangeClosed(1, 10)
                .limit(3)
                .forEach(System.out::println);

        log.info("==================");

        Flux.range(1, 10)
                .log("take")
                .take(3)
                .log("sub")
                .subscribe(
                        item -> log.info("received : {}", item),
                        err -> log.error("error: ", err),
                        () -> log.info("completed!!!")
                );

    }


}
