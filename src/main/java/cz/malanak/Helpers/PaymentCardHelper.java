package cz.malanak.Helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class PaymentCardHelper {

    private static Random r = new Random();
    public static String generateCardNumber() {
        return UUID.randomUUID().toString();
    }

    public static int GenerateCcv() {
        return r.nextInt(0, 900) + 100;
    }

    public static Date generateExpDate() {
        Calendar exp = Calendar.getInstance();
        exp.set(Calendar.HOUR_OF_DAY, 0);
        exp.set(Calendar.MINUTE, 0);
        exp.set(Calendar.SECOND, 0);
        exp.add(Calendar.YEAR, 5);
        Date exp_date = exp.getTime();
        return exp_date;
    }
}
