import model.Car;
import model.Reservation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import reader.JsonReader;
import service.ReservationService;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class to run our program and display result
 */
public class CarReservationOptimizer {
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        List<Reservation> reservationList = jsonReader.readReservationFromJson("rezerwacje.json");
        List<Car> carList = jsonReader.readCarsFromJson("stan_aut.json");
        ReservationService reservationService = new ReservationService();
        List<Reservation> optimizedReservations = reservationService.optimizeReservations(reservationList, carList);
        for (Reservation reservation : optimizedReservations) {
            System.out.println("Numer rezerwacji: " + reservation.getReservationNumber());
            System.out.println("Data wydania: " + reservation.getPickupDateTime());
            System.out.println("Data zwrotu: " + reservation.getReturnDateTime());
            System.out.println("Samochód: " + reservation.getCar().toString());
            System.out.println("--------------------------------------KOLEJNA REZERWACJA-------------------------------------");
        }
    }
}
