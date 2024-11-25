package com.jchaconv.reactive_programming_playground.sec02;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec06MonoFromCallable {

    private static final Logger log = LoggerFactory.getLogger(Lec06MonoFromCallable.class);

    public static void main(String[] args) {

       var list = List.of(1, 2, 3);

       Mono.fromCallable(() -> sum(list))
               .subscribe(
                       i -> log.info("recibido {}", i),
                       err -> log.error("error", err),
                       () -> log.info("completed")
               );

    }

    private static int sum(List<Integer> list) throws Exception {
        log.info("finding the sum of {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }




}
