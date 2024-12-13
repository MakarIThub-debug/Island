package com.lakas.creature.animals.Predators;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Fox extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Fox(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 30;
        moveSpeed = 2;
        normOfFood = 2;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 2;
    }

    @Override
    public double returnWeight() {
        return 8;
    }

    @Override
    public double returnReserveCalories() {
        return 2;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
