package Bank.controller;

import Bank.model.Bank;
import Bank.model.Transfer;
import Bank.service.BankService;
import errors.ResponseError;

import java.util.ArrayList;

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
        get("/banks", (req, res) -> bankService.getBanks(), json());

        get("/banks/:gameid", (req, res) -> {
            // Bank !exist?
            Bank bank = bankService.findBank(req.params(":gameid"));
            if (bank == null) {
                res.status(400);
                return new ResponseError(":( wrong gameID");
            }
            return bank;
        }, json());

        put("/banks/:gameid", (req, res) -> {
            // Bank exist?
            Bank bank = bankService.createBank(req.params(":gameid"));
            if (bank == null) {
                res.status(400);
                return new ResponseError(":( wrong gameID");
            }
            return bank;
        }, json());

        //===========================================================
        // Transfer's
        //===========================================================
        get("/banks/:gameid/transfers", (req, res) -> {
            ArrayList<Transfer> transfers = bankService.getTransfers(req.params(":gameid"));
            if (transfers == null){
                res.status(400);
                return new ResponseError(":( wrong gameID");
            }
            return transfers;
        }, json());

        get("/banks/:gameid/transfers/:transferid", (req, res) -> {
            // Bank exist?
            Bank bank = bankService.createBank(req.params(":gameid"));
            if (bank == null) {
                res.status(400);
                return new ResponseError(":( wrong gameID");
            }

            // transferid correct
            Transfer transfer = bankService.findTransfer(bank, req.params(":transferid"));
            if(transfer== null){
                res.status(400);
                return new ResponseError(":( wrong transferID");
            }
            return transfer;
        }, json());

        post("//banks/:gameid/transfer/from/:from/to/:to/:amount", (req, res) -> {

                return new ResponseError(":( wrong gameID");


        }, json());
    }
}
