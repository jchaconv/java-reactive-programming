package com.jchaconv.reactive_programming_playground.sec02;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        // Mono<String> mono = Mono.just("julio");
        var mono = Mono.just("Julio");
        mono.subscribe(System.out::println);

        //en la clase hizo el subscribe y request con las clases
        //que implementó manualmente, pero no es necesario hacerlo aquí
        //ya que solo son como referencia, nadie hace eso actualmente


    }


}
