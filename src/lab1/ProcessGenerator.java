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
            processes.add(new Process(time, generator.nextInt(50) + 1));
            time+=generator.nextInt(5);
        }
        return processes;
    }

    public static Queue<Process> starvingProcessesExample(){
        Queue<Process> processes = new LinkedList<>();

        processes.add(new Process(0, 2));
        processes.add(new Process(0, 5));
        processes.add(new Process(1, 2));
        processes.add(new Process(3, 2));
        processes.add(new Process(5, 2));
        processes.add(new Process(7, 2));
        processes.add(new Process(9, 2));
        processes.add(new Process(11, 2));
        processes.add(new Process(13, 2));
        processes.add(new Process(15, 2));
        processes.add(new Process(17, 2));
        return processes;
    }
}
