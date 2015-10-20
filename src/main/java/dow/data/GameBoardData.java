package dow.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import dow.data.dao.GameBoardDAO;

import java.util.List;

/**
 * Created by steve on 10/19/15.
 */
public class GameBoardData extends AWSDatabase {
    public List<GameBoardDAO> getGameBoard() {
        return getMapper().scan(GameBoardDAO.class, new DynamoDBScanExpression());
    }

    public GameBoardDAO getSector(GameBoardDAO sector){
        return getMapper().load(GameBoardDAO.class, sector);
    }

    public void saveSector(GameBoardDAO sector){
        getMapper().save(sector, new DynamoDBMapperConfig(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES));
    }

}
