package dow.bo;

import dow.data.GameBoardData;
import dow.data.dao.GameBoardDAO;
import dow.defaults.UnitTypes;

import java.util.List;

/**
 * Created by steve on 10/19/15.
 */
public class GameBoardBO {
    GameBoardData gameBoardData = new GameBoardData();

    public List<GameBoardDAO> getGameBoardData(){
        return gameBoardData.getGameBoard();
    }

    public void updateSector(GameBoardDAO sector){
        gameBoardData.saveSector(sector);
    }

    public void activateUser(String username, String x, String y){
        GameBoardDAO gameBoardTemp = new GameBoardDAO();

        gameBoardTemp.setOwner(username);
        gameBoardTemp.setUnitType(UnitTypes.WORKER.toString());
        gameBoardTemp.setUnitHealth(100);
        gameBoardTemp.setX(x);
        gameBoardTemp.setY(y);
        gameBoardData.saveSector(gameBoardTemp);
    }
}
