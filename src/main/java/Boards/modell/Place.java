package Boards.modell;

/**
 - place: |
 {
     "type": "object",
     "$schema": "http://json-schema.org/draft-03/schema",
     "id": "place",
     "properties": {
        "name": { "type": "string",  "required": true  }
     }
 }
 */
public class Place {
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
