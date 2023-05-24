package service;

import model.Car;
import model.Reservation;

import java.util.*;

import static utils.CarReservationOptimizerUtils.getAdjacentCarClass;
import static utils.CarReservationOptimizerUtils.mapOfSippCode;

public class ReservationService {

    private static final String WOLNY = "wolny";
    private static final String ZAREZERWOWANY = "zarezerwowany";

    /**
     * @param reservations - list of reservations
     * @param cars         - list of cars
     * @return - List of matching reservations with cars already added to each reservation
     */
    public List<Reservation> optimizeReservations(List<Reservation> reservations, List<Car> cars) {
        List<Reservation> optimizedReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            Car availableCar = findAvailableCar(reservation, cars);
            if (availableCar != null) {
                optimizedReservations.add(reservation);
                availableCar.setStatus(ZAREZERWOWANY);
                availableCar.setAvailableFrom(reservation.getReturnDateTime());
                availableCar.setCarModel(mapOfSippCode().get(availableCar.getSippCode()));
                reservation.setCar(availableCar);
            }
        }
        return optimizedReservations;
    }

    /**
     * @param reservation - list of reservations
     * @param cars        - list of cars
     * @return Car - returning car that fits to reservation rules
     * <p>
     * At this point method only checks one level higher class
     * and one level lower class - might change to look further down the line
     */
    private Car findAvailableCar(Reservation reservation, List<Car> cars) {
        Car availableCar = null;

        // First, try to find a car with the specified car class
        availableCar = findMatchingCar(reservation, cars, reservation.getSippCode());

        // If the specified car class is not available, try adjacent car classes
        if (availableCar == null) {
            String adjacentCarClassHigher = getAdjacentCarClass(reservation.getSippCode(), true);
            String adjacentCarClassLower = getAdjacentCarClass(reservation.getSippCode(), false);

            // Try lower class
            if (adjacentCarClassLower != null) {
                availableCar = findMatchingCar(reservation, cars, adjacentCarClassLower);
            }
            // Try higher car class
            if (adjacentCarClassHigher != null && availableCar == null) {
                availableCar = findMatchingCar(reservation, cars, adjacentCarClassHigher);
            }

        }

        return availableCar;
    }

    /**
     *
     * @param reservation reservation list
     * @param cars cars list
     * @param adjacentCarClass car class that is -1/0/+1 levels compared to given sippCode
     * @return Car that match all business requirements
     */
    private Car findMatchingCar(Reservation reservation, List<Car> cars, String adjacentCarClass) {
        Car availableCar;
        availableCar = cars.stream()
                .filter(car -> car.getStatus().equals(WOLNY))
                .filter(car -> car.getSippCode().equals(adjacentCarClass))
                .filter(car -> car.getAvailableFrom().isBefore(reservation.getPickupDateTime())
                        || car.getAvailableFrom().isEqual(reservation.getPickupDateTime()))
                .findFirst()
                .orElse(null);
        return availableCar;
    }
}
