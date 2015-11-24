package Bank;

import Bank.controller.BankController;
import Bank.service.BankService;

/**
 * Created by diana on 24.11.15.
 */
public class BankApplication {
    public static void main(String[] args) {
        new BankController(new BankService());
    }
}
