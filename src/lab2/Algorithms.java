package lab2;

import java.util.ArrayList;

public class Algorithms {
    public static void FCFS(ArrayList<Request> requests, int startingPosition){
        int sum = 0;
        int current = startingPosition;
        System.out.println("FCFS:");
        for(Request request : requests){
            System.out.print(current+"->");
            sum += Math.abs(request.getPosition() - current);
            current = request.getPosition();
        }
        System.out.println(current);
        System.out.println("Displacement: "+sum);
    }
    public static void SSTF(ArrayList<Request> requests, int startingPosition){
        int sum = 0;
        int current = startingPosition;
        System.out.println("\nSSTF:");
        System.out.print(current+"->");
        while(!requests.isEmpty()){
            int min = Integer.MAX_VALUE;
            Request closest = null;
            for(Request request : requests){
                int distance = Math.abs(request.getPosition() - current);
                if(distance < min){
                    min = distance;
                    closest = request;
                }
            }
            sum += min;
            current = closest.getPosition();
            System.out.print(current+"->");
            requests.remove(closest);
        }
        System.out.println("END");
        System.out.println("Displacement: " + sum);
    }
    public static void SCAN(ArrayList<Request> requests, int startingPosition){
        int sum = 0;
        int current = startingPosition;
        boolean direction = false;
        System.out.println("\nSCAN:");
        System.out.print(current+"->");
        while (!requests.isEmpty()) {
            Request closest = null;
            for (Request request : requests) {
                if (!direction && request.getPosition() < current) {
                    if (closest == null || request.getPosition() > closest.getPosition()) {
                        closest = request;
                    }
                } else if (direction && request.getPosition() > current) {
                    if (closest == null || request.getPosition() < closest.getPosition()) {
                        closest = request;
                    }
                }
            }
            if (closest != null) {
                sum += Math.abs(closest.getPosition() - current);
                current = closest.getPosition();
                System.out.print(current + "->");
                requests.remove(closest);
            } else {
                direction = !direction;
                sum += Math.abs(current);
                current=0;
            }
        }
        System.out.println("END");
        System.out.println("Displacement: " + sum);
    }
    public static void CSCAN(ArrayList<Request> requests, int startingPosition, int diskSize){
        ArrayList<Request> clone =new ArrayList<>(requests);
        int sum = 0;
        int current = startingPosition;
        boolean direction = true;
        System.out.println("\nSCAN:");
        System.out.print(current+"->");
        while (!requests.isEmpty()) {
            Request closest = null;
            for (Request request : requests) {
                if (!direction && request.getPosition() < current) {
                    if (closest == null || request.getPosition() > closest.getPosition()) {
                        closest = request;
                    }
                } else if (direction && request.getPosition() > current) {
                    if (closest == null || request.getPosition() < closest.getPosition()) {
                        closest = request;
                    }
                }
            }
            if (closest != null) {
                sum += Math.abs(closest.getPosition() - current);
                current = closest.getPosition();
                System.out.print(current + "->");
                requests.remove(closest);
            } else {
                direction = !direction;
                current=0;
            }
        }

        sum += Math.abs(diskSize - clone.stream().max((a,b)->a.getPosition()-b.getPosition()).get().getPosition());
        System.out.println("END");
        System.out.println("Displacement: " + sum);
    }
}
