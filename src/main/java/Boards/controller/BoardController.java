package Boards.controller;

import Boards.service.BoardService;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;
import static util.JsonUtil.json;

/**
 * Created by m on 25.11.15.
 */
public class BoardController {

    // /boards

    public BoardController(final BoardService boardService) {
        after((req, res) -> {
            res.type("application/json");
        });

        //===========================================================
        // ...'s
        //===========================================================
        // returns all active games (both running and joinable)
        get("/boards", (req, res) -> boardService.getGames(), json());

       /* // Benutzer können mit dem Client ein neues Spiel eröffnen
        post("/games", (req, res) -> {
            res.status(201);
            return  gameService.createGame();
        }, json());
*/


    }
}
