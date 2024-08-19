package tek.bdd.utility;

import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator {
    public static String generateRandomPassword() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString() + "@gmail.com";

    }


    }


