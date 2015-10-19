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


}

