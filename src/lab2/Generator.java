package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static ArrayList<Request> generateRequests(int diskSize, int n) {
        Random generator = new Random();
        ArrayList<Request> requests = new ArrayList<>();
        for(int i= 0; i < n; i++) {
            requests.add(new Request(generator.nextInt(diskSize) + 1));
        }
        return requests;
    }

    //98,183,37,122,14,124,65,67
    public static ArrayList<Request> exampleRequests(){
        return new ArrayList<>(List.of(
                new Request(98),
                new Request(183),
                new Request(37),
                new Request(122),
                new Request(14),
                new Request(124),
                new Request(65),
                new Request(67)
        ));
    }
}
