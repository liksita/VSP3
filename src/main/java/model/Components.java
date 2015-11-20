package model;

/**
 * - components: |
     {
         "type":        "object",
         "$schema":     "http://json-schema.org/draft-03/schema",
         "id":          "components",
         "description": "game components as full, absolute url",
         "properties":  {
             "game":    {"type": "string", "required": true},
             "dice":    {"type": "string", "required": true},
             "board":   {"type": "string", "required": true},
             "bank":    {"type": "string", "required": true},
             "broker":  {"type": "string", "required": true},
             "decks":   {"type": "string", "required": true},
             "events":  {"type": "string", "required": true}
         }
     }
 */

public class Components {
    String componentsID;
    String description;
    String game;
    String dice;
    String board;
    String bank;
    String broker;
    String decks;
    String events;

    public Components(String componentsID, String description, String game, String dice, String board, String bank, String broker, String decks, String events){
        this.componentsID   = componentsID;
        this.description    = description;
        this.game           = game;
        this.dice           = dice;
        this.board          = board;
        this.bank           = bank;
        this.broker         = broker;
        this.decks          = decks;
        this.events         = events;
    }

    // ===========================
    // Getter's
    // ===========================
    public String getComponentsID() {
        return componentsID;
    }

    public void setComponentsID(String componentsID) {
        this.componentsID = componentsID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getDice() {
        return dice;
    }

    public void setDice(String dice) {
        this.dice = dice;
    }

    public String getBoard() {
        return board;
    }

    // ===========================
    // Setter's
    // ===========================
    public void setBoard(String board) {
        this.board = board;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getDecks() {
        return decks;
    }

    public void setDecks(String decks) {
        this.decks = decks;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }
}
