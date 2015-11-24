package Bank.model;

import java.util.ArrayList;

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
    private ArrayList<Transfer> transfers;
//    private HashMap<String, Account> accounts = new LinkedHashMap<>();

    public Bank(String bankID) {
        this.bankID = bankID;

    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }

    public void addTransfer() {

    }

    public String getBankID() {
        return bankID;
    }
}
