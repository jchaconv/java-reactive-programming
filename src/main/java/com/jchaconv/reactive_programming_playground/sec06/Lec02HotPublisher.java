package com.jchaconv.reactive_programming_playground.sec06;

import com.jchaconv.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02HotPublisher {

    public static final Logger log = LoggerFactory.getLogger(Lec02HotPublisher.class);

    public static void main(String[] args) {

        var movieFlux = movieStream()
                .publish()
                .refCount(1);
                //.share();

        Util.sleepSeconds(2);

        movieFlux
                //.take(1)
                .take(4)
                .subscribe(Util.subscriber("jchaconv"));

        Util.sleepSeconds(3);

        movieFlux
                .take(3)
                .subscribe(Util.subscriber("rutiluye"));

        Util.sleepSeconds(15);

    }

    public static Flux<String> movieStream() {

        return Flux.generate(
                        () -> {
                            log.info("received the request");
                            return 1;
                        },
                        (state, sink) -> {
                            var scene = "movie scene " + state;
                            log.info("playing {}", scene);
                            sink.next(scene);
                            return ++state;
                        }
                )
                .take(10)
                .delayElements(Duration.ofSeconds(1))
                .cast(String.class);
    }
}