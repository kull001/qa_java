package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class FelineTest {
    private final int kittens;
    private final int actualKittens;
    public FelineTest(int kittens, int actualKittens){
       this.kittens = kittens;
       this.actualKittens = actualKittens;
    }

    @Parameterized.Parameters
        public static Object[][]getResultGetKittens(){
        return new Object[][]{
                {1,1},
                {0,0},
                {100,100},
        };
    }

    Feline feline = new Feline();
    //@Before
    //public void init() {
        //MockitoAnnotations.initMocks(this);
    //}
    //@Test
    //public void eatMeatAlwaysReturnAnimalsBirdsFish() throws Exception {

        //Animal animal = Mockito.mock((Animal.class));
        //Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //assertEquals(List.of("Животные", "Птицы", "Рыба"),feline.eatMeat());

    //}

    @Test
    public void getFamilyAlwaysReturnFeline() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи",actual);
    }

    @Test
    public void getKittensAlwaysReturn1() {
        int actual = feline.getKittens();
        assertEquals(1,actual);
    }

    @Test
    public void getKittensWithParameters(){
        assertEquals(kittens, feline.getKittens(actualKittens));
    }


}