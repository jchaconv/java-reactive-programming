package com.jchaconv.reactive_programming_playground.sec05;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec08SwitchIfEmpty {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .filter(i -> i > 11)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 3);
    }


}
