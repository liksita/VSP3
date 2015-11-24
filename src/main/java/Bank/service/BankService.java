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

    private static  ArrayList<Bank> banks = new ArrayList<>();

    public Bank createBank(String gameID) {
        if (findBank(gameID) == null){
            Bank bank = new Bank(gameID);
            banks.add(bank);
            return bank;
        }
        return null;
    }

    public Bank findBank(String gameID) {
        for (Bank bank: banks) {
            if (bank.getBankID().equals(gameID)) return bank;
        }
        return null;
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

    public ArrayList<Bank> getBanks() {
        return banks;
    }
}
