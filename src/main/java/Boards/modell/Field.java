package Boards.modell;

import Player.model.Player;

import java.util.ArrayList;

/**
 - field: |
 {
     "type": "object",
     "$schema": "http://json-schema.org/draft-03/schema",
     "id": "field",
     "required": true,
     "properties": {
         "place": { "$ref":"place",  "required": true , "description":"the place on this field (Badstrase, Jail...)" },
         "players":  { "$ref":"player",  "required": true, "description":"list of players on this field"  }
     }
 }

 */
public class Field {
    private Place place;
    private ArrayList<Player> players = new ArrayList<>();

    public Field(Place place, ArrayList<Player> players) {
        this.place = place;
        this.players = players;
    }

    public Place getPlace() {
        return place;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
