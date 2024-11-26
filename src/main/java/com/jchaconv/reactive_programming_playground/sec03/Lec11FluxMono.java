package com.jchaconv.reactive_programming_playground.sec03;

import com.jchaconv.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec11FluxMono {


    public static void main(String[] args) {

        var flux = Flux.range(1, 10);
        //flux.next().subscribe(Util.subscriber());
        Mono.from(flux)
                .subscribe(Util.subscriber());

    }

    private static void monoToFlux() {
        var mono = getUsername(3);
        save(Flux.from(mono));
    }

    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("julio");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid input"));
        };
    }

    private static void save(Flux<String> flux) {
        flux.subscribe(Util.subscriber());
    }

}
