package com.lakas.creature.animals.Predators;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Snake extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }


    public Snake(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 30;
        moveSpeed = 1;
        normOfFood = 3;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 1;
    }

    @Override
    public double returnWeight() {
        return 15;
    }

    @Override
    public double returnReserveCalories() {
        return 3;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
