package com.jchaconv.reactive_programming_playground.sec04;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec08FluxGenerateWithState {


    public static void main(String[] args) {

        //with state
        Flux.generate(
                () -> 0,        //initial value
                (counter, sink) -> {
                    var country = Util.faker().country().name();
                    sink.next(country);
                    counter++;
                    if(counter == 10 || country.equalsIgnoreCase("argentina")) {
                        sink.complete();
                    }
                    return counter;
                }, System.out::println
        ).subscribe(Util.subscriber());

    }

    private static void isNotAnOption() {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Flux.generate(synchronousSink -> {
            //int counter = 0;
            var country = Util.faker().country().name();
            synchronousSink.next(country);
            //counter++;
            atomicInteger.incrementAndGet();
            if(atomicInteger.get() == 10 || country.equalsIgnoreCase("peru")) {
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());

    }


}
