package Game;

import Game.controller.GameController;
import Game.service.GameService;

/**
 * Created by diana on 20.11.15.
 */
public class GameApplication {

        public static void main(String[] args) {
            new GameController(new GameService());
        }

}
