package Game;

import Bank.controller.BankController;
import Bank.service.BankService;
import Game.controller.GameController;
import Game.service.GameService;
import Player.controller.PlayerController;
import Player.service.PlayerService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * settings.txt example:
 * <p>
 * http:0.0.0.0:4567/banks
 * http:0.0.0.0:4567/boards
 * http:0.0.0.0:4567/brokers
 * http:0.0.0.0:4567/dice
 * http:0.0.0.0:4567/games
 * http:0.0.0.0:4567/jail
 * http:0.0.0.0:4567/player
 */

public class GameApplication {

    public static void main(String[] args) throws IOException {

        // read Settings
        HashMap<String, String> services = new HashMap<>();
        FileReader fr = new FileReader("settings.txt");
        BufferedReader br = new BufferedReader(fr);
        String zeile = "";
        while ((zeile = br.readLine()) != null) {
            if(zeile.contains("banks")){
                services.put("banks",zeile);
            }else if(zeile.contains("boards")){
                services.put("boards",zeile);
            }else if(zeile.contains("brokers")){
                services.put("brokers",zeile);
            }else if(zeile.contains("dice")){
                services.put("dice",zeile);
            }else if(zeile.contains("games")){
                services.put("games",zeile);
            }else if(zeile.contains("jail")){
                services.put("jail",zeile);
            }else if(zeile.contains("player")){
                services.put("player",zeile);
            }
        }
        br.close();

        // starte Controller
        new GameController(new GameService(services), services);
    }
}
