package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Duck extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Duck(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 200;
        moveSpeed = 4;
        normOfFood = 0.15;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 4;
    }

    @Override
    public double returnWeight() {
        return 1;
    }

    @Override
    public double returnReserveCalories() {
        return 0.15;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
