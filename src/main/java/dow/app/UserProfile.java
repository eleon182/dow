package dow.app;

import dow.bo.to.UserProfileTO;
import dow.resource.FO.CoordinateFO;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfile extends BaseApp{

    public UserProfileTO getUserProfile(String token) {
        return userProfileBO.getUserProfileData(getUsernameFromToken(token));
    }

    public String getToken(String username, String password) {
        return userTokenBO.getToken(username, password);
    }

    public boolean validateToken(String token) {
        return userTokenBO.validateToken(token);
    }

    public void activateUser(CoordinateFO body, String token){
        String username =  getUsernameFromToken(token);
        userProfileBO.activateUser(username);
        gameBoardBO.activateUser(username, body.getX(), body.getY());
    }

    public String addUser(String username, String password) {
        return userTokenBO.addUser(username, password);
    }

    public boolean checkActivation(String token){
        return userTokenBO.checkActivated(getUsernameFromToken(token));
    }
}
