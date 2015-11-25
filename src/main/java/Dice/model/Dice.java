package Dice.model;

import java.util.Random;

/**
 * Created by diana on 01.11.15.
 */
public class Dice {

    private Roll roll;

    public Roll roll() {
        Random rnd = new Random();
        roll = new Roll(rnd.nextInt(6) + 1);
        return roll;
    }
}
