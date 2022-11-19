package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameters {
    private final String sex;
    private final Boolean mane;

    public LionTestParameters(String sex, Boolean mane) {
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
    @Test
    public void doesHaveManeSetMaleOrFemaleExpectedTrueORFalse() throws Exception {
        Feline feline = Mockito.mock((Feline.class));
        Lion lionMale = new Lion(sex, feline);
        assertEquals(mane,lionMale.doesHaveMane());
    }
}
