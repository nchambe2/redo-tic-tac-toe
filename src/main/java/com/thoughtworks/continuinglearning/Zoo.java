package com.thoughtworks.continuinglearning;

import java.util.List;

public class Zoo {

    private final List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public void feedAnimals() {
        for (Animal animal : animals) {
            animal.feed();
        }
    }
}
