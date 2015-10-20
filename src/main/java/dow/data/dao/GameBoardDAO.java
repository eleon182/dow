package dow.data.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import dow.defaults.UnitTypes;

/**
 * Created by steve on 10/18/15.
 */
@DynamoDBTable(tableName = "dow-game-board")
public class GameBoardDAO {

    private String x;
    private String owner;
    public UnitTypes unitType;
    private int unitHealth;

    public String getUnitType() {
        return unitType.toString();
    }

    public void setUnitType(UnitTypes unitType) {
        this.unitType = unitType;
    }

    public int getUnitHealth() {
        return unitHealth;
    }

    public void setUnitHealth(int unitHealth) {
        this.unitHealth = unitHealth;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @DynamoDBHashKey
    public String getX() {
        return x;
    }
    public void setX(String x) {
        this.x = x;
    }

    @DynamoDBRangeKey
    public String getY() {
        return y;
    }
    public void setY(String y) {
        this.y = y;
    }

    private String y;
    private int gold;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}

