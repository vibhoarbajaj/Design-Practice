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
                    try {
                        System.out.println("elevator manger waiting with elevator id as " + elevator.getId());
                        elevator.direction = ElevatorDirection.IDLE;
                        Monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                while (!upMinQueue.isEmpty()) {
                    int floor = upMinQueue.poll();
                    System.out.println("serving floor " + floor + " by elevator id " + elevator.getId() + " current floor " + elevator.currentFloor.getFloorNumber());
                    elevator.moveElevator(floor, 1234);
                }
                while (!downMaxQueue.isEmpty()) {
                    int floor = downMaxQueue.poll();
                    System.out.println("serving floor " + floor + " by elevator id " + elevator.getId() + " current floor " + elevator.currentFloor.getFloorNumber());
                    elevator.moveElevator(floor, 1234);
                }
            }

        }
    }

    public void submitRequest(int destinationFloor) {
        enqueueRequest(destinationFloor);
    }

    private void enqueueRequest(int destinationFloor) {
        System.out.println("Requesting " + destinationFloor + "accepted by " + this.elevator.id);
        if (destinationFloor == elevator.nextStoppage.getFloorNumber()) {
            return;
        }
        if (destinationFloor >= elevator.nextStoppage.getFloorNumber()) {
            if (!upMinQueue.contains(destinationFloor)) {
                upMinQueue.offer(destinationFloor);
            }
        } else {
            if (!downMaxQueue.contains(destinationFloor)) { // this will be done while going down
                downMaxQueue.offer(destinationFloor);
            }
        }
        synchronized (Monitor) {
            Monitor.notify(); // wake the elevator thread
        }
    }

}

// thread ex

/**
 * public class Main {
 *     public static void main(String[] args) {
 *
 *         Elevator elevator = new Elevator(1);
 *         ElevatorManager manager = new ElevatorManager(elevator);
 *
 *         // Thread 1 — elevator thread running in background
 *         Thread elevatorThread = new Thread(manager);
 *         elevatorThread.start();
 *
 *         // Thread 2 — User 1 pressing button on floor 5
 *         Thread user1 = new Thread(() -> {
 *             System.out.println("User 1 requesting floor 5");
 *             manager.submitRequest(5);
 *         });
 *
 *         // Thread 3 — User 2 pressing button on floor 10 at same time
 *         Thread user2 = new Thread(() -> {
 *             System.out.println("User 2 requesting floor 10");
 *             manager.submitRequest(10);
 *         });
 *
 *         // Thread 4 — User 3 pressing button on floor 3 at same time
 *         Thread user3 = new Thread(() -> {
 *             System.out.println("User 3 requesting floor 3");
 *             manager.submitRequest(3);
 *         });
 *
 *         // all users press button simultaneously
 *         user1.start();
 *         user2.start();
 *         user3.start();
 *     }
 * }
 */
