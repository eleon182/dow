package dow.app;

import dow.bo.GameBoardBO;
import dow.bo.UserProfileBO;
import dow.bo.to.UserProfileTO;
import dow.data.dao.UserProfileDAO;
import dow.resource.FO.ActivateAccountFO;

/**
 * Created by steve on 10/18/15.
 */
public class UserProfile extends BaseApp{
    UserProfileBO userProfileBO = new UserProfileBO();
    GameBoardBO gameBoardBO = new GameBoardBO();

    public UserProfileTO getUserProfile(String username) {
        return userProfileBO.getUserProfileData(username);
    }

    public String getToken(String username, String password) {
        return userProfileBO.getToken(username, password);
    }

    public boolean validateToken(String token) {
        return userProfileBO.validateToken(token);
    }

    public void activateUser(ActivateAccountFO body, String token){
        UserProfileDAO temp = new UserProfileDAO();
        String username =  getUsernameFromToken(token);

        temp.setUsername(username);
        temp.setActivated(true);
        userProfileBO.save(temp);
        gameBoardBO.activateUser(username, body.getX(), body.getY());
    }

    public String addUser(String username, String password) {
        return userProfileBO.addUser(username, password);
    }

    public boolean checkActivation(String token){
        return userProfileBO.checkActivated(getUsernameFromToken(token));
    }
}
