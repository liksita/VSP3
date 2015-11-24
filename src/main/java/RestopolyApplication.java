import Game.controller.GameController;
import Game.service.GameService;
import Player.controller.PlayerContoller;

/**
 * Created by diana on 20.11.15.
 */
public class RestopolyApplication {

        public static void main(String[] args) {

            new GameController(new GameService());
            new PlayerContoller();
        }

}
