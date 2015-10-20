package dow.bo;

import dow.data.GameBoardData;
import dow.data.dao.GameBoardDAO;

import java.util.List;

/**
 * Created by steve on 10/19/15.
 */
public class GameBoardBO {
    GameBoardData gameBoardData = new GameBoardData();

    public List<GameBoardDAO> getGameBoardData(){
        return gameBoardData.getGameBoard();
    }
}
