package dow.bo;

import dow.bo.to.UserProfileTO;
import dow.data.UserProfileData;
import dow.data.dao.UserProfileDAO;
import org.mindrot.jbcrypt.BCrypt;

import java.util.stream.Stream;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfileBO {
    UserProfileData userProfileData = new UserProfileData();

    public UserProfileTO getUserProfileData(String username) {
        UserProfileDAO temp = userProfileData.getUserData(username);

        UserProfileTO response = new UserProfileTO();

        if(temp != null){
            response.setUsername(temp.getUsername());
        }
        return response;
    }

    public boolean validateUser(String username, String password){
        return BCrypt.checkpw(password, userProfileData.getUserData(username).getPassword());
    }

    public boolean addUser(String username, String password){
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        UserProfileDAO temp = userProfileData.getUserData(username);
        if(temp != null){
            return false;
        }
        else {
            userProfileData.addUser(username, hashed);
            return true;
        }
    }
}
