package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
public class FelineTest {


    Feline feline = new Feline();


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

}