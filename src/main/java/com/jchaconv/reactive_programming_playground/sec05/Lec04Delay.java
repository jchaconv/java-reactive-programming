package com.jchaconv.reactive_programming_playground.sec05;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Delay {


    public static void main(String[] args) {


        Flux.range(1, 10)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(12);

    }



}
