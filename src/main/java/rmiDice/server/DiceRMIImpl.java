package rmiDice.server;

/**
 * Created by diana on 01.11.15.
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;


public class DiceRMIImpl extends UnicastRemoteObject implements DiceRMI {

    public DiceRMIImpl() throws RemoteException{}

    public Roll roll() throws RemoteException {
        Random rnd = new Random();
        int random =rnd.nextInt(6)+1;
        System.out.println("random number: " + random);
        return new Roll(random);
    }

    public static void main(String[] args){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            DiceRMI service = new DiceRMIImpl();
            Naming.rebind("RemoteRoll", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
