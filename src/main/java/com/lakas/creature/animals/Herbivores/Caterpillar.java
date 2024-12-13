package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Caterpillar extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Caterpillar(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 1000;
        moveSpeed = 0;
        normOfFood = 0;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 0;
    }

    @Override
    public double returnWeight() {
        return 0.01;
    }

    @Override
    public double returnReserveCalories() {
        return 0;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
