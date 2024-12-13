package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Goat extends Animal {


    public double getFoodForLive() {
        return foodForLive;
    }

    public Goat(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 140;
        moveSpeed = 3;
        normOfFood = 10;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 3;
    }

    @Override
    public double returnWeight() {
        return 60;
    }

    @Override
    public double returnReserveCalories() {
        return 10;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
