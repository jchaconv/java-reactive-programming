package com.jchaconv.reactive_programming_playground.sec02;

import com.jchaconv.reactive_programming_playground.common.Util;
import com.jchaconv.reactive_programming_playground.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIO {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        log.info("starting");

        for (int i = 1; i <= 100; i++) {
            client.getProductName(i)
                    .subscribe(
                            n -> log.info("received ::" + n),
                            err -> log.error("error", err)
                            //() -> log.info("Completed!")
                    );
        }

        /*for (int i = 1; i <= 100; i++) {
            String name = client.getProductName(i).block();
            log.info(name);
        }*/

        Util.sleepSeconds(2);

    }
}
