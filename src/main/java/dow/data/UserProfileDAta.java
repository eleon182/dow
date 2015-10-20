package dow.data;

import dow.data.dao.UserProfileDAO;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfileData extends AWSDatabase {
    public UserProfileDAO getUserData(String user) {
        return getMapper().load(UserProfileDAO.class, user);
    }
}
