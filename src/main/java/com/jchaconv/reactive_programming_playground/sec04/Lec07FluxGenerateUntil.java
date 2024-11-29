package com.jchaconv.reactive_programming_playground.sec04;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateUntil {


    public static void main(String[] args) {

        demo2();

    }

    private static void demo2() {

        Flux.<String>generate(synchronousSink -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);
        })
                .takeUntil(c -> c.equalsIgnoreCase("peru"))
                .subscribe(Util.subscriber());

    }

    private static void demo1() {

        Flux.generate(synchronousSink -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);
            if(country.equalsIgnoreCase("peru")) {
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());

    }


}
