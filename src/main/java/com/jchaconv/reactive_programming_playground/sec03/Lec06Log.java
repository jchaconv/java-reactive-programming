package com.jchaconv.reactive_programming_playground.sec03;

import com.github.javafaker.Faker;
import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {

    public static void main(String[] args) {

        Flux.range(1, 5)
                .log("range-map")
                .map(i -> Util.faker().name().fullName())
                .log("map-subscribe")
                .subscribe(Util.subscriber());

    }


}
