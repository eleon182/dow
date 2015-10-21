package dow.bo;

import dow.data.GameBoardData;
import dow.data.UserProfileData;
import dow.data.UserTokenData;
import dow.defaults.GameConstants;

/**
 * Created by steve on 10/21/15.
 */
public class MainBO {
    UserProfileData userProfileData = new UserProfileData();
    UserTokenData userTokenData = new UserTokenData();
    GameBoardData gameBoardData = new GameBoardData();
    GameConstants gameConstants = new GameConstants();

    public String getUsernameFromToken(String token) {
        return userTokenData.getUsername(token);
    }
}
