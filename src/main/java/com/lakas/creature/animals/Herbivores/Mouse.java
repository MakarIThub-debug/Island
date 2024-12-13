package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Mouse extends Animal {


    public double getFoodForLive() {
        return foodForLive;
    }

    public Mouse(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 500;
        moveSpeed = 1;
        normOfFood = 0.01;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 1;
    }

    @Override
    public double returnWeight() {
        return 0.05;
    }

    @Override
    public double returnReserveCalories() {
        return 0.01;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
