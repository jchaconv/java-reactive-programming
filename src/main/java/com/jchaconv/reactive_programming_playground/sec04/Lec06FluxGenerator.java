package com.jchaconv.reactive_programming_playground.sec04;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerator {

    private static final Logger log = LoggerFactory.getLogger(Lec06FluxGenerator.class);

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            log.info("invoked");
            synchronousSink.next(1);
            //synchronousSink.next(2);
            //synchronousSink.complete();
            synchronousSink.error(new RuntimeException("oops"));
        })
                .take(4)
                .subscribe(Util.subscriber());


    }


}
