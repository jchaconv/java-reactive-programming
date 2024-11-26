package com.jchaconv.reactive_programming_playground.sec03.assignment;

import com.jchaconv.reactive_programming_playground.common.Util;
import com.jchaconv.reactive_programming_playground.sec03.client.ExternalServiceClient;

public class Lec12Assignment {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        var subscriber = new StockPriceObserver();
        client.getPriceChanges()
                .subscribe(subscriber);

        Util.sleepSeconds(20);


    }


}
