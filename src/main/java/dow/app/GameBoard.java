package dow.app;

import dow.bo.GameBoardBO;
import dow.data.dao.GameBoardDAO;

import java.util.List;

/**
 * Created by steve on 10/19/15.
 */
public class GameBoard {
    GameBoardBO gameBoard = new GameBoardBO();

    public List<GameBoardDAO> getGameBoard(){
        return gameBoard.getGameBoardData();
    }
}
