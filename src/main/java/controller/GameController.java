package controller;

import errors.ResponseError;
import model.Game;
import model.Player;
import service.GameService;

import static spark.Spark.*;
import static util.JsonUtil.json;

//import com.sun.tools.javac.util.List;

public class GameController {

    public GameController(final GameService gameService) {

//        private static Gson gson = new Gson();

        after((req, res) -> {
            res.type("application/json");
        });

        get("/games", (req, res) -> gameService.getGames(), json());

        // Benutzer können mit dem Client ein neues Spiel eröffnen
//         post /games
        post("/games", (req, res) -> gameService.createGame(), json());

        // Benutzer können sich mit dem Client als Spieler registrieren
        // put /games/{gameid}/players/{playerid}
        put("/games/:gameid/players/:playerid", (req, res) -> {
            Game game = gameService.addPlayer(req.params(":gameid"), req.params(":playerid"));


            if (game != null) {
                return game;
            }
            res.status(400);
            return new ResponseError(":( wrong gameId");
        }, json());

//        // Benutzer können mit dem Client melden, dass sie fertig sind und das Spiel losgehen kann

        put("/games/:gameid/players/:playerid/ready", (req, res) -> {
            Player player = gameService.setPlayerReady(req.params(":gameid"), req.params(":playerid"));
            if (player == null) {
                res.status(400);
                return new ResponseError(":( no such player");
            }
            return player;
        }, json());


//        // Wenn alle Clients bereit sind, kann das Spiel beginnen – die erste Person muss anfangen zu würfeln!
//        // Achten Sie darauf, dass  für die verschiedenen Spielkomponenten auch unterschiedliche Hosts
//        // über- bzw. angegeben werden können
    }


}