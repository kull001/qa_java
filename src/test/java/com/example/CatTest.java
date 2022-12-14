package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;


    @Test
    public void getSoundAlwaysSayMiau() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }


    @Test
    public void getFoodAlwaysReturnAnimalsBirdsFish() throws Exception {
        Cat cat = new Cat(feline);
        List<String> herbivores = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(herbivores);
        assertEquals(herbivores,cat.getFood());
    }
}