package com.jchaconv.reactive_programming_playground.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    private static final Logger log = LoggerFactory.getLogger(Lec04MonoEmptyError.class);

    public static void main(String[] args) {

        getUsername(95).subscribe(
                i -> log.info("received {}", i),
                err -> log.error("error", err),
                () -> log.info("completed!")
        );


    }

    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("julio");
            case 2 -> Mono.empty(); //null
            default -> Mono.error(new RuntimeException("Invalid input"));
        };
    }



}
