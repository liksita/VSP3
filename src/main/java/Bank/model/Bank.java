package Bank.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 schema:
     - bank: |
     {
         "type":    "object",
         "$schema": "http://json-schema.org/draft-03/schema",
         "id":      "bank",
         "properties": {
         }
     }
 */
public class Bank {
    private String bankID;
    private HashMap<String, Account> accounts = new LinkedHashMap<>();
    private ArrayList<Transfer> transfers     = new ArrayList<>();

    public Bank(String bankID) {
        this.bankID = bankID;
    }

    public String getBankID() {
        return bankID;
    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }

    public void addTransfers(Transfer transfer) {
        transfers.add(transfer);
    }
}
