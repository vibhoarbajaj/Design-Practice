package com.main.desgins.elevator.models;

import lombok.Data;


@Data
public class Elevator {

    public int id;

    public Floor currentFloor;
    // because we want that if the next floor is once set no floor in between can add itself in the queue
    public Floor nextStoppage;

    public ElevatorDirection direction;

    public Door door;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = new Floor(0,null);
        this.nextStoppage = new Floor(-1,null);
        door = new Door();
    }

    public void moveElevator(int destinationFloor, int floorId){
        //this is a dump obj , so if a cmd comes , to go to a particular dir/floor , it just moves no matter what its current state is
        this.nextStoppage= new Floor(destinationFloor,null);
        if(this.currentFloor.getFloorNumber()==nextStoppage.getFloorNumber()){
            door.openDoor(id);
            return;
        }
        int startFloor=currentFloor.getFloorNumber();
        if(nextStoppage.getFloorNumber()>currentFloor.getFloorNumber()){
            direction = ElevatorDirection.UP;
            for(int i = startFloor+1;i<=nextStoppage.getFloorNumber();i++){
                try {
                    Thread.sleep(5);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setCurrentFloor(new Floor(i,null));
            }
        }
        else{
            direction = ElevatorDirection.DOWN;
            for(int i = startFloor-1;i>=nextStoppage.getFloorNumber();i--){
                try {
                    Thread.sleep(5);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setCurrentFloor(new Floor(i,null));

            }
        }
        door.openDoor(id);
    }


}
