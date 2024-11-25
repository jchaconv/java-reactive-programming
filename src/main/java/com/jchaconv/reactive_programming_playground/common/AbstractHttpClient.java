package com.jchaconv.reactive_programming_playground.common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;

public abstract class AbstractHttpClient {

    public static final String BASE_URL = "http://localhost:7070";
    protected final HttpClient httpClient;

    protected AbstractHttpClient() {

        var loopResources = LoopResources.create("jchaconv", 1, true);
        this.httpClient = HttpClient.create().runOn(loopResources).baseUrl(BASE_URL);

    }
}
