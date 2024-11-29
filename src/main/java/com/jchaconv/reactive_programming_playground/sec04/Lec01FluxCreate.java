package com.jchaconv.reactive_programming_playground.sec04;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class Lec01FluxCreate {


    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada"));
        }).subscribe(Util.subscriber());

        /*
        Consumer<FluxSink<String>> fluxSinkConsumer = fluxSink -> {
            fluxSink.next(Util.faker().country().name());
            fluxSink.complete();
        };

        Flux.create(fluxSinkConsumer).subscribe(Util.subscriber());
        */


    }


}
