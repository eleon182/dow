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
}
