package lab1;

import java.util.LinkedList;
import java.util.Queue;

import static lab1.CPUScheduler.*;
import static lab1.ProcessGenerator.generateProcesses;
import static lab1.ProcessGenerator.starvingProcessesExample;

public class Main {

    public static void main(String[] args) {
        Queue<Process> processes = generateProcesses(20);
        //Queue<Process> processes = starvingProcessesExample();


        System.out.println();
        System.out.println("FCFS:");
        FCFS(new LinkedList<>(processes));

        System.out.println();
        System.out.println("SJF:");
        SJF(new LinkedList<>(processes));

        System.out.println("RR:");
        RR(new LinkedList<>(processes), 20); // przykładowy kwant czasu dla RR
    }
}
