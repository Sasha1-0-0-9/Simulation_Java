package com.example.simulation_java;

public class U2 extends Rocket {

   public U2() {
        super(120, 18000, 29000, 0.06, 0.08);
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
