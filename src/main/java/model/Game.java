package model;

import java.util.ArrayList;
import java.util.List;

/**
 * - game: |
 * {
 * "type":    "object",
 * "$schema": "http://json-schema.org/draft-03/schema",
 * "id":      "game",
 * "properties": {
 * "gameID": { "type":    "string", "required": true},
 * "players":{ "type":    "array",
 * "items":   {"$ref": "player"} },
 * "components": { "$ref": "components" }
 * }
 * }
 * example: |
 * {"gameID":"42",
 * "players":[{"id":"mario","name":"Mario","uri":"http://localhost:4567/player/mario","ready":false}],
 * "started":false
 * }
 */

public class Game {

    private String gameID;
    private List<Player> players;
    private Components components = null;
    private boolean currentGameIsStarted = false;
    private int nowPlaying = 0;


    public Game(String gameID, ArrayList<Player> players, Components components) {
        this.gameID = gameID;
        this.players = players;
        this.components = components;
    }

    public Game(String gameID) {
        this.gameID = gameID;
        this.players = new ArrayList<>();
    }

    public String getGameID() {
        return gameID;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean contains(Player player) {
        return players.contains(player);
    }


    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public boolean isStarted() {
        if (currentGameIsStarted) return true;

        for ( Player player : players ) {
            if(!player.getReady()) return false;
        }

        currentGameIsStarted = true;
        return true;
    }

    public int getPlayer() {
        return nowPlaying;
    }

    public void setNextPlayer() {
        nowPlaying++;
        if(nowPlaying > players.size()) nowPlaying = 0;
    }

}
