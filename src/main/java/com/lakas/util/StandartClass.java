package com.lakas.util;

import com.lakas.creature.Creature;
import com.lakas.creature.animals.Animal;
import com.lakas.field.Field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class StandartClass {
    private StandartClass(){};
    public static List<Creature> getCreaturesInActualField(int x, int y) {
        List<Creature> result = Field.getField().get(x).get(y);
        return result;
    }

    public static double getChance(Class selfClass, Class oponentClass) {
        return Animal.getChanceOfWin().get(selfClass).get(oponentClass);
    }

    public static LocalDateTime getActualTime() {
        return LocalDateTime.now();
    }

    @SuppressWarnings("all")
    public static Animal reproducingOfAnimal(Animal parent) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends Animal> clazz = parent.getClass();
        Constructor<? extends Animal> ctor = parent.getClass().getConstructor(int.class, int.class);
        Animal child = ctor.newInstance(parent.getPositionX(), parent.getPositionY());
        return child;
    }

    public static String[] getPossibleDirections(int positionX, int positionY) {

        //Если позиция не на границе
        if (positionX > 0 && positionX < Field.getxSize() && positionY > 0 && positionY < Field.getySize()) {
            return new String[]{"UP", "DOWN", "LEFT", "RIGHT"};
        }
        //Если позиция на верхней границе
        else if (positionX == 0) {
            //Если позиция в левом верхнем углу
            if (positionY == 0) {
                return new String[]{"DOWN","RIGHT"};
            }
            //Если позиция в правом верхнем углу
            else if (positionY == Field.getySize()) {
                return new String[]{"DOWN", "LEFT"};
            }
            return new String[]{"DOWN", "LEFT", "RIGHT"};
        }
        else if (positionX == Field.getxSize()) {
            //Если позиция в левом нижнем углу
            if (positionY == 0) {
                return new String[]{"UP", "RIGHT"};
            }
            //Если позиция в правом нижнем углу
            else if (positionY == Field.getySize()) {
                return new String[]{"UP", "LEFT"};
            }
            //Если позиция на нижней границе
            return new String[]{"UP", "LEFT", "RIGHT"};
        }
        //Если позиция на левой границе
        else if (positionY == 0) {
            return new String[]{"UP", "DOWN", "RIGHT"};
        }

        //Если позиция на правой границе
        return new String[]{"UP", "DOWN", "LEFT"};
    }

    public static <T extends Animal> int[] solveDistanceToMove(String direction, T animal) {
        Random rndDist = new Random();
        int[] newCoords = new int[2];
        int speed = animal.returnSpeed();
        switch (direction) {
            case "UP":
                if (animal.getPositionX() < speed) {
                    newCoords[0] = animal.getPositionX() - rndDist.nextInt(animal.getPositionX());
                }
                newCoords[0] = animal.getPositionX() - rndDist.nextInt(speed);
                newCoords[1] = animal.getPositionY();
                break;

            case "DOWN":
                if (Field.getxSize() - animal.getPositionX() < speed) {
                    newCoords[0] = animal.getPositionX() + rndDist.nextInt(Field.getxSize() - animal.getPositionX());
                }
                newCoords[0] = animal.getPositionX() + rndDist.nextInt(speed);
                newCoords[1] = animal.getPositionX();
                break;

            case "LEFT":
                if (animal.getPositionY() < speed) {
                    newCoords[1] = animal.getPositionY() - rndDist.nextInt(animal.getPositionY());

                }
                newCoords[1] = animal.getPositionY() - rndDist.nextInt(speed);
                newCoords[0] = animal.getPositionX();
                break;

            case "RIGHT":
                if (Field.getySize() - animal.getPositionY() < speed) {
                    newCoords[1] = animal.getPositionY() + rndDist.nextInt(speed);
                }
                newCoords[1] = animal.getPositionY() + rndDist.nextInt(speed);
                newCoords[0] = animal.getPositionX();
                break;
            }
        return newCoords;
    }


}

