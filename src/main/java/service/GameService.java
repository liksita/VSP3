package service;

import model.Game;
import model.Player;

import java.util.ArrayList;

//import com.sun.tools.javac.util.List;

public class GameService {
    private static int gameID = 1;
    private static ArrayList<Game> games = new ArrayList<>();


    public static String getNextGameID() {
        return String.valueOf(gameID++);
    }

    public Game findGame(String gameID) {
        for (Game game : games) {
            if (game.getGameID().equals(gameID)) return game;
        }
        return null;
    }

    public Game createGame() {

        String neugameID = getNextGameID();
        Game game = new Game(neugameID);
        games.add(game);
        return game;

    }

    public Game addPlayer(String gameId, String playerId) {
        Game game = findGame(gameId);
        if (game != null) {
            Player player = new Player(playerId);
            game.addPlayer(player);
            return game;
        }

        return null;

    }

    public Player setPlayerReady(String gameId, String playerId) {
        Game game = findGame(gameId);
        if (game == null) {
            return null;
        }
        for (Player player : game.getPlayers()) {
            if (player.getPlayerID().equals(playerId)) {
                player.setReady();
                return player;
            }
        }
        return null;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}