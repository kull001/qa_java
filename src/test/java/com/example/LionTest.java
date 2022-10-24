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
@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final Boolean mane;

    public LionTest(String sex, Boolean mane) {
        this.sex = sex;
        this.mane = mane;
    }

    @Parameterized.Parameters
    public static Object[][]getHasMane(){
        return new Object[][]{
                {"Самец",true},
                {"Самка",false},
        };
    }


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
    public void doesHaveManeSetMaleOrFemaleExpectedTrueORFalse() throws Exception {
        Feline feline = Mockito.mock((Feline.class));
        Lion lionMale = new Lion(sex, feline);
        assertEquals(mane,lionMale.doesHaveMane());
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
//    @Test
//    public void getFoodSetPredatorExpectedAnimalsBirdsFish() throws Exception {
//        Feline feline = Mockito.mock((Feline.class));
//        Lion lion = new Lion("Самка",feline);
//        List <String> predator = List.of("Животные", "Птицы", "Рыба");
//        Mockito.when(feline.getFood("Хищник")).thenReturn(predator);
//        assertEquals(predator,lion.getFood("Хищник"));
//
//
//    }
}