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
        assertThat(beers.get(1).getName()).isEqualTo("Strauss Endless Summer Light");
        assertThat(beers.get(1).getValue()).isEqualTo(9);
        assertThat(beers.get(1).getAlcoholByVolume()).isEqualTo(3.3);
        assertThat(beers.get(2).getName()).isEqualTo("Corona Extra");
        assertThat(beers.get(2).getValue()).isEqualTo(8);
        assertThat(beers.get(2).getAlcoholByVolume()).isEqualTo(4.6);
        assertThat(beers.get(3).getName()).isEqualTo("Blue Moon");
        assertThat(beers.get(3).getValue()).isEqualTo(7);
        assertThat(beers.get(3).getAlcoholByVolume()).isEqualTo(5.4);
        assertThat(beers.get(4).getName()).isEqualTo("Rogue Dead Guy Ale");
        assertThat(beers.get(4).getValue()).isEqualTo(7);
        assertThat(beers.get(4).getAlcoholByVolume()).isEqualTo(6.8);
    }
}