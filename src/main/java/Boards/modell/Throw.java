package Boards.modell;

import Dice.model.Roll;

/**

 - throw: |
 {
     "type":        "object",
     "$schema":     "http://json-schema.org/draft-03/schema",
     "id":          "throw",
     "required":    true,
     "description": "two rolls together as a throw",
     "properties":  {
         "roll1": {
            "$ref":     "roll",
            "required": true
         },
         "roll2": {
            "$ref":     "roll",
            "required": true
        }
     }
 }
 */
public class Throw {

    private Roll roll1;
    private Roll roll2;

    public Throw(Roll roll1, Roll roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    public Roll getRoll1() {
        return roll1;
    }

    public void setRoll1(Roll roll1) {
        this.roll1 = roll1;
    }

    public Roll getRoll2() {
        return roll2;
    }

    public void setRoll2(Roll roll2) {
        this.roll2 = roll2;
    }
}
