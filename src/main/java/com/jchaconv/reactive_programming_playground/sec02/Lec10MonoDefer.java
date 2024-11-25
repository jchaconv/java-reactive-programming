package com.jchaconv.reactive_programming_playground.sec02;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec10MonoDefer {

    private static final Logger log = LoggerFactory.getLogger(Lec10MonoDefer.class);

    public static void main(String[] args) {

        //createPublisher();
                //.subscribe(Util.subscriber());

        Mono.defer(() -> createPublisher())
                .subscribe(Util.subscriber());

    }

    private static Mono<Integer> createPublisher() {
        log.info("creating publisher");
        Util.sleepSeconds(2);
        var list = List.of(1, 2, 3);
        return Mono.fromSupplier(() -> sum(list));
    }

    // time-consuming business logic
    private static int sum(List<Integer> list) {
        log.info("finding the sum of {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(a -> a).sum();
    }



}
