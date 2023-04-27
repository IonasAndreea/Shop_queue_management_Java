package DataModels;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.System.exit;

public class Server implements Runnable {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server(int capacity) {
        this.tasks = new ArrayBlockingQueue<Task>(capacity);
        this.waitingPeriod = new AtomicInteger(0);
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
        waitingPeriod.getAndAdd(newTask.getServiceTime());
    }

    @Override
    public void run() {
        while(true)
        {
           if(!tasks.isEmpty())
           {
               try {
                   //Thread.sleep(tasks.peek().getServiceTime() * 1000);
                   Thread.sleep(1000);
               } catch(InterruptedException e) {
                   exit(-1);
               }
               if(tasks.size()>0) {
                   for(Task t:tasks) {
                       t.setServiceTime(t.getServiceTime() - 1);
                       if (t.getServiceTime() == 0) {
                           try {
                               tasks.take();
                           } catch (InterruptedException e) {
                               return;
                           }

                       }

                   }
                   //waitingPeriod.addAndGet(-tasks.peek().getServiceTime());
                   waitingPeriod.decrementAndGet();

                   //tasks.remove();
                   //} catch (InterruptedException e) {
                   //throw new RuntimeException(e);
                   // }

               }
           }
        }
    }

    @Override
    public String toString() {
        String s = "";
       // Iterator<Task> iterator = tasks.iterator();
       // while(iterator.hasNext())
        //{
        for(Task t : this.tasks)
        {
            s += t.toString()+"\n";

        }
        //System.out.println("\n");
      return s;
    }

    public Task[] getTask() {
        int i = 0;
        BlockingQueue<Task> q = new LinkedBlockingQueue<>(tasks);
        Task[] task1 =new Task[q.size()];
        for(Task u: q)
        {
            task1[i] = u;
            i++;
        }
        return task1;
    }
}
