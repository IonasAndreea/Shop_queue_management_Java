package BusinessLogic;

import GUI.SimulationFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    SimulationFrame frame;
    public Controller(SimulationFrame fr){
        this.frame = fr;
        this.frame.startListener(new StartListener());
    }

    public SimulationManager createSimulation() {
        int maxArrivalTime = 0;
        int maxProcessingTime = 0;
        int minArrivalTime = 0;
        int minProcessingTime = 0;
        int nrOfClients = 0;
        int numberOfServers = 0;
        int timeLimit = 0;

        try {
            maxArrivalTime = Integer.parseInt(frame.getMaxArrivalTime());
            maxProcessingTime = Integer.parseInt(frame.getMaxServiceTime());
            minArrivalTime = Integer.parseInt(frame.getMinArrivalTime());
            minProcessingTime = Integer.parseInt(frame.getMinServiceTime());
            nrOfClients = Integer.parseInt(frame.getNoOfClients());
            numberOfServers = Integer.parseInt(frame.getNoOfQueues());
            timeLimit = Integer.parseInt(frame.getSimulationInterval());

        } catch(NumberFormatException nfex)
        {
            frame.showNumberError("Bad input:");
            return null;

        }
        SimulationManager sim = new SimulationManager(timeLimit, maxProcessingTime, minProcessingTime, numberOfServers, minArrivalTime, maxArrivalTime, nrOfClients, frame);
        return sim;
    }

    public class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            SimulationManager sim = createSimulation();
            Thread t = new Thread(sim);
            t.start();
        }
    }

}
