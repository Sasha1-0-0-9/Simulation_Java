package com.example.simulation_java;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.wifi.WifiEnterpriseConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private Context context;

    public Simulation(Context context) {
        this.context = context;
    }
    public ArrayList<Item> read_PhaseOne() throws IOException {
        AssetManager assetManager = context.getAssets();
        ArrayList<Item> phase_one = new ArrayList<>();

       Scanner scanner = new Scanner(assetManager.open(("Phase1")));
        while (scanner.hasNextLine()){
            Item item = new Item();
            String[] lines = scanner.nextLine().split("=");
            item.name = lines[0];
            item.weight = Integer.parseInt(lines[lines.length-1]);
            phase_one.add(item);
        }

        return phase_one;
    }

    public ArrayList<Item> read_PhaseTwo() throws IOException {
        AssetManager assetManager = context.getAssets();
        ArrayList<Item> phase_two = new ArrayList<>();

        Scanner scanner = new Scanner(assetManager.open("Phase2"));
        while (scanner.hasNextLine()){
            Item item = new Item();
            String[] lines = scanner.nextLine().split("=");
            item.name = lines[0];
            item.weight = Integer.parseInt(lines[lines.length-1]);
            phase_two.add(item);
        }
        return phase_two;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> arrayList){
        ArrayList<Rocket> rocketsPhaseOne = new ArrayList<>();

        Rocket rocket = new U1();
        for (Item item : arrayList){
            if(rocket.canCarry(item)){
                rocketsPhaseOne.add(rocket);
            }
            else{
                rocket = new U1();
                rocketsPhaseOne.add(rocket);
            }
        }
        return rocketsPhaseOne;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> arrayList){
        ArrayList<Rocket> rocketsPhaseTwo = new ArrayList<>();

        Rocket rocket = new U2();
        for (Item item : arrayList){
            if(rocket.canCarry(item)){
                rocketsPhaseTwo.add(rocket);
            }
            else{
                rocket = new U2();
                rocketsPhaseTwo.add(rocket);
            }
        }
        return rocketsPhaseTwo;
    }

    public int startSimulation(ArrayList<Rocket> rockets){
        int budget = 0;
        for(Rocket rocket : rockets){
            budget += rocket.getCost();
            while (!rocket.launch() || !rocket.land()){
                budget += rocket.getCost();
            }
        }
        return  budget;
    }
}
