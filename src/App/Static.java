/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.util.Calendar;

/**
 *
 * @author hieun
 */
public class Static {

    public static String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
    public static String PHONE_PATTERN = "^(0\\d{9}|1800\\d{6}|1900\\d{6})$";

    public static String getCurrentDate() {

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        return String.format("%d-%d-%d", year, month, day);
    }

    public static String generateId(String idPrefix) {

        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return switch (idPrefix) {
            case "PM" ->
                "PM-" + String.format("%02d%02d%d%02d%02d%02d", year, month, date, hour, minute, second);
            case "PT" ->
                "PT-" + String.format("%02d%02d%d%02d%02d%02d", year, month, date, hour, minute, second);
            case "PN" ->
                "PT-" + String.format("%02d%02d%d%02d%02d%02d", year, month, date, hour, minute, second);
            case "PP" ->
                "PT-" + String.format("%02d%02d%d%02d%02d%02d", year, month, date, hour, minute, second);
            default ->
                "Error!";
        };
    }
}
