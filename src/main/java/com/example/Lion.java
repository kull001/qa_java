package com.example;

import java.util.List;

public class Lion implements AnimalParent{

    boolean hasMane;
    private AnimalParent animalParent;

    public Lion(AnimalParent animalParent){

        this.animalParent = animalParent;
    }

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    //Feline feline = new Feline();


    public int getKittens() {

        return animalParent.getKittens();
    }

    public boolean doesHaveMane() {

        return hasMane;
    }

    public List<String> getFood(String animalKind) throws Exception {
        return animalParent.getFood(animalKind);
    }
}
