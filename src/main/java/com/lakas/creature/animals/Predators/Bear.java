package com.lakas.creature.animals.Predators;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Bear extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Bear(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 5;
        moveSpeed = 2;
        normOfFood = 80;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 2;
    }

    @Override
    public double returnWeight() {
        return 500;
    }

    @Override
    public double returnReserveCalories() {
        return 80;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
