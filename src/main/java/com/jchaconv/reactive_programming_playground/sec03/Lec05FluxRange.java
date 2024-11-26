package com.jchaconv.reactive_programming_playground.sec03;

import com.github.javafaker.Faker;
import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static final Faker faker = Faker.instance();

    public static void main(String[] args) {

        Flux.range(3, 10)
                .subscribe(Util.subscriber());

        System.out.println("===================");

        //assignment generate 10 random first names

        Flux.range(1, 10)
                .map(i -> faker.name().firstName())
                .subscribe(Util.subscriber());

    }

}
