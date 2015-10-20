package dow.app;

import dow.defaults.Game;
import dow.resource.FO.CoordinateFO;

/**
 * Created by steve on 10/20/15.
 */
public class Purchase extends BaseApp {

    public boolean buySupplyDepot(CoordinateFO coord, String token) {
        String username = getUsernameFromToken(token);
        if (gameBoardBO.checkWorkerInSector(username, coord) && userProfileBO.checkEnoughGold(username, Game.supplyDepotPrice)) {
            userProfileBO.chargeGold(username, Game.supplyDepotPrice);
            gameBoardBO.buySupplyDepot(username, coord);
            return true;
        } else {
            return false;
        }
    }

    public boolean buyFactory(CoordinateFO coord, String token) {
        String username = getUsernameFromToken(token);
        if (gameBoardBO.checkWorkerInSector(username, coord) && userProfileBO.checkEnoughGold(username, Game.factoryPrice)) {
            userProfileBO.chargeGold(username, Game.factoryPrice);
            gameBoardBO.buyFactory(username, coord);
            return true;
        } else {
            return false;
        }
    }
}
