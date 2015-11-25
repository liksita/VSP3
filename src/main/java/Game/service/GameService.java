package Game.service;

import Game.model.Game;
import Player.model.Player;
import com.mashape.unirest.http.Unirest;
import util.SettingsReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameService {
    private static int gameID = 0;
    private static ArrayList<Game> games = new ArrayList<>();
    private HashMap<String, String> services = new HashMap<>();

    //==================================================================
    // Game's
    //==================================================================
    public static String getNextGameID() {
        return String.valueOf(gameID++);
    }

    public ArrayList<Game> getGames() {
        return games;
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

    //==================================================================
    // Player
    //==================================================================
    public Game addPlayer(String gameId, String playerID) {
        Game game = findGame(gameId);
        if (game.addPlayer(playerID)) {
            return game;
        }
        //player exist
        return null;
    }

    public Player getPlayer(String gameId, String playerId) {
        Game game = findGame(gameId);
        return game.getPlayer(playerId);
    }

    public Player setPlayerReady(String gameId, String playerId) {
        Game game = findGame(gameId);

        // wenn spiel nicht gestartet ist, dann registriere player als "ready"
        if (!game.readyToStart()) {
            Player player = getPlayer(gameId, playerId);
            player.setReady();
            //prüffe, ob der player, der letzte "ready"-player ist. wenn ja, dann kann Spiel starten
            if (game.readyToStart()) {
                //inizialisiere bank
                try {
                    //read banks uri from settings.txt
                    Unirest.post(SettingsReader.getSetting("banks") + "/" + gameId + "/players");
                } catch (IOException e) {
                    return null;
                }
                return player;
            }
        }
        return null;
    }

    public boolean deletePlayer(String gameID, String playerID) {
        Game game = findGame(gameID);
        return game.deletePlayer(playerID);
    }
}