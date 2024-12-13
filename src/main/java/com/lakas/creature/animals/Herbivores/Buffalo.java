package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Buffalo extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Buffalo(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 10;
        moveSpeed = 3;
        normOfFood = 100;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 3;
    }

    @Override
    public double returnWeight() {
        return 700;
    }

    @Override
    public double returnReserveCalories() {
        return 100;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
