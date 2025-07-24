package service;

import java.util.Random;

public class AccountGeneration {
    public static long generateAccountNumber() {
        Random random = new Random();
        return 1_000_000_000L + random.nextInt(900_000_000);
    }
}
