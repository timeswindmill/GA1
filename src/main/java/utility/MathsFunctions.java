package utility;

import java.util.Random;

public class MathsFunctions {

    private static Random rand = new Random(System.currentTimeMillis());


    public static Long getRandomLong() {
        return rand.nextLong();
    }

    public static int getRandomInt(int max) {
        return rand.nextInt(max);
    }

    public static boolean getTrueFalse() {
        return rand.nextBoolean();

    }
}
