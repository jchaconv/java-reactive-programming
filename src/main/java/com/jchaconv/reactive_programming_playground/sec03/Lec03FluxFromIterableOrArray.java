package com.jchaconv.reactive_programming_playground.sec03;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromIterableOrArray {

    public static void main(String[] args) {

        var list = List.of("d", "e", "a", "m");
        Flux.fromIterable(list).subscribe(Util.subscriber());

        Integer[] arr = {1, 23, 55, 21, 10, 2, 8};
        Flux.fromArray(arr).subscribe(Util.subscriber());


    }


}
