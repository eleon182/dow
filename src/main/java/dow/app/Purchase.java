package dow.app;

import dow.defaults.UnitTypes;
import dow.resource.FO.CoordinateFO;

/**
 * Created by steve on 10/20/15.
 */
public class Purchase extends BaseApp {

    public boolean buySupplyDepot(CoordinateFO coord, String token) {
        String username = getUsernameFromToken(token);

        if (gameBoardBO.checkWorkerInSector(username, coord) && userProfileBO.checkEnoughGold(username, gameConstants.supplyDepotPrice)) {
            userProfileBO.chargeGold(username, gameConstants.supplyDepotPrice);
            gameBoardBO.buySupplyDepot(username, coord);
            return true;
        } else {
            return false;
        }
    }

    public boolean buyFactory(CoordinateFO coord, String token) {
        String username = getUsernameFromToken(token);
        if (gameBoardBO.checkWorkerInSector(username, coord) && userProfileBO.checkEnoughGold(username, gameConstants.factoryPrice)) {
            userProfileBO.chargeGold(username, gameConstants.factoryPrice);
            gameBoardBO.buyFactory(username, coord);
            return true;
        } else {
            return false;
        }
    }

    public boolean buyMarine(String token,CoordinateFO coord){
        return buyUnit(token, coord, UnitTypes.MARINE, gameConstants.marinePrice);
    }

    public boolean buyMedic(String token,CoordinateFO coord){
        return buyUnit(token, coord, UnitTypes.MEDIC, gameConstants.medicPrice);
    }

    public boolean buySniper(String token,CoordinateFO coord){
        return buyUnit(token, coord, UnitTypes.SNIPER, gameConstants.sniperPrice);
    }

    private boolean buyUnit(String token, CoordinateFO coord, UnitTypes unitType, int price) {
        String username = getUsernameFromToken(token);

        if (userProfileBO.checkEnoughGold(username, price)) {
            userProfileBO.chargeGold(username, price);
            gameBoardBO.purchaseUnit(username, coord, unitType);
            return true;
        }
        else {
            return false;
        }
    }
}
