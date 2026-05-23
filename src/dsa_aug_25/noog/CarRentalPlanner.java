package dsa_aug_25.noog;

import java.util.*;

class RentalRecord {
    int id;
    int pickupTime;
    int returnTime;

    public RentalRecord(int id, int pickupTime, int returnTime) {
        this.id = id;
        this.pickupTime = pickupTime;
        this.returnTime = returnTime;
    }
}

class RentalAssignment {
    int rentalId;
    int carId;

    public RentalAssignment(int rentalId, int carId) {
        this.rentalId = rentalId;
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Rental " + rentalId + " → Car " + carId;
    }
}

public class CarRentalPlanner {

    public static List<RentalAssignment> assignCars(List<RentalRecord> rentals) {
        // Sort rentals by pickup time
        rentals.sort(Comparator.comparingInt(r -> r.pickupTime));

        // Min-heap to track earliest available car (by return time)
        PriorityQueue<int[]> carHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Map rental ID to car ID
        List<RentalAssignment> assignments = new ArrayList<>();
        int nextCarId = 0;

        for (RentalRecord rental : rentals) {
            // Reuse car if available
            if (!carHeap.isEmpty() && carHeap.peek()[0] <= rental.pickupTime) {
                int[] car = carHeap.poll();
                assignments.add(new RentalAssignment(rental.id, car[1]));
                carHeap.offer(new int[]{rental.returnTime, car[1]});
            } else {
                // Allocate new car
                assignments.add(new RentalAssignment(rental.id, nextCarId));
                carHeap.offer(new int[]{rental.returnTime, nextCarId});
                nextCarId++;
            }
        }

        return assignments;
    }

    public static void main(String[] args) {
        List<RentalRecord> rentals = List.of(
                new RentalRecord(0, 1, 5),
                new RentalRecord(1, 2, 6),
                new RentalRecord(2, 6, 8),
                new RentalRecord(3, 5, 9),
                new RentalRecord(4, 10, 12)
        );

        List<RentalAssignment> result = assignCars(rentals);
        System.out.println("Total cars needed: " + result.stream().mapToInt(r -> r.carId).max().orElse(-1) + 1);
        result.forEach(System.out::println);
    }
}

