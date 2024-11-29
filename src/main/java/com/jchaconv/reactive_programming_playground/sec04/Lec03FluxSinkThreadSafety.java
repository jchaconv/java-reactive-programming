package com.jchaconv.reactive_programming_playground.sec04;

import com.jchaconv.reactive_programming_playground.common.Util;
import com.jchaconv.reactive_programming_playground.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Lec03FluxSinkThreadSafety {

    private static final Logger log = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {

        //demo1NoThreadSafety();
        demo2ThreadSafety();

    }

    private static void demo2ThreadSafety() {

        var list = new ArrayList<String>();

        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }

        Util.sleepSeconds(3);
        log.info("list size: {}", list.size());

    }

    private static void demo1NoThreadSafety() {

        var list = new ArrayList<Integer>();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };
        //to create 10 threads
        for (int i = 0; i < 10; i++) {
            //new Thread(runnable).start();
            Thread.ofPlatform().start(runnable);
        }

        Util.sleepSeconds(3);
        log.info("list size: {}", list.size());

    }

}
