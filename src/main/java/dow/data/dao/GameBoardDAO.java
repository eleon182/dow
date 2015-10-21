package dow.data.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by steve on 10/18/15.
 */
@DynamoDBTable(tableName = "dow-game-board")
public class GameBoardDAO {

    private String x;
    private String owner;
    private String unitType;

    public String getBuildingType() {
        return buildingType;
    }

    public Integer getBuildingHealth() {
        return buildingHealth;
    }

    public void setBuildingHealth(Integer buildingHealth) {
        this.buildingHealth = buildingHealth;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    private String buildingType;
    private Integer unitHealth;
    private Integer buildingHealth;

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Integer getUnitHealth() {
        return unitHealth;
    }

    public void setUnitHealth(Integer unitHealth) {
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
    private Integer gold;

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }
}

