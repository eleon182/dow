package dow.app;

import dow.bo.GameBoardBO;
import dow.bo.UserProfileBO;
import dow.defaults.GameConstants;

/**
 * Created by steve on 10/19/15.
 */
public class BaseApp {
    protected UserProfileBO userProfileBO = new UserProfileBO();
    protected GameBoardBO gameBoardBO = new GameBoardBO();
    GameConstants gameConstants = new GameConstants();

    public String getUsernameFromToken(String token){
        return userProfileBO.getUsername(token);
    }
}
