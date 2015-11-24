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
    private HashMap<String, Bank> banks = new LinkedHashMap<>();

    public Bank createBank(String gameID) {
        if (findBank(gameID) == null){
            return null;
        }

        Bank bank = new Bank(gameID);
        banks.put(gameID, bank);
        return bank;
    }

    public Bank findBank(String gameID) {
        return banks.get(gameID);
    }

    public ArrayList<Transfer> getTransfers(String gameID) {
        Bank bank = findBank(gameID);
        return bank.getTransfers();
    }

    public Transfer findTransfer(Bank bank, String transferID) {
        ArrayList<Transfer> transfers = bank.getTransfers();

        for (Transfer transfer : transfers) {
            if (transfer.getID().equals(transferID)) return transfer;
        }
        return null;
    }

    public Transfer transferFromTo(Bank bank, String from, String to, String amount) {
        return null;
    }

}
