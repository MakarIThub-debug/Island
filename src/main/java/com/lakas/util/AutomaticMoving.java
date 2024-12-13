package com.lakas.util;

import com.lakas.creature.animals.Animal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutomaticMoving {
    private AutomaticMoving() {
    }

    public static void moving(Animal animal) {
        ScheduledExecutorService mult = Executors.newScheduledThreadPool(5);
        mult.scheduleAtFixedRate(() -> {
            animal.move();
            animal.eat();
            try {
                animal.reproduce();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }, 0, 1500, TimeUnit.MILLISECONDS);
    }
}
