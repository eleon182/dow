package dow.bo;

import dow.data.dao.UserProfileDAO;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by steve on 10/21/15.
 */
public class UserTokenBO extends MainBO{

    public String getToken(String username, String password) {
        UserProfileDAO user = userProfileData.getUserData(username);
        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            return null;
        } else {
            return userTokenData.createToken(username);
        }
    }

    public boolean checkActivated(String username) {
        return userProfileData.getUserData(username).getActivated();
    }
    public String addUser(String username, String password) {
        if (userProfileData.getUserData(username) != null) {
            return null;
        } else {
            userProfileData.addUser(username, BCrypt.hashpw(password, BCrypt.gensalt(12)));
            return userTokenData.createToken(username);
        }
    }

    public boolean validateToken(String token) {
        return userTokenData.validateToken(token);
    }

}
