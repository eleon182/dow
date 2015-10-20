package dow.data;

import dow.data.dao.UserProfileDAO;

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
        getMapper().save(add);
    }
}
