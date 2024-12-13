package com.lakas.creature;

public abstract class Creature {
    private static int ID = 1;
    protected static final double WEIGHT = 0;
    protected String name;
    private int positionX;
    private int positionY;
    protected double foodForLive;


    public Creature(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = this.getClass().getSimpleName() + "@" + ID;
        this.ID++;
    }

    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public String getName() {
        return name;
    }
    public abstract double returnWeight();

}
