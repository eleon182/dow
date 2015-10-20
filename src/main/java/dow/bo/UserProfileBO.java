package dow.bo;

import dow.bo.to.UserProfileTO;
import dow.data.UserProfileData;
import dow.data.UserTokenData;
import dow.data.dao.UserProfileDAO;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfileBO {
    UserProfileData userProfileData = new UserProfileData();
    UserTokenData userTokenData = new UserTokenData();

    public UserProfileTO getUserProfileData(String username) {
        UserProfileDAO temp = userProfileData.getUserData(username);

        UserProfileTO response = new UserProfileTO();

        if(temp != null){
            response.setUsername(temp.getUsername());
        }
        return response;
    }

    public String getToken(String username, String password){
        if(!BCrypt.checkpw(password, userProfileData.getUserData(username).getPassword())){
            return null;
        }
        else {
            return userTokenData.createToken(username);
        }
    }

    public boolean validateToken(String token){
        return userTokenData.validateToken(token);
    }


    public String addUser(String username, String password){
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        UserProfileDAO temp = userProfileData.getUserData(username);
        if(temp != null){
            return null;
        }
        else {
            userProfileData.addUser(username, hashed);
            return userTokenData.createToken(username);
        }
    }
}
