package com.lakas.creature.animals.Herbivores;

import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.InvocationTargetException;

public class Rabbit extends Animal {

    public double getFoodForLive() {
        return foodForLive;
    }

    public Rabbit(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        maxQuantityOnOneField = 150;
        moveSpeed = 2;
        normOfFood = 0.45;
        foodForLive = returnWeight();
    }

    @Override
    public int returnSpeed() {
        return 2;
    }

    @Override
    public double returnWeight() {
        return 2;
    }

    @Override
    public double returnReserveCalories() {
        return 0.45;
    }
    @Override
    protected void changeFoodForLive(double food) {
        foodForLive += food;
    }
}
