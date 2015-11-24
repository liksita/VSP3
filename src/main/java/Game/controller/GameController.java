package Game.controller;

import errors.ResponseError;
import Game.model.Game;
import Player.model.Player;
import Game.service.GameService;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.*;
import static util.JsonUtil.json;

//import com.sun.tools.javac.util.List;

public class GameController {

    public GameController(final GameService gameService, HashMap<String, String> services) {

        after((req, res) -> {
            res.type("application/json");
        });

        //===========================================================
        // GAME's
        //===========================================================
        // alle vorhandene spile anzeigen
        get("/games", (req, res) -> gameService.getGames(), json());

        // spielstand ausgeben
        get("/games/:gameid", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }
            return game;
        }, json());

        // Benutzer können mit dem Client ein neues Spiel eröffnen = post /games
        post("/games", (req, res) -> gameService.createGame(), json());

        //===========================================================
        // PLAYER's
        //===========================================================
        // Benutzer können sich mit dem Client als Spieler registrieren =  put /games/{gameid}/players/{playerid}
        put("/games/:gameid/players/:playerid", (req, res) -> {

            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            if(game.readyToStart()){
                res.status(400);
                return new ResponseError(":( game is started");
            }

            // prüfe ob spieler mit gleiche ID schon registriert ist
            game = gameService.addPlayer(req.params(":gameid"), req.params(":playerid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( player exist");
            }

            // wurde geklappt
            res.status(200);
            return game;
        }, json());


        // Benutzer können mit dem Client melden, dass sie fertig sind und das Spiel losgehen kann
        put("/games/:gameid/players/:playerid/ready", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            // prüfe ob spieler mit eingegebene ID existiert
            Player player = gameService.setPlayerReady(req.params(":gameid"), req.params(":playerid"));
            if (player == null) {
                res.status(400);
                return new ResponseError(":( no such player");
            }

            //prüfe ob alle ready sind
            // Wenn alle Clients bereit sind, kann das Spiel beginnen – die erste Person muss anfangen zu würfeln!
            // Achten Sie darauf, dass  für die verschiedenen Spielkomponenten auch unterschiedliche Hosts
            // über- bzw. angegeben werden können
            gameService.isReady(req.params(":gameid"));
            return player;

        }, json());
    }


}