package Boards.modell;

/**
 - board: |
 {
     "type": "object",
     "$schema": "http://json-schema.org/draft-03/schema",
     "id": "board",
     "required": true,
     "properties": {
         "fields": {    "type": "array",
                        "items": {"$ref": "field" },
                        "required": true,
                        "description":"list of fields of the board"  },
         "positions": { "type": "object",
                        "properties": { "{playerid}":"int" },
                        "required": true,
                        "description":"a map of playerid to position on the board"  }
     }
 }

 /boards:
 type:
 list:
 schema: "board"
 example: |
 [{
     "fields":[
         {"place": "/boards/42/places/0" ,"players":[]},
         {"place": "/boards/42/places/1" ,"players":[]},
         {"place": "/boards/42/places/2" ,"players":[]},
         {"place": "/boards/42/places/3" ,"players":[]},
         {"place":{"name":"Einkommensteuer"},"players":[{"id":"Mario","place":"/boards/42/places/2", "position":4}]}
    ]
 }]

 */
public class Board {

}
