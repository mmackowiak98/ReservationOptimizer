package reader;

import model.Car;
import model.Reservation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that take responsibility of reading JSON files
 * and creating object with retrieved data
 */
public class JsonReader {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");

    public List<Reservation> readReservationFromJson(String jsonFilePath) {
        List<Reservation> reservationList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(jsonFilePath);
            JSONTokener tokener = new JSONTokener(fileReader);
            JSONArray reservationsArray = new JSONArray(tokener);

            for (int i = 0; i < reservationsArray.length(); i++) {
                JSONObject reservationObject = reservationsArray.getJSONObject(i);
                int reservationNumber = reservationObject.getInt("reservationNumber");
                String sippCode = reservationObject.getString("sippCode");

                LocalDateTime pickupDateTime = LocalDateTime.parse(reservationObject.getString("pickupDateTime"), formatter);
                LocalDateTime returnDateTime = LocalDateTime.parse(reservationObject.getString("returnDateTime"), formatter);

                Reservation reservation = new Reservation(reservationNumber, pickupDateTime, returnDateTime, sippCode);
                reservationList.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservationList;
    }

    public List<Car> readCarsFromJson(String jsonFilePath) {
        List<Car> cars = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(jsonFilePath);
            JSONTokener tokener = new JSONTokener(fileReader);
            JSONArray carStatusArray = new JSONArray(tokener);

            for (int i = 0; i < carStatusArray.length(); i++) {
                JSONObject carStatusObject = carStatusArray.getJSONObject(i);

                String plateNumber = carStatusObject.getString("plateNumber");
                String sippCode = carStatusObject.getString("sippCode");
                String status = carStatusObject.getString("status");


                LocalDateTime availableFrom = LocalDateTime.parse(carStatusObject.getString("availableFrom"), formatter);


                Car car = new Car(plateNumber, sippCode, status, availableFrom);
                cars.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }
}
