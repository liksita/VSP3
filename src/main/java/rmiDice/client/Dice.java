package rmiDice.client;

/**
 * Created by diana on 01.11.15.
  */
import rmiDice.server.DiceRMI;

import java.rmi.Naming;

public class Dice {

    public void roll() {

        try {
            DiceRMI remoteDice = (DiceRMI) Naming.lookup("rmi://127.0.0.1/RemoteRoll");
            int roll = remoteDice.roll().getNumber();
            System.out.println(roll);

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg){
        new Dice().roll();
    }

}
