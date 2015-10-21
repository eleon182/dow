package dow.app;

import dow.defaults.GameConstants;
import dow.resource.FO.CoordinateFO;

/**
 * Created by steve on 10/20/15.
 */
public class Purchase extends BaseApp {

    public boolean buySupplyDepot(CoordinateFO coord, String token) {
        String username = getUsernameFromToken(token);
        if (gameBoardBO.checkWorkerInSector(username, coord) && userProfileBO.checkEnoughGold(username, GameConstants.supplyDepotPrice)) {
            userProfileBO.chargeGold(username, GameConstants.supplyDepotPrice);
            gameBoardBO.buySupplyDepot(username, coord);
            return true;
        } else {
            return false;
        }
    }

    public boolean buyFactory(CoordinateFO coord, String token) {
        String username = getUsernameFromToken(token);
        if (gameBoardBO.checkWorkerInSector(username, coord) && userProfileBO.checkEnoughGold(username, GameConstants.factoryPrice)) {
            userProfileBO.chargeGold(username, GameConstants.factoryPrice);
            gameBoardBO.buyFactory(username, coord);
            return true;
        } else {
            return false;
        }
    }
}
