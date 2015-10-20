package dow.bo;

import dow.bo.to.UserProfileTO;
import dow.data.UserProfileData;
import dow.data.dao.UserProfileDAO;

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
}
