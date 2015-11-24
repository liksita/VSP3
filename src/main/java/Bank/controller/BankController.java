package Bank.controller;

import Bank.model.Bank;
import Bank.model.Transfer;
import Bank.service.BankService;
import errors.ResponseError;

import static spark.Spark.*;
import static util.JsonUtil.json;


/**
/banks/{gameid}:
    type: { item: { schema: "bank", "example":"" } }
    put:
        body:
            application/json:
                schema: game
    /transfers:
         type: { list: { schema: "transfer", "example":"" } }
         /{transferid}:
             get:
                 description: Gets a <<resourcePathName>>
                 responses:
                    200:
                     body:
                         application/json:
                             schema: transfer
                             example: |
                               {}
     /transfer/from/{from}/to/{to}/{amount}:
         post:
             description: creates a new bank transfer
             body:
                 application/json:
                    schema: '{"type":"string", "required":true}'
                    example: Rent for Badstrasse
             responses:
                 201:
                     description: A new bank transfer has been created
                     body:
                         application/json:
                             schema: events
                 403:
                    description: insufficient fonds
*/

public class BankController {

    public BankController(final BankService bankService) {

        // private static Gson gson = new Gson();
        after((req, res) -> {
            res.type("application/json");
        });


        //===========================================================
        // Bank's
        //===========================================================
        get("/banks/:gameid", (req, res) -> {
            Bank bank = bankService.findBank(req.params(":gameid"));
            if (bank == null) {
                res.status(400);
                return new ResponseError(":( wrong gameID");
            }
            return bank;
        }, json());

        put("/banks/:gameid", (req, res) -> {
            Bank bank = bankService.findBank(req.params(":gameid"));
            if (bank != null) {
                res.status(400);
                return new ResponseError(":( wrong gameID");
            }
            return bank;
        }, json());

        //===========================================================
        // Transfer's
        //===========================================================
        get("/banks/transfers", (req, res) -> {
            return bankService.getTransfers();
        }, json());

        get("/banks/transfers/:transferid", (req, res) -> {
            Transfer transfer = bankService.findTransfers(req.params(":transferid"));
            if(transfer== null){
                res.status(400);
                return new ResponseError(":( wrong transferID");
            }
            return transfer;
        }, json());

        post("/transfer/from/:from/to/:to/:amount", (req, res) -> {
            Transfer transfer = bankService.transferFromTo(req.params(":transferid"), req.params(":to"),req.params(":amount"));
            if(transfer== null){
                res.status(400);
                return new ResponseError(":( wrong transferID");
            }
            return transfer;
        }, json());
    }
}
