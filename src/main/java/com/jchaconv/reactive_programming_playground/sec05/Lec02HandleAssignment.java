package com.jchaconv.reactive_programming_playground.sec05;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {

    public static void main(String[] args) {

        Flux.<String>generate(sink -> sink.next(Util.faker().country().name()))
                .handle((item, sink) -> {
                    sink.next(item);
                    if(item.equalsIgnoreCase("argentina"))
                        sink.complete();
                })
                .subscribe(Util.subscriber());
    }

    private static void mySolution() {

        Flux.<String>generate(synchronousSink -> {
                    var country = Util.faker().country().name();
                    synchronousSink.next(country);
                }).handle((item, sink) -> {
                    if(!item.equalsIgnoreCase("argentina")) {
                        sink.next(item);
                    } else {
                        sink.next(item);
                        sink.complete();
                    }
                })
                .cast(String.class)
                .subscribe(Util.subscriber());
    }


}
