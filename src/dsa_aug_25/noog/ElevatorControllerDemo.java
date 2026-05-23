package dsa_aug_25.noog;

import java.util.*;

class Command {
    int timestamp;
    int panelId;
    int targetFloor;

    public Command(int timestamp, int panelId, int targetFloor) {
        this.timestamp = timestamp;
        this.panelId = panelId;
        this.targetFloor = targetFloor;
    }
}

class Elevator {
    int elevatorId;
    int currentFloor;
    boolean active;

    public Elevator(int id, boolean active) {
        this.elevatorId = id;
        this.currentFloor = 1; // start at floor 1
        this.active = active;
    }

    public void moveElevator(int targetFloor) {
        if (!active) {
            System.out.println("Elevator " + elevatorId + " is inactive.");
            return;
        }

        while (currentFloor != targetFloor) {
            if (targetFloor > currentFloor) {
                ElevatorMove(+1);
                currentFloor++;
            } else {
                ElevatorMove(-1);
                currentFloor--;
            }
            System.out.println("Elevator " + elevatorId + " at floor: " + currentFloor);
        }
        System.out.println("Elevator " + elevatorId + " arrived at target floor: " + targetFloor);
    }

    private void ElevatorMove(int direction) {
        System.out.println("Elevator " + elevatorId + " moves " + (direction > 0 ? "up" : "down"));
    }
}

class ElevatorSystem {
    private List<Elevator> elevators = new ArrayList<>();
    private Queue<Command> commandQueue = new LinkedList<>();

    public ElevatorSystem() {
        // Initialize 4 elevators, only the first one active
        elevators.add(new Elevator(1, true));
        elevators.add(new Elevator(2, false));
        elevators.add(new Elevator(3, false));
        elevators.add(new Elevator(4, false));
    }

    public void receiveCommand(Command cmd) {
        commandQueue.add(cmd);
    }

    public void processCommands() {
        while (!commandQueue.isEmpty()) {
            Command cmd = commandQueue.poll();
            // For now, always assign to elevator 1 (active one)
            Elevator activeElevator = elevators.get(0);
            activeElevator.moveElevator(cmd.targetFloor);
        }
    }
}

public class ElevatorControllerDemo {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem();

        // Example commands
        system.receiveCommand(new Command(801, 1, 3));
        system.receiveCommand(new Command(802, 1, 7));
        system.receiveCommand(new Command(803, 9, 5));

        system.processCommands();
    }
}
