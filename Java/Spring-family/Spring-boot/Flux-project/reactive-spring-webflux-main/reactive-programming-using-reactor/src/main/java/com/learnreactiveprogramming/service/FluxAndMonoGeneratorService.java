package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService=new FluxAndMonoGeneratorService();
        fluxAndMonoGeneratorService.namesFlux().log().subscribe(System.out::println);
        fluxAndMonoGeneratorService.namesMono().subscribe(System.out::println);
    }

    public Flux<String> namesFlux(){

        return Flux.fromIterable(List.of("Warun","Kumar","Upadhyay"));
    }

    public Mono<String> namesMono(){

        return Mono.just("Noneya");
    }
}
