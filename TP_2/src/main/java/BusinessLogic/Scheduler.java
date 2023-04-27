package BusinessLogic;

import DataModels.Server;
import DataModels.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Scheduler {

    private ArrayList<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer) {
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
        servers = new ArrayList<>();
        for (int i = 0; i < maxNoServers; i++) {
            Server s = new Server(maxTasksPerServer);
            servers.add(s);
            Thread t = new Thread(s);
            t.start();
        }
    }

    public void changeStrategy(SelectionPolicy policy) {
        if (policy == SelectionPolicy.SHORTEST_TIME) {
            strategy = new ConcreteStrategyTime();
        }
    }

    public void dispatchTask(Task t) {
        ConcreteStrategyTime ta = new ConcreteStrategyTime();
        ta.addTask(servers, t);

    }


    @Override
    public String toString() {
        String s ="";
        int i = 1;
       // for (int i = 0; i < maxNoServers; i++) {
        for(Server se: servers)
        {
            s += "Queue " + i + ": \n" +se.toString() + "\n";
            i++;
        }
        return s;
    }
}








