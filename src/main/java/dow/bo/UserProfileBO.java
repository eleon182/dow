package dow.bo;

import dow.bo.to.UserProfileTO;
import dow.data.dao.UserProfileDAO;
import dow.data.UserProfileData;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfileBO {
    UserProfileData userProfileData;

    public UserProfileBO() {
        userProfileData = new UserProfileData();
    }

    public UserProfileTO getUserProfileData(String username){
        UserProfileDAO temp;
        UserProfileTO response = new UserProfileTO();

        temp = userProfileData.getUserData(username);

        response.setUsername(temp.getUsername());
        return response;
    }
}
