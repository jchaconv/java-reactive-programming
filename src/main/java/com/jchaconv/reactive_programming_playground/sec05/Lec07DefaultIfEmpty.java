package com.jchaconv.reactive_programming_playground.sec05;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec07DefaultIfEmpty {

    public static void main(String[] args) {


        Mono.empty()
                .defaultIfEmpty("fallback")
                .subscribe(Util.subscriber());

        System.out.println(" ================== ");

        Flux.range(1, 10)
                .filter(i -> i > 11)
                .defaultIfEmpty(95)
                .subscribe(Util.subscriber());


    }


}
