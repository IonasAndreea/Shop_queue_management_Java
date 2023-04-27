package org.example;

import BusinessLogic.Controller;
import GUI.SimulationFrame;

public class Main {
    public static void main(String[] args) {

        SimulationFrame frame = new SimulationFrame();
        Controller controller = new Controller(frame);

    }

}