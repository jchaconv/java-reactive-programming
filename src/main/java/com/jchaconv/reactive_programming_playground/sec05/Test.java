package com.jchaconv.reactive_programming_playground.sec05;

import reactor.core.publisher.Flux;

public class Test {

    public static void main(String[] args) {

        Flux<Integer> range = Flux.range(1, 10);
        range.map(i -> i * 10);
        range.subscribe(System.out::println);


    }

}
