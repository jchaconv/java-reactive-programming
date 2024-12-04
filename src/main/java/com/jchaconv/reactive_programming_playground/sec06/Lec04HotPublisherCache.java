package com.jchaconv.reactive_programming_playground.sec06;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04HotPublisherCache {

    public static final Logger log = LoggerFactory.getLogger(Lec04HotPublisherCache.class);

    public static void main(String[] args) {

        var stockFlux = stockStream()
                .replay(5)
                .autoConnect(0);

        Util.sleepSeconds(4);

        log.info("jchaconv is joining");
        stockFlux
                .subscribe(Util.subscriber("jchaconv"));

        Util.sleepSeconds(3);

        log.info("rutiluye is joining");
        stockFlux
                .subscribe(Util.subscriber("rutiluye"));

        Util.sleepSeconds(15);

    }

    public static Flux<Integer> stockStream() {

        return Flux.generate(sink -> sink.next(Util.faker().random().nextInt(10, 100)))
                .delayElements(Duration.ofSeconds(3))
                .doOnNext(price -> log.info("emitting price: {}", price))
                .cast(Integer.class);
    }



}