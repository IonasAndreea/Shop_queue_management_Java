package DataModels;

public class Task implements Comparable {
    private Integer ID;
    private Integer arrivalTime;
    private Integer serviceTime;

    public Task(Integer ID, Integer arrivalTime, Integer serviceTime) {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public Task(){

    }

    public Integer getID() {
        return ID;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String toString() {
        return "ID: " + ID.toString() + "; Arrival time: " + arrivalTime.toString() + "; Service time: " + serviceTime.toString();
    }


    @Override
    public int compareTo(Object o) {
        Task t = (Task)(o);
        if (this.arrivalTime > t.arrivalTime) return 1;
        else if (this.arrivalTime < t.arrivalTime)return -1;
        else return 0;
    }
}
