package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensAlwaysReturn1() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void doesHaveManeSetMaleExpectedTrue() throws Exception {
        Lion lionMale = new Lion("Самец");
        assertEquals(true,lionMale.doesHaveMane());
    }
    @Test
    public void doesHaveManeSetFemaleExpectedFalse() throws Exception {
        Lion lionMale = new Lion("Самка");
        assertEquals(false,lionMale.doesHaveMane());
    }


    @Test
    public void getFoodSetHerbivoreExpectedGrassVariousPlants() throws Exception {
        Lion lion = new Lion(feline);
        List <String> herbivore = List.of("Трава", "Различные растения");
        Mockito.when(feline.getFood("Травоядное")).thenReturn(herbivore);
        assertEquals(herbivore,lion.getFood("Травоядное"));

    }
    @Test
    public void getFoodSetPredatorExpectedAnimalsBirdsFish() throws Exception {
        Lion lion = new Lion(feline);
        List <String> predator = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(predator);
        assertEquals(predator,lion.getFood("Хищник"));


    }
}