package dow.app;

import dow.bo.UserProfileBO;
import dow.bo.to.UserProfileTO;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfile {
    UserProfileBO userProfileBO = new UserProfileBO();

    public UserProfileTO getUserProfile(String username) {
        return userProfileBO.getUserProfileData(username);
    }

    public String getToken(String username, String password) {
        return userProfileBO.getToken(username, password);
    }

    public boolean validateToken(String token) {
        return userProfileBO.validateToken(token);
    }

    public String addUser(String username, String password) {
        return userProfileBO.addUser(username, password);
    }
}
