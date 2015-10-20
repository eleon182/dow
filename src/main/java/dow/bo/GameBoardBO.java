package dow.bo;

import dow.data.GameBoardData;
import dow.data.dao.GameBoardDAO;
import dow.defaults.UnitTypes;
import dow.resource.FO.CoordinateFO;

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

    public void buySupplyDepot(String username, CoordinateFO coord){
        buy(username, coord, UnitTypes.SUPPLYDEPOT);
    }

    public void buyFactory(String username, CoordinateFO coord){
        buy(username, coord, UnitTypes.FACTORY);
    }

    public boolean checkWorkerInSector(String username, CoordinateFO coord){
        GameBoardDAO sector = new GameBoardDAO();

        sector.setX(coord.getX());
        sector.setY(coord.getY());

        sector = gameBoardData.getSector(sector);

        if(sector.getOwner() == username && sector.getUnitType() == UnitTypes.WORKER.toString()){
            return true;
        }
        else {
            return false;
        }
    }

    private void buy(String username, CoordinateFO coord, UnitTypes type){
        GameBoardDAO board = new GameBoardDAO();

        board.setX(coord.getX());
        board.setY(coord.getY());
        board.setUnitType(type.toString());
        board.setUnitHealth(100);
        board.setOwner(username);

        gameBoardData.saveSector(board);
    }
}
