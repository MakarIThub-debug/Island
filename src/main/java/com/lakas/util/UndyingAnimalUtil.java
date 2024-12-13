package com.lakas.util;

import com.lakas.creature.animals.Animal;

import java.lang.reflect.InvocationTargetException;

public class UndyingAnimalUtil extends Animal {
    public UndyingAnimalUtil(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        normOfFood = 50;
        foodForLive = returnWeight();
    }



    @Override
    public int returnSpeed() {
        return 5;
    }

    @Override
    public double returnWeight() {
        return 1;
    }

    @Override
    public double returnReserveCalories() {
        return 0;
    }

    @Override
    protected void changeFoodForLive(double food) {

    }
    public void move() {

    }
    public void eat() {

    }
    public void reproduce() {}
}
