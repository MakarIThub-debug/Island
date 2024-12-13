package com.lakas.creature.animals.Predators;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Eagle extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Eagle(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 20;
        moveSpeed = 3;
        normOfFood = 1;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 3;
    }

    @Override
    public double returnWeight() {
        return 6;
    }

    @Override
    public double returnReserveCalories() {
        return 1;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
