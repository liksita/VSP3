package Game.service;

import Game.model.Game;
import Player.model.Player;

import java.util.ArrayList;

//import com.sun.tools.javac.util.List;

public class GameService {
    private static int gameID = 0;
    private static ArrayList<Game> games = new ArrayList<>();


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

        // мой вариант

        /*
        //gameID prüfen.
        Integer igameID = Integer.getInteger(gameID);
        if(igameID != null){
            return games.get(igameID);
        }
        */


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

    public Player setPlayerReady(String gameId, String playerId) {
        Game game = findGame(gameId);

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