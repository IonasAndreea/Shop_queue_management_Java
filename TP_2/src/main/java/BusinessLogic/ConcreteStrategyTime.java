package BusinessLogic;

import DataModels.Server;
import DataModels.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {

    @Override
    public void addTask(List<Server> servers, Task t) {
        int min = 999999;
        for(Server s: servers)
        {
            if(s.getWaitingPeriod().intValue() < min)
            {
                min = s.getWaitingPeriod().intValue();
            }
        }
        for(Server s: servers)
        {
            if(s.getWaitingPeriod().intValue() == min)
            {
                //System.out.println("Server " + s + "add task" + t);
                s.addTask(t);
                break;
            }
        }

    }
}
