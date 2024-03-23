package lab2;

import java.util.ArrayList;

import static lab2.Algorithms.*;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Request> requests = Generator.generateRequests(200, 8);
        ArrayList<Request> requests = Generator.exampleRequests();

        FCFS(new ArrayList<>(requests), 53);
        SSTF(new ArrayList<>(requests), 53);
        SCAN(new ArrayList<>(requests), 53);
        CSCAN(new ArrayList<>(requests), 53, 199);
    }
}
