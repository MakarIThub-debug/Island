package com.lakas.field;

import com.lakas.creature.Creature;
import com.lakas.util.Logs;

import java.util.ArrayList;
import java.util.List;



public class Field {

    private static Field fieldSingleton;

    private static final int X_SIZE = 100;
    private static final int Y_SIZE = 20;

    private static List<List<List<Creature>>> field = new ArrayList<>();

    public static List<List<List<Creature>>> getField() {
        return field;
    }

    private Field() {
        fieldInit();
        Logs.logsMapInit();
    }

    public static void initializationField() {
        if (fieldSingleton == null) {
            fieldSingleton = new Field();
        }
    }

    public static int getxSize() {
        return X_SIZE;
    }
    public static int getySize() {
        return Y_SIZE;
    }





    //////////////////////////////////////////util/////////////////////////////////////////////
    public void fieldInit() {
        for (int i = 1; i <= X_SIZE; i++) {
            List<List<Creature>> inner = new ArrayList<>();
            field.add(inner);
            for (int j = 1; j <= Y_SIZE; j++) {
                List<Creature> innerIn = new ArrayList<>();
                inner.add(innerIn);
            }
        }
    }

    public void printField() {
        for (int i = 0; i < field.size(); i++) {
            System.out.println(Field.getField().get(i));
        }
    }

    public static void replaceCreature(int newX, int newY, Creature creature) {


    }

}
