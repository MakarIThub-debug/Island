package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Sheep extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Sheep(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 140;
        moveSpeed = 3;
        normOfFood = 15;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 3;
    }

    @Override
    public double returnWeight() {
        return 70;
    }

    @Override
    public double returnReserveCalories() {
        return 15;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
