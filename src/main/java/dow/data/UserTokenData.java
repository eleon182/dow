package dow.data;

import dow.data.dao.UserTokenDAO;
import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Created by steve on 10/19/15.
 */
public class UserTokenData extends AWSDatabase{

    public boolean validateToken(String token){
        UserTokenDAO dao = getMapper().load(UserTokenDAO.class, token);

        if(dao != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public String createToken(String username){
        String token = UUID.randomUUID().toString();
        String createDate = new DateTime().toDateTimeISO().toString();

        UserTokenDAO entry = new UserTokenDAO();

        entry.setToken(token);
        entry.setCreateDate(createDate);
        entry.setUsername(username);
        getMapper().save(entry);

        return token;
    }
}
