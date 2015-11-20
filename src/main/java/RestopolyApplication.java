import controller.GameController;
import service.GameService;

/**
 * Created by diana on 20.11.15.
 */
public class RestopolyApplication {

        public static void main(String[] args) {
            new GameController(new GameService());
        }

}
