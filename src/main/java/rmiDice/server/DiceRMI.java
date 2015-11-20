package rmiDice.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by diana on 01.11.15.
 */
public interface DiceRMI extends Remote {
    Roll roll() throws RemoteException;
}