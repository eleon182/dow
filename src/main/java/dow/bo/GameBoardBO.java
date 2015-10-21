package dow.bo;
import dow.data.GameBoardData;
import dow.data.dao.GameBoardDAO;
import dow.defaults.BuildingTypes;
import dow.defaults.UnitTypes;
import dow.resource.FO.CoordinateFO;

import java.util.List;

/**
 * Created by steve on 10/19/15.
 */
public class GameBoardBO {
    GameBoardData gameBoardData = new GameBoardData();

    public List<GameBoardDAO> getGameBoardData() {
        return gameBoardData.getGameBoard();
    }

    public void updateSector(GameBoardDAO sector) {
        gameBoardData.saveSector(sector);
    }

    public void activateUser(String username, String x, String y) {
        GameBoardDAO gameBoardTemp = new GameBoardDAO();

        gameBoardTemp.setOwner(username);
        gameBoardTemp.setUnitType(UnitTypes.WORKER.toString());
        gameBoardTemp.setUnitHealth(100);
        gameBoardTemp.setX(x);
        gameBoardTemp.setY(y);
        gameBoardData.saveSector(gameBoardTemp);
    }

    public void buySupplyDepot(String username, CoordinateFO coord) {
        buyBuilding(username, coord, BuildingTypes.SUPPLYDEPOT);
    }

    public void buyFactory(String username, CoordinateFO coord) {
        buyBuilding(username, coord, BuildingTypes.FACTORY);
    }

    public void purchaseUnit(String username, CoordinateFO coord, UnitTypes unitType) {
        GameBoardDAO sector = new GameBoardDAO();

        sector.setOwner(username);
        sector.setX(coord.getX());
        sector.setY(coord.getY());
        sector.setUnitType(unitType.toString());

        gameBoardData.saveSector(sector);
    }

    public boolean checkFactoryInSector(String username, CoordinateFO coord) {
        GameBoardDAO sector = getSector(username, coord);
        if (sector != null && sector.getBuildingType() == BuildingTypes.FACTORY.toString()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkWorkerInSector(String username, CoordinateFO coord) {
        GameBoardDAO sector = getSector(username, coord);

        if (sector != null && sector.getOwner().equals(username) && sector.getUnitType().equals(UnitTypes.WORKER.toString())) {
            return true;
        } else {
            return false;
        }
    }

    private void buyBuilding(String username, CoordinateFO coord, BuildingTypes type) {
        GameBoardDAO board = new GameBoardDAO();

        board.setX(coord.getX());
        board.setY(coord.getY());
        board.setUnitType(type.toString());
        board.setUnitHealth(100);
        board.setOwner(username);

        gameBoardData.saveSector(board);
    }

    private GameBoardDAO getSector(String username, CoordinateFO coord) {
        GameBoardDAO sector = new GameBoardDAO();

        sector.setX(coord.getX());
        sector.setY(coord.getY());

        return gameBoardData.getSector(sector);
    }
}
