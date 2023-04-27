package BusinessLogic;

import DataModels.Task;
import GUI.SimulationFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;

public class SimulationManager implements Runnable{

    private int timeLimit;
    private int maxProcessingTime;
    private int minProcessingTime;
    private int numberOfServers;
    private int minArrivalTime;
    private int maxArrivalTime;
    private int nrOfClients;
    private double avgTime;
    private SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private SimulationFrame frame;
    private ArrayList<Task> generatedTask;


    public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int numberOfServers, int minArrivalTime, int maxArrivalTime, int nrOfClients, SimulationFrame frame){

        this.timeLimit = timeLimit;
        this.maxArrivalTime = maxArrivalTime;
        this.maxProcessingTime = maxProcessingTime;
        this.minArrivalTime = minArrivalTime;
        this.minProcessingTime = minProcessingTime;
        this.numberOfServers = numberOfServers;
        this.nrOfClients = nrOfClients;
        this.frame = frame;

        scheduler = new Scheduler(numberOfServers, nrOfClients);
         generatedTask = new ArrayList<Task>();
         generateNRandomTasks();
//        System.out.println("maxArrivalTime:" + maxArrivalTime + "    maxProcesingTime:" + maxProcessingTime+ "    minProcesingTime:" + minProcessingTime + "    minArrivalTime:" + minArrivalTime + "    numberofclients:"+ nrOfClients + "   NumberofQueues " + numberOfServers + "   Time limit " + timeLimit );


    }

    private void generateNRandomTasks() {
        Random r = new Random();
        for (int i = 0; i < nrOfClients; i++) {
            int processingTime = r.nextInt(minProcessingTime, maxProcessingTime);
            int arrivalTime = r.nextInt(minArrivalTime, maxArrivalTime);
            generatedTask.add(new Task(i + 1 ,arrivalTime,processingTime));
        }
        Collections.sort(generatedTask);

    }

    @Override
    public void run() {
        String outputFrame = "";
        String output = "";
        int currentTime = 0;
        //System.out.println("Este ");
        while(currentTime <= timeLimit)
        {
            Iterator<Task> iterator = generatedTask.iterator();
            while(iterator.hasNext())
            {
                Task gt = iterator.next();
                if(gt.getArrivalTime() == currentTime) {
                    scheduler.dispatchTask(gt);
                    iterator.remove();
                }

            }
//            try( FileWriter file = new FileWriter("log.txt")) {
//                BufferedWriter info = new BufferedWriter(file);
//                info.write("Time :"+currentTime);
//                for(int i =0; i < generatedTask.size();i++) {
//                    info.write("Waiting clients: { " + generatedTask.get(i).toString() + " }");
//                }
//                info.write(scheduler.toString());
//                info.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("Time :"+currentTime);
            output +="Time :"+currentTime + "\n";
            outputFrame ="Time :"+currentTime + "\n";
            for(int i =0; i < generatedTask.size();i++)
            {
                System.out.println("Waiting clients: { " + generatedTask.get(i).toString() + " }");
                output += "Waiting clients: { " + generatedTask.get(i).toString() + " }" + "\n\n" ;
                outputFrame += "Waiting clients: { " + generatedTask.get(i).toString() + " }" + "\n\n" ;
            }
                System.out.println(scheduler.toString());
                output += scheduler.toString() + "\n";
                outputFrame += scheduler.toString() + "\n";
                frame.setTextOut(outputFrame);

            currentTime++;
            try(FileWriter file = new FileWriter("log.txt");) {
                file.write(output);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setMaxProcessingTime(int maxProcessingTime) {
        this.maxProcessingTime = maxProcessingTime;
    }

    public void setMinProcessingTime(int minProcessingTime) {
        this.minProcessingTime = minProcessingTime;
    }

    public void setNumberOfServers(int numberOfServers) {
        this.numberOfServers = numberOfServers;
    }

    public void setMinArrivalTime(int minArrivalTime) {
        this.minArrivalTime = minArrivalTime;
    }

    public void setMaxArrivalTime(int maxArrivalTime) {
        this.maxArrivalTime = maxArrivalTime;
    }

    public void setNrOfClients(int nrOfClients) {
        this.nrOfClients = nrOfClients;
    }



}


