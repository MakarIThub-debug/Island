package com.lakas.util;

import com.lakas.creature.Creature;
import com.lakas.field.Field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class AutomaticSpawnCreatures {
    private AutomaticSpawnCreatures(){};


    public static void spawnCreature(Class clazz, int quantity, int posX, int posY) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends Creature> newCreature = clazz.getConstructor(int.class, int.class);
        for (int i = 0; i < quantity; i++) {
            Creature o = newCreature.newInstance(posX, posY);
            Logs.spawnLog(o);
        }

    }

    public static void spawnCreature(Class clazz, int quantity) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends Creature> newCreature = clazz.getConstructor(int.class, int.class);
        Random rnd = new Random();
        //Получаем рандомную позицию
        int posX = rnd.nextInt(Field.getxSize());
        int posY = rnd.nextInt(Field.getySize());
        for (int i = 0; i < quantity; i++) {
            Creature o = newCreature.newInstance(posX, posY);
            Logs.spawnLog(o);
        }
    }
}
