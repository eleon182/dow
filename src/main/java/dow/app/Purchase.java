package dow.app;
import dow.defaults.BuildingTypes;
import dow.defaults.UnitTypes;
import dow.resource.FO.CoordinateFO;

/**
 * Created by steve on 10/20/15.
 */
public class Purchase extends BaseApp {

    public boolean buySupplyDepot(CoordinateFO coord, String token) {
        return buyBuilding(coord, token, gameConstants.supplyDepotPrice, BuildingTypes.SUPPLYDEPOT);
    }

    public boolean buyFactory(CoordinateFO coord, String token){
        return buyBuilding(coord, token, gameConstants.factoryPrice, BuildingTypes.FACTORY);
    }

    public boolean buyMarine(String token,CoordinateFO coord){
        return buyUnit(token, coord, UnitTypes.MARINE, gameConstants.marinePrice, gameConstants.marineHealth);
    }

    public boolean buyMedic(String token,CoordinateFO coord){
        return buyUnit(token, coord, UnitTypes.MEDIC, gameConstants.medicPrice, gameConstants.medicHealth);
    }

    public boolean buySniper(String token,CoordinateFO coord){
        return buyUnit(token, coord, UnitTypes.SNIPER, gameConstants.sniperPrice, gameConstants.sniperHealth);
    }

    private boolean buyBuilding(CoordinateFO coord, String token, int Price, BuildingTypes type) {
        String username = getUsernameFromToken(token);
        if (gameBoardBO.checkWorkerInSector(username, coord) && userProfileBO.checkEnoughGold(username, gameConstants.factoryPrice)) {
            userProfileBO.chargeGold(username, gameConstants.factoryPrice);
            gameBoardBO.buyBuilding(username, coord, type);
            return true;
        } else {
            return false;
        }
    }

    private boolean buyUnit(String token, CoordinateFO coord, UnitTypes unitType, int price, int health) {
        String username = getUsernameFromToken(token);

        if (userProfileBO.checkEnoughGold(username, price)) {
            userProfileBO.chargeGold(username, price);
            gameBoardBO.activateUnit(username, coord, unitType, health);
            return true;
        }
        else {
            return false;
        }
    }
}
