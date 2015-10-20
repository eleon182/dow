package dow.resource;

import dow.app.UserProfile;
import dow.resource.FO.LoginFO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserProfileResource extends MainResource {

    UserProfile userProfile = new UserProfile();

    @RequestMapping(value="/login", method= RequestMethod.POST)
    ResponseEntity<?> login(@RequestBody LoginFO body) {
        String response = userProfile.getToken(body.getUsername(), body.getPassword());
        if(response == null){
            return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
        }
        else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @RequestMapping("/checkvalidation")
    ResponseEntity<?> getDetails(@RequestHeader(value = "Authorization") String token) {
        if (userProfile.checkValidated(token)) {
            return new ResponseEntity<>("validated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    ResponseEntity<?> registration(@RequestBody LoginFO body) {
        String response = userProfile.addUser(body.getUsername(), body.getPassword());
        if(response == null){
            return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
        }
        else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


}
