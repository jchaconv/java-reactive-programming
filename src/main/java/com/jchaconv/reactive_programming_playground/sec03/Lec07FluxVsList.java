package com.jchaconv.reactive_programming_playground.sec03;

import com.jchaconv.reactive_programming_playground.common.Util;
import com.jchaconv.reactive_programming_playground.sec03.helper.NameGenerator;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        //var list = NameGenerator.getNamesList(10);
        //System.out.println(list);

        NameGenerator.getNamesFlux(10)
               .subscribe(Util.subscriber());


    }



}
