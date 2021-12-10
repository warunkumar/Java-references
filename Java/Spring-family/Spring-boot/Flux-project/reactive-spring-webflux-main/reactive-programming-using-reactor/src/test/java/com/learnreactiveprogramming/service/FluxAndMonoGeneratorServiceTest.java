package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoGeneratorServiceTest {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService=new FluxAndMonoGeneratorService();

    @Test
    public void namesFluxTest(){
        var nameFlux=fluxAndMonoGeneratorService.namesFlux();
        StepVerifier.create(nameFlux)
                //.expectNext("Warun","Kumar","Upadhyay")
                //.expectNextCount(3)
                .expectNext("Warun")
                .expectNextCount(2)
                .verifyComplete();
    }

}