package dow.data.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by steve on 10/19/15.
 */
@DynamoDBTable(tableName = "dow-user-token")
public class UserTokenDAO{

    private String username;
    private String token;
    private String createDate;

    @DynamoDBHashKey
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
