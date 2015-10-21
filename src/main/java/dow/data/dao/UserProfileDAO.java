package dow.data.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by steve on 10/18/15.
 */
@DynamoDBTable(tableName = "dow-user-profile")
public class UserProfileDAO{

    private String username;
    private String password;
    private boolean activated;
    private Integer gold;

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public boolean isActivated() {
        return activated;
    }

    public UserProfileDAO() {
    }

    public UserProfileDAO(String username, String password, boolean activated, Integer gold, String createDate, String updateDate) {

        this.username = username;
        this.password = password;
        this.activated = activated;
        this.gold = gold;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    private String createDate;
    private String updateDate;

    @DynamoDBHashKey
    public String getUsername() {
        String response = "";
        if(username != null){
            response = username;
        }
        return response;
    }
    public void setUsername(String username) { this.username = username; }

}
