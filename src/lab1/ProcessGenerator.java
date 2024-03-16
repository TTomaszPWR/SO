package lab1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProcessGenerator {
    public static Queue<Process> generateProcesses(int n) {
        Random generator = new Random();
        Queue<Process> processes = new LinkedList<>();
        int time = 0;
        for(int i= 0; i < n; i++) {
            time+=generator.nextInt(5);
            processes.add(new Process(time, generator.nextInt(50) + 1));
        }
        return processes;
    }

    public static Queue<Process> starvingProcessesExample(){
        Queue<Process> processes = new LinkedList<>();

        processes.add(new Process(0, 3));
        processes.add(new Process(0, 15));
        processes.add(new Process(1, 3));
        processes.add(new Process(2, 2));
        processes.add(new Process(3, 4));
        processes.add(new Process(4, 5));
        processes.add(new Process(5, 1));
        processes.add(new Process(6, 2));
        processes.add(new Process(7, 5));
        processes.add(new Process(8, 2));
        processes.add(new Process(9, 1));
        return processes;
    }
}
