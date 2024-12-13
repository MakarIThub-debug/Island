package com.lakas.creature.animals;

import com.lakas.creature.Creature;
import com.lakas.creature.animals.Herbivores.*;
import com.lakas.creature.animals.Predators.*;
import com.lakas.creature.plant.Plant;
import com.lakas.field.Field;
import com.lakas.util.AutomaticMoving;
import com.lakas.util.Logs;
import com.lakas.util.StandartClass;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

abstract public class Animal extends Creature {
    private static final Map<Class<? extends Creature>, Map<Class<? extends Creature>, Double>> chanceOfWin = new HashMap<>();
    protected static int maxQuantityOnOneField;
    protected static int moveSpeed;
    protected static double normOfFood;
    protected double foodForLive;

    public Animal(int positionX, int positionY) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        super(positionX, positionY);
        insertMapChances();
        Field.getField().get(positionX).get(positionY).add(this);
        AutomaticMoving.moving(this);
    }
    public static Map<Class<? extends Creature>, Map<Class<? extends Creature>, Double>> getChanceOfWin() {
        return chanceOfWin;
    }
    public abstract int returnSpeed();
    public abstract double returnWeight();
    public abstract double returnReserveCalories();
    protected abstract void changeFoodForLive(double food);

    @Deprecated
    public static int getMoveSpeed() {
        return moveSpeed;
    }
    //////////////////////////////////////////util/////////////////////////////////////////////

    private static void insertMapChances() {
        //wolf
        Map<Class<? extends Creature>, Double> wolfChances = new HashMap<>();
        wolfChances.put(Horse.class, 0.1);
        wolfChances.put(Deer.class, 0.15);
        wolfChances.put(Rabbit.class, 0.6);
        wolfChances.put(Mouse.class, 0.8);
        wolfChances.put(Goat.class, 0.6);
        wolfChances.put(Sheep.class, 0.7);
        wolfChances.put(Boar.class, 0.15);
        wolfChances.put(Buffalo.class, 0.1);
        wolfChances.put(Duck.class, 0.4);
        chanceOfWin.put(Wolf.class, wolfChances);

        //snake
        Map<Class<? extends Creature>, Double> snakeChances = new HashMap<>();
        snakeChances.put(Fox.class, 0.15);
        snakeChances.put(Rabbit.class, 0.2);
        snakeChances.put(Mouse.class, 0.4);
        snakeChances.put(Duck.class, 0.1);
        chanceOfWin.put(Snake.class, snakeChances);

        //fox
        Map<Class<? extends Creature>, Double> foxChances = new HashMap<>();
        foxChances.put(Rabbit.class, 0.7);
        foxChances.put(Mouse.class, 0.9);
        foxChances.put(Duck.class, 0.6);
        foxChances.put(Caterpillar.class, 0.4);
        chanceOfWin.put(Fox.class, foxChances);

        //bear
        Map<Class<? extends Creature>, Double> bearChances = new HashMap<>();
        bearChances.put(Snake.class, 0.8);
        bearChances.put(Horse.class, 0.4);
        bearChances.put(Deer.class, 0.8);
        bearChances.put(Rabbit.class, 0.8);
        bearChances.put(Mouse.class, 0.9);
        bearChances.put(Goat.class, 0.7);
        bearChances.put(Sheep.class, 0.7);
        bearChances.put(Boar.class, 0.5);
        bearChances.put(Buffalo.class, 0.2);
        bearChances.put(Duck.class, 0.1);
        chanceOfWin.put(Bear.class, bearChances);

        //Eagle
        Map<Class<? extends Creature>, Double> eagleChances = new HashMap<>();
        eagleChances.put(Fox.class, 0.1);
        eagleChances.put(Rabbit.class, 0.9);
        eagleChances.put(Mouse.class, 0.9);
        eagleChances.put(Duck.class, 0.8);
        chanceOfWin.put(Eagle.class, eagleChances);

        //Horse
        Map<Class<? extends Creature>, Double> horseChances = new HashMap<>();
        horseChances.put(Plant.class, 1.0);
        chanceOfWin.put(Horse.class, horseChances);

        //Deer
        Map<Class<? extends Creature>, Double> deerChances = new HashMap<>();
        deerChances.put(Plant.class, 1.0);
        chanceOfWin.put(Deer.class, deerChances);

        //Rabbit
        Map<Class<? extends Creature>, Double> rabbitChances = new HashMap<>();
        rabbitChances.put(Plant.class, 1.0);
        chanceOfWin.put(Rabbit.class, rabbitChances);

        //Mouse
        Map<Class<? extends Creature>, Double> mouseChances = new HashMap<>();
        mouseChances.put(Plant.class, 1.0);
        mouseChances.put(Caterpillar.class, 0.9);
        chanceOfWin.put(Mouse.class, mouseChances);

        //Goat
        Map<Class<? extends Creature>, Double> goatChances = new HashMap<>();
        goatChances.put(Plant.class, 1.0);
        chanceOfWin.put(Goat.class, goatChances);

        //Sheep
        Map<Class<? extends Creature>, Double> sheepChances = new HashMap<>();
        sheepChances.put(Plant.class, 1.0);
        chanceOfWin.put(Sheep.class, sheepChances);

        //Boar
        Map<Class<? extends Creature>, Double> boarChances = new HashMap<>();
        boarChances.put(Plant.class, 1.0);
        boarChances.put(Caterpillar.class, 0.9);
        boarChances.put(Mouse.class, 0.5);
        chanceOfWin.put(Boar.class, boarChances);

        //Buffalo
        Map<Class<? extends Creature>, Double> buffaloChances = new HashMap<>();
        buffaloChances.put(Plant.class, 1.0);
        chanceOfWin.put(Buffalo.class, buffaloChances);

        //Duck
        Map<Class<? extends Creature>, Double> duckChances = new HashMap<>();
        duckChances.put(Plant.class, 1.0);
        duckChances.put(Caterpillar.class, 0.9);
        chanceOfWin.put(Duck.class, duckChances);

        //Caterpillar
        Map<Class<? extends Creature>, Double> caterpillarChances = new HashMap<>();
        caterpillarChances.put(Plant.class, 1.0);
        chanceOfWin.put(Caterpillar.class, caterpillarChances);

    }

    //////////////////////////////////////////eat reproduce move/////////////////////////////////////////////
    public void eat() {
        List<Creature> currentField = StandartClass.getCreaturesInActualField(this.getPositionX(), this.getPositionY());
        Random random =  new Random();
        for (int i = 0; i < currentField.size(); i++) {
            if (currentField.get(i) != this && chanceOfWin.get(this.getClass()).containsKey(currentField.get(i).getClass()) && random.nextBoolean()) {
                double chance = StandartClass.getChance(this.getClass(), currentField.get(i).getClass());
                if (Math.random() <= chance) {
                    Logs.eatLog(this, currentField.get(i));
                    this.changeFoodForLive(currentField.get(i).returnWeight());
                    currentField.remove(currentField.get(i));
                }
            }
        }
    }
    public void reproduce() throws Exception {
        List<Creature> currentField = StandartClass.getCreaturesInActualField(this.getPositionX(), this.getPositionY());
        Random random =  new Random();
        for (int i = 0; i < currentField.size(); i++) {
            if (currentField.get(i) != this && random.nextDouble(1) > 0.75 && currentField.get(i).getClass() == this.getClass()) {
                Animal child = StandartClass.reproducingOfAnimal(this);
                Logs.reproduceLog(this, currentField.get(i), child);
                break;
            }
        }
    }
    public void move() {
        if (this.foodForLive <= 0) {
            deathByHunger();
        }
        //Выбор нужного направления
        String[] directions = StandartClass.getPossibleDirections(getPositionX(), getPositionY());
        Random random = new Random();
        String choosenDirection = directions[random.nextInt(directions.length)];
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Определение расстояния
        int[] newPosition = StandartClass.solveDistanceToMove(choosenDirection, this);
        //Удаление животного из не актуального поля
        Field.getField().get(this.getPositionX()).get(this.getPositionY()).remove(this);
        //Пересчет координат
        this.setPositionX(newPosition[0]);
        this.setPositionY(newPosition[1]);
        //Перемещаем животное в актуальное поле
        Field.getField().get(this.getPositionX()).get(this.getPositionY()).add(this);
        this.foodForLive -= this.returnWeight() / 5;
        Logs.moveLog(this);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void deathByHunger() {
        Field.getField().get(this.getPositionX()).get(this.getPositionY()).remove(this);
        this.setPositionX(-1);
        this.setPositionY(-1);

        Logs.deathByHungerLog(this);
    }






}


