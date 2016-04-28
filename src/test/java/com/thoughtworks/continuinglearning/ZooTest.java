package com.thoughtworks.continuinglearning;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ZooTest {

    private Animal animal;
    private List<Animal> animals;
    private Zoo zoo;

    @Before
    public void setUp() throws Exception {
        animal = mock(Animal.class);
        animals = new ArrayList<>();
        zoo = new Zoo(animals);
    }

    @Test
    public void shouldFeedEachAnimalWhenFeedingAnimals() {
        animals.add(animal);

        zoo.feedAnimals();

        verify(animal).feed();
    }

}