package com.example.simulation_java;

public class U1 extends Rocket{
    public U1() {
        super(100, 10000, 18000, 0.05, 0.01);
        currentWeight = weight;
    }


    @Override
    public boolean land(){
        return !(Math.random() <
                chanceOfLandingCrash * (this.currentWeight/(this.maxWeight - this.weight)));
    }

    @Override
    public boolean launch(){
        return !(Math.random() <
                chanceOfLaunchExplosion * (this.currentWeight/(this.maxWeight - this.weight)));
    }
}
