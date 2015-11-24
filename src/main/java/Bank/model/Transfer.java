package Bank.model;


/**
 - transfer: |
     {
         "type":    "object",
         "$schema": "http://json-schema.org/draft-03/schema",
         "id":      "transfer",
         "properties": {
             "from":    { "type": "string", "description":"{playerid} or bank", "required": true  },
             "to":      { "type": "string", "description":"{playerid} or bank", "required": true  },
             "reason":  { "type": "string", "required": true  },
             "event":   { "type": "string", "required": false  }
         }
     }
 */
public class Transfer {
    private String transferID;
    private String from;
    private String to;
    private String resource;
    private String event;

    public String getID() {
        return transferID;
    }
}
