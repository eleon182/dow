package dow.app;

import dow.bo.UserProfileBO;

/**
 * Created by steve on 10/19/15.
 */
public class BaseApp {
    UserProfileBO userProfileBO = new UserProfileBO();

    public String getUsernameFromToken(String token){
        return userProfileBO.getUsername(token);
    }
}
