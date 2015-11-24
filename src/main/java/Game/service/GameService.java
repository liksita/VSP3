package Game.service;

import Game.model.Game;
import Player.model.Player;
import com.mashape.unirest.http.Unirest;

import java.util.ArrayList;
import java.util.HashMap;

public class GameService {
    private static int gameID = 0;
    private static ArrayList<Game> games = new ArrayList<>();
    private HashMap<String, String> services = new HashMap<>();

    public GameService(HashMap<String, String> services) {
        this.services = services;
    }

    public static String getNextGameID() {
        return String.valueOf(gameID++);
    }

    public Game createGame() {
        String neugameID = getNextGameID();
        Game game = new Game(neugameID);
        games.add(game);

        return game;
    }

    public Game findGame(String gameID) {
        for (Game game : games) {
            if (game.getGameID().equals(gameID)) return game;
        }
        return null;
    }

    public Game addPlayer(String gameId, String playerId) {
        Game game = findGame(gameId);
        Player player = new Player(playerId);

        if (!game.contains(player)) {
            game.addPlayer(player);
            return game;
        }
        return null;
    }

    public Player getPlayer(String gameId, String playerId) {
        Game game = findGame(gameId);

        for (Player player : game.getPlayers()) {
            if (player.getPlayerID().equals(playerId)) {
                return player;
            }
        }
        return null;
    }

    public Player setPlayerReady(String gameId, String playerId) {
        Game game = findGame(gameId);
        boolean gameIsStarted = game.readyToStart();

        if (!gameIsStarted) {
            Player player = getPlayer(gameId, playerId);
            player.setReady();
            gameIsStarted = game.readyToStart();
            if (gameIsStarted) {
                String banksuri = services.get("banks");
                Unirest.post(banksuri + "/" + gameId);
            }
        }
        return null;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void isReady(String params) {
        Game game = findGame(params);

    }
}