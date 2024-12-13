package com.lakas.util;

import com.lakas.creature.Creature;

import java.util.HashMap;
import java.util.Map;

public class Logs {
    private Logs(){};

    private static Map<String, String> logs = new HashMap<>();{}

    public static void logsMapInit() {
        logs.put("eat.log", " съедает ");
        logs.put("reproduce.log", " размножается c ");
        logs.put("move.log", " перемещается в клетку ");
        logs.put("spawn.log", " появляется в клетке ");
        logs.put("deathByHuger.log", " умирает от голода ");
    }

    public static Map<String, String> getLogs() {
        return logs;
    }

    public static void eatLog(Creature self, Creature oponent) {
        System.out.println("[" + StandartClass.getActualTime() + "] " + self.getName() + logs.get("eat.log") + oponent.getName() + " в поле: " + self.getPositionX() + ", " + self.getPositionY());
    }
    public static void reproduceLog(Creature parent1, Creature parent2, Creature child) {
        System.out.println("[" + StandartClass.getActualTime() + "] " + parent1.getName() + logs.get("reproduce.log") + parent2.getName() + " --> " + child.getName() + " в поле: " + parent1.getPositionX() + ", " + parent1.getPositionY());
    }
    public static void moveLog(Creature creature) {
        System.out.println("[" + StandartClass.getActualTime() + "] " + creature.getName() + logs.get("move.log") + creature.getPositionX() + ", " + creature.getPositionY());
    }
    public static void spawnLog(Creature creature) {
        System.out.println("[" + StandartClass.getActualTime() + "] " + creature.getName() + logs.get("spawn.log") + creature.getPositionX() + ", " + creature.getPositionY());
    }
    public static void  deathByHungerLog(Creature creature) {
        System.out.println("[" + StandartClass.getActualTime() + "] " + creature.getName() + logs.get("deathByHuger.log"));
    }
}
