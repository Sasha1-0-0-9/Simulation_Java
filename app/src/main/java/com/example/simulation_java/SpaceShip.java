package com.example.simulation_java;

public interface SpaceShip {
    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public int carry(Item item);
}
