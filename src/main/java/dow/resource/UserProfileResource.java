package dow.resource;

import dow.app.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userprofile")
@RestController
public class UserProfileResource extends MainResource {

    UserProfile userProfile = new UserProfile();

    public UserProfileResource() {
    }

    @RequestMapping("/getdetails")
    ResponseEntity<?> getDetails(@RequestHeader(value = "x-customerid") String customerid) {
        return new ResponseEntity<>(userProfile.getUserProfile(customerid), HttpStatus.OK);
    }
}
