package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CarReservationOptimizerUtils {

    private CarReservationOptimizerUtils() {
    }

    /**
     * @return HashMap of sippCodes as a keys that stores according car model as a value
     */
    public static Map<String, String> mapOfSippCode() {
        Map<String, String> sippCodeMap = new HashMap<>();
        sippCodeMap.put("NBMR", "Fiat 500");
        sippCodeMap.put("MDMR", "Toyota Aygo");
        sippCodeMap.put("MDAR", "Kia Picanto A/T");
        sippCodeMap.put("MFAR", "Toyota Aygo X");
        sippCodeMap.put("EDMR", "Ford Fiesta");
        sippCodeMap.put("ECMR", "Toyota Yaris");
        sippCodeMap.put("EDMD", "Peugeot 208");
        sippCodeMap.put("EDAR", "Skoda Fabia A/T");
        sippCodeMap.put("EDAH", "Skoda Fabia A/T");
        sippCodeMap.put("EFAH", "Toyota Yaris Cross");
        sippCodeMap.put("CDMR", "Kia Ceed");
        sippCodeMap.put("CCMR", "Toyota Auris");
        sippCodeMap.put("CDAR", "Volkswagen Golf A/T");
        sippCodeMap.put("CWMR", "Kia Ceed SW");
        sippCodeMap.put("CXAR", "Audi A3");
        sippCodeMap.put("CWAR", "Kia Ceed SW A/T");
        sippCodeMap.put("CFMR", "Kia Xceed");
        sippCodeMap.put("CFAH", "Toyota CH-R Hybrid A/T");
        sippCodeMap.put("CDAH", "Toyota Corolla Hybrid A/T");
        sippCodeMap.put("CFAR", "Skoda Kamiq A/T");
        sippCodeMap.put("IFMR", "Skoda Karoq");
        sippCodeMap.put("IDMR", "Mazda 6");
        sippCodeMap.put("IFAR", "Mazda 6 A/T");
        sippCodeMap.put("IFAH", "Toyota Corolla Cross Hybrid A/T");
        sippCodeMap.put("SFMR", "Kia Sportage");
        sippCodeMap.put("SFAR", "Mazda CX-5 A/T");
        sippCodeMap.put("SVMR", "Dacia Jogger (5+2)");
        return sippCodeMap;
    }

    /**
     * @param carClass - car sippCode
     * @param higher   - boolean that checks if we're looking for higher of lower class
     * @return index (place of sippCode in array list) of sippCode to use from ArrayList
     */

    public static String getAdjacentCarClass(String carClass, boolean higher) {

        //TODO To work properly you have to put sippCodes in this array list according to car class levels so "NBMR" = lowest car class, "SVMR" = highest car class

        ArrayList<String> carClasses = new ArrayList<>(Arrays.asList("NBMR", "MDMR", "MDAR", "MFAR", "EDMR", "ECMR", "EDMD", "EDAR", "EDAH", "EFAH", "CDMR", "CCMR",
                "CDAR", "CWMR", "CXAR", "CWAR", "CFMR", "CFAH", "CDAH", "CFAR", "IFMR", "IDMR", "IFAR", "IFAH", "SFMR", "SFAR", "SVMR"));

        int index = carClasses.indexOf(carClass);
        if (index != -1) {
            if (higher && index < carClasses.size() - 1) {
                return carClasses.get(index + 1);
            } else if (!higher && index > 0) {
                return carClasses.get(index - 1);
            }
        }
        return null;
    }
}
