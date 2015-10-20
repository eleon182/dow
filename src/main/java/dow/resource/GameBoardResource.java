package dow.resource;

import dow.app.GameBoard;
import dow.app.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 10/19/15.
 */
@RequestMapping("/gameboard")
@RestController
public class GameBoardResource extends MainResource {

    GameBoard gameBoard = new GameBoard();
    UserProfile userProfile = new UserProfile();

    @RequestMapping("/getdetails")
    ResponseEntity<?> getDetails(@RequestHeader(value = "Authentication") String token) {
        if (userProfile.validateToken(token)) {
            return new ResponseEntity<>(gameBoard.getGameBoard(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}
