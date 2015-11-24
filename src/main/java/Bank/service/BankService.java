package Bank.service;

import Bank.model.Account;
import Bank.model.Bank;
import Bank.model.Transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by m on 24.11.15.
 */
public class BankService {
    private HashMap<String, Bank> banks       = new LinkedHashMap<>();
    private HashMap<String, Account> accounts = new LinkedHashMap<>();
    private ArrayList<Transfer> transfers     = new ArrayList<>();

    public Bank findBank(String gameID) {
        return banks.get(gameID);
    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }

    public Transfer findTransfers(String transferID) {
        for (Transfer transfer :transfers) {
            if(transfer.getID().equals(transferID)) return transfer;
        }
        return null;
    }

    public Transfer transferFromTo(String from, String to, String amount) {
        return null;
    }
}
