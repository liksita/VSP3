package Bank.service;

import Bank.model.Bank;
import Bank.model.Transfer;

import java.util.ArrayList;

/**
 * Created by m on 24.11.15.
 */
public class BankService {
    private ArrayList<Bank> banks = new ArrayList<>();


    public Bank findBank(String gameID) {
        for (Bank bank : banks) {
            if (bank.getBankID().equals(gameID)) {
                return bank;
            }
        }
        return null;
    }

    public ArrayList<Transfer> getTransfers(String gameID) {
        Bank bank = findBank(gameID);
        return bank.getTransfers();
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public Bank createBank(String gameID) {

        Bank bank = new Bank(gameID);
        banks.add(bank);
        return bank;
    }

//    public HashMap<String, Account> getAccounts() {
//        return accounts;
//    }

    public Transfer findTransfers(String gameID, String transferID) {

        for (Transfer transfer : getTransfers(gameID)) {
            if(transfer.getID().equals(transferID)) return transfer;
        }
        return null;
    }

    public Transfer transferFromTo(String gameID, String from, String to, String amount) {
        Bank bank = findBank(gameID);

        return null;
    }
}
