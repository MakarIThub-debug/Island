package com.lakas;

import com.lakas.creature.animals.Herbivores.Deer;
import com.lakas.creature.animals.Herbivores.Duck;
import com.lakas.creature.animals.Herbivores.Horse;
import com.lakas.creature.animals.Herbivores.Rabbit;
import com.lakas.creature.animals.Predators.Bear;
import com.lakas.creature.animals.Predators.Wolf;
import com.lakas.creature.plant.Plant;
import com.lakas.field.Field;
import com.lakas.util.AutomaticMoving;
import com.lakas.util.AutomaticSpawnCreatures;
import com.lakas.util.StandartClass;
import com.lakas.util.UndyingAnimalUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IslandSimulation {
    public static void main(String[] args) throws Exception {
        //Создаем остров
        Field.initializationField();

        //Создаем животных и запускаем
        AutomaticSpawnCreatures.spawnCreature(UndyingAnimalUtil.class, 1);
//        AutomaticSpawnCreatures.spawnCreature(Wolf.class, 10, 3, 3);
//        AutomaticSpawnCreatures.spawnCreature(Bear.class, 15);
//        AutomaticSpawnCreatures.spawnCreature(Rabbit.class, 10);
//        AutomaticSpawnCreatures.spawnCreature(Duck.class, 2);
//        AutomaticSpawnCreatures.spawnCreature(Plant.class, 1);


        int[] actual = new int[2];
        actual[0] = Field.getField().size();
        actual[1] = Field.getField().get(1).size();
        int[] expected = new int[]{100, 20};
        for (int i = 0; i < 2; i++) {
            System.out.println(actual[i]);
            System.out.println(expected[i]);
        }
        System.out.println(actual);
        System.out.println(expected);
    }
}
