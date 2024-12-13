package com.lakas.creature.plant;

import com.lakas.creature.Creature;

public class Plant extends Creature {
    public Plant(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public double returnWeight() {
        return 1;
    }

}
