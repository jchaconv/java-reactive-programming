package com.jchaconv.reactive_programming_playground.sec05.assignment;

import com.jchaconv.reactive_programming_playground.common.Util;
import com.jchaconv.reactive_programming_playground.sec05.assignment.client.ExternalServiceClient;

public class Lec11Assignment {


    public static void main(String[] args) {


        var client = new ExternalServiceClient();

        for (int i = 1; i < 5; i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

        Util.sleepSeconds(3);


    }




}
