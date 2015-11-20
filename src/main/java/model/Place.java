package model;

/**
 * - place: |
     {
         "type": "object",
         "$schema": "http://json-schema.org/draft-03/schema",
         "id": "place",
         "required": true,
         "properties": {
            "name": { "type": "string",  "required": true  }
         }
     }
    example:
        "place":{"name":"Einkommensteuer"}
 */
public class Place {

    public String placeID;
    public String name;

    public Place(String placeID, String name) {
        this.placeID = placeID;
        this.name = name;
    }

    // ===========================
    // Getter's
    // ===========================
    public String getPlaceID() {
        return placeID;
    }

    public String getName() {
        return name;
    }
}
