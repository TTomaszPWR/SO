package lab1;

public class Process {
    private final int arrivalTime; // czas pojawienia się procesu
    private int burstTime;   // czas trwania procesu
    private int waitingTime; // czas oczekiwania w kolejce

    public Process(int arrivalTime, int burstTime) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
}
