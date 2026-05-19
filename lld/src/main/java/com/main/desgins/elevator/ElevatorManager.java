package com.main.desgins.elevator;

import com.main.desgins.elevator.models.Elevator;
import com.main.desgins.elevator.models.ElevatorDirection;
import lombok.Getter;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

// look algo implemented
public class ElevatorManager implements Runnable {
    private final Object Monitor = new Object();
    @Getter
    public Elevator elevator;
    public PriorityBlockingQueue<Integer> upMinQueue;
    public PriorityBlockingQueue<Integer> downMaxQueue;

    ElevatorManager(Elevator elevator) {
        this.elevator = elevator;
        upMinQueue = new PriorityBlockingQueue<>();
        downMaxQueue = new PriorityBlockingQueue<>(10, Comparator.reverseOrder());
    }

    @Override
    public void run() {
        elevatorManger();
    }

    private void elevatorManger() {

        while (true) {
            // no req go to sleep
            synchronized (Monitor) {
                while (upMinQueue.isEmpty() && downMaxQueue.isEmpty()) {
                    try{
                        System.out.println("elevator manger waiting with elevator id as " + elevator.getId());
                        elevator.direction= ElevatorDirection.IDLE;
                        Monitor.wait();
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void submitRequest(int destinationFloor) {
        enqueueRequest(destinationFloor);
    }

    private void enqueueRequest(int destinationFloor) {
        System.out.println("Requesting " + destinationFloor + "accepted by " + this.elevator.id);
        if(destinationFloor == elevator.nextStoppage.getFloorNumber()){
            return;
        }
        if(destinationFloor >=elevator.nextStoppage.getFloorNumber()){
            if(!upMinQueue.contains(destinationFloor)){
                upMinQueue.offer(destinationFloor);
            }
        }
        else{
            if(!downMaxQueue.contains(destinationFloor)){ // this will be done while going down
                downMaxQueue.offer(destinationFloor);
            }
        }
        synchronized (Monitor) {
            Monitor.notify(); // wake the elevator thread
        }
    }

}
