package model;

import java.util.Random;

/**
 * Created by diana on 01.11.15.
 */
public class Dice {
    int number;

    public void roll() {
        Random rnd = new Random();
        number = rnd.nextInt(6) + 1;
    }

    int getNumber() {
        return number;
    }

//    @Override
//    public String toString() {
//        return "number: " + number;
//    }
}
