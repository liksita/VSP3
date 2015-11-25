package Game.controller;

import errors.ResponseError;
import Game.model.Game;
import Player.model.Player;
import Game.service.GameService;

import static spark.Spark.*;
import static util.JsonUtil.json;

//import com.sun.tools.javac.util.List;

public class GameController {

    public GameController(final GameService gameService) {

        after((req, res) -> {
            res.type("application/json");
        });

        //===========================================================
        // GAME's
        //===========================================================
        // alle vorhandene spiele anzeigen
        get("/games", (req, res) -> gameService.getGames(), json());

        // Benutzer können mit dem Client ein neues Spiel eröffnen
        post("/games", (req, res) -> {
            res.status(201);
            return  gameService.createGame();
        }, json());

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

        //===========================================================
        // PLAYER's /games/:gameid/players/:playerid
        //===========================================================
        // returns all joined players
        get("/games/:gameid/players", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }
            return game.getPlayers();
        }, json());

        // Gets a {gameid}players
        get("/games/:gameid/players/:playerid", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            Player player = gameService.getPlayer(req.params(":gameid"),req.params("playerid"));
            if(player == null){
                return new ResponseError(":( player not exist");
            }
            return player;
        }, json());


        // Benutzer können sich mit dem Client als Spieler registrieren =  put /games/{gameid}/players/{playerid}
        put("/games/:gameid/players/:playerid", (req, res) -> {

            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            // spiel is started?
            if(game.readyToStart()){
                res.status(400);
                return new ResponseError(":( game is started");
            }

            // player exist?
            Player player = gameService.getPlayer(req.params(":gameid"),req.params("playerid"));
            if(player == null){
                return new ResponseError(":( wrong playerId");
            }

            // prüfe ob spieler mit gleiche ID schon registriert ist
            game = gameService.addPlayer(req.params(":gameid"), req.params(":playerid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( player with same ID exist");
            }

            // wurde geklappt
            res.status(200);
            return game;
        }, json());

        //  Removes the player from the game
        delete("/games/:gameid/players/:playerid", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            // player exist?
            Player player = gameService.getPlayer(req.params(":gameid"),req.params("playerid"));
            if(player == null){
                return new ResponseError(":( player not exist, wrong player ID");
            }

           return gameService.deletePlayer(req.params(":gameid"),req.params("playerid"));
        }, json());

        //===========================================================
        // PLAYER's /games/:gameid/players/:playerid/ready
        //===========================================================
        // Benutzer können mit dem Client melden, dass sie fertig sind und das Spiel losgehen kann
        put("/games/:gameid/players/:playerid/ready", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            // prüfe ob spieler mit eingegebene ID existiert
            // wird auch geprüft, ob alle ready sind
            Player player = gameService.setPlayerReady(req.params(":gameid"), req.params(":playerid"));
            if (player == null) {
                res.status(400);
                return new ResponseError(":( no such player");
            }

            // Wenn alle Clients bereit sind, kann das Spiel beginnen – die erste Person muss anfangen zu würfeln!
            // Achten Sie darauf, dass  für die verschiedenen Spielkomponenten auch unterschiedliche Hosts
            // über- bzw. angegeben werden können
            return player;

        }, json());

        // tells if the player is ready to start the game
        get("/games/:gameid/players/:playerid/ready", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            // prüfe ob spieler mit eingegebene ID existiert
            Player player = gameService.getPlayer(req.params(":gameid"), req.params(":playerid"));
            if (player == null) {
                res.status(400);
                return new ResponseError(":( no such player");
            }

            return player.getReady();
        }, json());

        //===========================================================
        // PLAYER's /games/:gameid/players/current
        //===========================================================
        //  gets the currently active player that shall take action
        get("/games/:gameid/players/current", (req, res) -> {
            //prüfe ob spiel exiestiert
            Game game = gameService.findGame(req.params(":gameid"));
            if (game == null) {
                res.status(400);
                return new ResponseError(":( wrong gameId");
            }

            // ToDo
            return null;
        }, json());


        // ===========================================================
        // PLAYER's /games/:gameid/players/turn
        // ===========================================================
        // ToDo
        //  gets the player holding the turn mutex
        //  tries to aquire the turn mutex
        //  releases the mutex
    }
}