package com.jchaconv.reactive_programming_playground.sec03;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {

    public static void main(String[] args) {

        Flux.just(1, 7, 22, 2, 41, "julio")
                .subscribe(Util.subscriber());

    }


}
