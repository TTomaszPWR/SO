package lab1;

import java.util.*;

public class CPUScheduler {
    // Algorytm FCFS
    public static void FCFS(Queue<Process> processes) {
        int size = processes.size();
        int currentTime = 0;
        int totalWaitingTime = 0;
        int i = 0;

        while (!processes.isEmpty()) {
            Process currentProcess = processes.poll();
            int waitTime = currentTime - currentProcess.getArrivalTime();
            currentProcess.setWaitingTime(waitTime);
            totalWaitingTime += waitTime;
            currentTime += currentProcess.getBurstTime();
            System.out.println("Process has been served: arrival time: " + currentProcess.getArrivalTime() +
                    ", duration: " + currentProcess.getBurstTime() +
                    ", waiting time: " + currentProcess.getWaitingTime() +
                    ", completion time: " + currentTime);
        }

        double averageWaitingTime = (double) totalWaitingTime / size;
        System.out.println("Average Waiting Time : " + averageWaitingTime);
    }

    // Algorytm SJF
    public static void SJF(Queue<Process> processes) {
        // sortowanie procesów według czasu trwania
        List<Process> processList = new ArrayList<>(processes);

        // Sort the List based on burst time
        Collections.sort(processList, Comparator.comparingInt(Process::getBurstTime));


        int totalWaitingTime = 0;
        int size = processes.size();
        int currentTime = 0;
        int i = 0;
        while (!processList.isEmpty()){
            if(processList.get(i).getArrivalTime() <= currentTime){
                int waitTime = currentTime - processList.get(i).getArrivalTime();
                processList.get(i).setWaitingTime(waitTime);
                totalWaitingTime += waitTime;
                currentTime += processList.get(i).getBurstTime();
                System.out.println("Process has been served: arrival time: " + processList.get(i).getArrivalTime() +
                        ", duration: " + processList.get(i).getBurstTime() +
                        ", waiting time: " + processList.get(i).getWaitingTime() +
                        ", completion time: " + currentTime);
                processList.remove(i);
                i = 0;
            } else {
                i++;
            }
            if(i >= processList.size()){
                currentTime++;
                i = 0;
            }
        }

        double averageWaitingTime = (double) totalWaitingTime / size;
        System.out.println("Average Waiting Time : " + averageWaitingTime);

    }

    // Algorytm RR
    public static void RR(Queue<Process> processes, int timeQuantum) {
        List<Process> processList = new ArrayList<>(processes);
        int size = processes.size();
        int currentTime = 0;
        int totalWaitingTime = 0;
        int index=0;

        while (!processList.isEmpty()) {
            Process currentProcess = processList.get(index);
            if(currentProcess.getArrivalTime() <= currentTime) {
                if (currentProcess.getBurstTime() <= timeQuantum) {
                    currentTime += currentProcess.getBurstTime();
                    int waitTime = currentTime - currentProcess.getArrivalTime() - currentProcess.getBurstTime();
                    currentProcess.setWaitingTime(waitTime);
                    totalWaitingTime += waitTime;
                    processList.remove(index);
                } else {
                    currentTime += timeQuantum;
                    currentProcess.setBurstTime(currentProcess.getBurstTime() - timeQuantum);
                }
            }
            index++;
            if(index >= processList.size()){
                currentTime++;
                index = 0;
            }
        }

        double averageWaitingTime = (double) totalWaitingTime / size;
        System.out.println("Average Waiting Time (RR): " + averageWaitingTime);
    }

}
