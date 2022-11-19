package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTestParameters {

    private final int kittens;
    private final int actualKittens;
    public FelineTestParameters(int kittens, int actualKittens){
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

    @Test
    public void getKittensWithParameters(){
        assertEquals(kittens, feline.getKittens(actualKittens));
    }

}
