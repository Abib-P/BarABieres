package com.barabieres.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JsonBeerRepositoryTest {

    BeerRepository beerRepository;

    @BeforeEach
    void setup() {
        beerRepository = new JsonBeerRepository("BeerRepositoryJson/src/main/resources/beers.json");
    }

    @Test
    void should_return_beers_when_json_is_given() {
        List<Beer> beers = beerRepository.getAllBeers();
        assertThat(beers.get(0).getName()).isEqualTo("Beck's Light");
        assertThat(beers.get(0).getValue()).isEqualTo(10);
        assertThat(beers.get(0).getAlcoholByVolume()).isEqualTo(2.3);
    }

}