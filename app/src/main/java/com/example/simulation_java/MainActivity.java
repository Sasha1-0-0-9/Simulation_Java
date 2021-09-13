package com.example.simulation_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sumU1;
    TextView sumU2;
    Simulation simulation = new Simulation(this);
    int totalSumU1 = 0;
    int totalSumU2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumU1 = findViewById(R.id.sumU1);
        sumU2 = findViewById(R.id.sumU2);
    }

    public void runTheSimulation(View view) throws Exception {
        totalSumU1 = simulation.startSimulation(simulation.loadU1(simulation.read_PhaseOne()));
        totalSumU1 += simulation.startSimulation(simulation.loadU1(simulation.read_PhaseTwo()));
        sumU1.setText(totalSumU1 + " million $");
        totalSumU2 = simulation.startSimulation(simulation.loadU2(simulation.read_PhaseOne()));
        totalSumU2 += simulation.startSimulation(simulation.loadU2(simulation.read_PhaseTwo()));
        sumU2.setText(totalSumU2+" million $");

    }
}