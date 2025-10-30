package cz.malanak.Helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class PaymentCardHelper {
    private final int YEARS_VALID = 5;
    private final Random r = new Random();
    public String generateCardNumber() {
        return UUID.randomUUID().toString();
    }

    public int GenerateCcv() {
        return r.nextInt(0, 900) + 100;
    }

    public Date generateExpDate() {
        Calendar exp = Calendar.getInstance();
        exp.set(Calendar.HOUR_OF_DAY, 0);
        exp.set(Calendar.MINUTE, 0);
        exp.set(Calendar.SECOND, 0);
        exp.add(Calendar.YEAR, YEARS_VALID);
        return exp.getTime();
    }

    public int generatePin() {
        return r.nextInt(0, 9999);
    }
}
