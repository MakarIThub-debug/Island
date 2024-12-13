package com.lakas.creature.animals.Predators;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Wolf extends Animal {

    public Wolf(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 30;
        moveSpeed = 3;
        normOfFood = 8;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 3;
    }

    @Override
    public double returnWeight() {
        return 50;
    }

    @Override
    public double returnReserveCalories() {
        return 8;
    }

    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }


}
