package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Deer extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Deer(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 20;
        moveSpeed = 4;
        normOfFood = 50;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 4;
    }

    @Override
    public double returnWeight() {
        return 300;
    }

    @Override
    public double returnReserveCalories() {
        return 50;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
