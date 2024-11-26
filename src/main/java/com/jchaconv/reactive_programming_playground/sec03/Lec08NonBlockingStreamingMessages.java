package com.jchaconv.reactive_programming_playground.sec03;

import com.jchaconv.reactive_programming_playground.common.Util;
import com.jchaconv.reactive_programming_playground.sec03.client.ExternalServiceClient;

public class Lec08NonBlockingStreamingMessages {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        client.getNames()
                .subscribe(Util.subscriber("sub1"));

        client.getNames()
                .subscribe(Util.subscriber("sub2"));

        Util.sleepSeconds(6); //blocking the main thread because it is exiting automatically


    }


}
