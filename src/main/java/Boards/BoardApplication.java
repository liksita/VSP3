package Boards;

import Boards.controller.BoardController;
import Boards.service.BoardService;

/**
 * Created by m on 25.11.15.
 */
public class BoardApplication {

    public static void main(String[] args){
        new BoardController(new BoardService());
    }

}
