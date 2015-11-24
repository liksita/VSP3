import Bank.controller.BankController;
import Bank.service.BankService;
import Game.controller.GameController;
import Game.service.GameService;
import Player.controller.PlayerController;
import Player.service.PlayerService;

/**
 * Created by diana on 20.11.15.
 */
public class RestopolyApplication {

        public static void main(String[] args) {

            new GameController(new GameService());
            new BankController(new BankService());
            new PlayerController(new PlayerService());
        }
}
