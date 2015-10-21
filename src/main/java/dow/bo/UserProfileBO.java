package dow.bo;

import dow.bo.to.UserProfileTO;
import dow.data.dao.UserProfileDAO;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfileBO extends MainBO{

    public UserProfileTO getUserProfileData(String username) {
        UserProfileDAO temp = userProfileData.getUserData(username);

        UserProfileTO response = new UserProfileTO();

        if (temp != null) {
            response.setUsername(temp.getUsername());
        }
        return response;
    }

    public void save(UserProfileDAO user) {
        userProfileData.save(user);
    }

    public boolean checkEnoughGold(String username, int gold) {
        UserProfileDAO user = userProfileData.getUserData(username);

        if (user.getGold() < gold) {
            return false;
        } else {
            return true;
        }
    }

    public void chargeGold(String username, int gold) {
        UserProfileDAO user = userProfileData.getUserData(username);

        int newGold = user.getGold();

        if (newGold < gold) {
            newGold = 0;
        } else {
            newGold = newGold - gold;
        }

        user.setGold(newGold);
        userProfileData.save(user);
    }
}
