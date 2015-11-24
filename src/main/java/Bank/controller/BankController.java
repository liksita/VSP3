package Bank.controller;

import Bank.model.Bank;
import Bank.model.Transfer;
import Bank.service.BankService;
import Game.model.Game;
import com.google.gson.Gson;
import errors.ResponseError;

import java.util.ArrayList;

import static spark.Spark.*;
import static util.JsonUtil.json;


/**
 * /banks/{gameid}:
 * type: { item: { schema: "bank", "example":"" } }
 * put:
 * body:
 * application/json:
 * schema: game
 * /transfers:
 * type: { list: { schema: "transfer", "example":"" } }
 * /{transferid}:
 * get:
 * description: Gets a <<resourcePathName>>
 * responses:
 * 200:
 * body:
 * application/json:
 * schema: transfer
 * example: |
 * {}
 * /transfer/from/{from}/to/{to}/{amount}:
 * post:
 * description: creates a new bank transfer
 * body:
 * application/json:
 * schema: '{"type":"string", "required":true}'
 * example: Rent for Badstrasse
 * responses:
 * 201:
 * description: A new bank transfer has been created
 * body:
 * application/json:
 * schema: events
 * 403:
 * description: insufficient fonds
 * <p>
 * // 3. Zustands abfrage vom Spiel
 * get("/games/:gameid" , (req, res) -> {
 * res.header("Content-Type", "application/json");
 * String gameID = req.params(":gameid");
 * String gameGson = "http://0.0.0.0:4567/games/" + gameID;
 * <p>
 * Game game = gson.fromJson(gameGson, Game.class);
 * <p>
 * return gson.toJson(game.isStarted());
 * });
 */

public class BankController {

    public BankController(final BankService bankService) {

        after((req, res) -> {
            res.type("application/json");
        });

        //===========================================================
        // Get's a list of banks
        //===========================================================

        get("/banks", (req, res) -> bankService.getBanks(), json());

        //===========================================================
        // places a banks
        //===========================================================

        put("/banks/:gameid", (req, res) -> {

            String gameID = req.params(":gameid");

            //if bank already exists

            Bank bank = bankService.findBank(gameID);
            if (bank != null) {
                res.status(400);
                return new ResponseError(":( wrong gameID, such bank already exists");
            }

            // if game exists


            String gamesGson = "http://0.0.0.0:4567/games/";

            Gson gson = new Gson();
            ArrayList<Game> games = gson.fromJson(gamesGson, ArrayList.class);

            for (Game g : games) {
                if (g.getGameID().equals(gameID)) {
                    bankService.createBank(gameID);
                }
            }
            // if there is no such game
            res.status(400);
            return new ResponseError(":( wrong gameID");
        }, json());


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


        //===========================================================
        // List of available transfers
        //===========================================================
        get("/banks/:gameid/transfers", (req, res) -> bankService.getTransfers(req.params(":gameid")), json());

        //===========================================================
        // Gets details of a bank transfer
        //===========================================================

        get("/banks/:gameid/transfers/:transferid", (req, res) -> {
            Transfer transfer = bankService.findTransfers(req.params(":gameid"),req.params(":transferid"));
            if (transfer == null) {
                res.status(400);
                return new ResponseError(":( wrong transferID");
            }
            return transfer;
        }, json());

        //===========================================================
        // Creates a new bank transfer
        //===========================================================

        post("banks/:gameid/transfer/from/:from/to/:to/:amount", (req, res) -> {
            Transfer transfer = bankService.transferFromTo(req.params(":gameid"),req.params(":from"), req.params(":to"), req.params(":amount"));
            if (transfer == null) {
                res.status(400);
                return new ResponseError(":( wrong transferID");
            }
            return transfer;
        }, json());
    }
}
