package dow.resource;

import dow.app.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 10/18/15.
 */
@RequestMapping("/userprofile")
@RestController
public class UserProfileResource extends MainResource {

    UserProfile userProfile;

    public UserProfileResource() {
        userProfile = new UserProfile();
    }

    @RequestMapping("/getdetails")
    ResponseEntity<?> getDetails(@RequestHeader(value="x-customerid") String customerid) {
        String t = customerid;
        return new ResponseEntity<>(userProfile.getUserProfile(customerid), HttpStatus.OK);
    }
}
