package Dice.controller;
import com.google.gson.Gson;
import Dice.model.Dice;

import static spark.Spark.get;
/**
 * Created by diana on 01.11.15.
 */
public class DiceController {

    private static Gson gson = new Gson();
    private static Dice dice = new Dice();

    public static void main( String[] args) {
        get("/dice", (req, res) -> {
            dice.roll();
            return dice;
        }, gson::toJson);
    }
}
