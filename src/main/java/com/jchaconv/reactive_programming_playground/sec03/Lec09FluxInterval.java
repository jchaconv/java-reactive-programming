package com.jchaconv.reactive_programming_playground.sec03;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofMillis(500))
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5); //blocking the main thread

    }

}
