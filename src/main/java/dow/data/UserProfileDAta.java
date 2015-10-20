package dow.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import dow.data.dao.UserProfileDAO;
import org.joda.time.DateTime;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfileData extends AWSDatabase {
    public UserProfileDAO getUserData(String user) {
        return getMapper().load(UserProfileDAO.class, user);
    }

    public void addUser(String username, String password) {
        UserProfileDAO add = new UserProfileDAO();
        add.setUsername(username);
        add.setPassword(password);
        add.setGold(1000);
        add.setCreateDate(new DateTime().toDateTimeISO().toString());
        add.setUpdateDate(new DateTime().toDateTimeISO().toString());
        getMapper().save(add);
    }

    public void save(UserProfileDAO user){
        getMapper().save(user, new DynamoDBMapperConfig(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES));
    }
}
