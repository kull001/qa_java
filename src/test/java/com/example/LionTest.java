package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensAlwaysReturn1() throws Exception {
        Feline feline = Mockito.mock((Feline.class));
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void getFoodSetHerbivoreExpectedGrassVariousPlants() throws Exception {
        Feline feline = Mockito.mock((Feline.class));
        Lion lion = new Lion("Самец",feline);
        List <String> herbivore = List.of("Трава", "Различные растения");
        Mockito.when(feline.getFood("Травоядное")).thenReturn(herbivore);
        assertEquals(herbivore,lion.getFood("Травоядное"));

    }

    @Test
    public void unknownAnimalTest() {
        String someMassage = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Feline feline = Mockito.mock((Feline.class));
            Lion lion = new Lion("неизвестный", feline);
        });
        assertEquals(someMassage, exception.getMessage());
    }

}