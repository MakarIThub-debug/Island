package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Boar extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Boar(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 50;
        moveSpeed = 2;
        normOfFood = 50;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 2;
    }

    @Override
    public double returnWeight() {
        return 400;
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
