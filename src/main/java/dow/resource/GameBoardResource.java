package dow.resource;

import dow.app.GameBoard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 10/19/15.
 */
@RequestMapping("/gameboard")
@RestController
public class GameBoardResource extends MainResource {

    GameBoard gameBoard = new GameBoard();

    @RequestMapping("/get")
    ResponseEntity<?> getDetails() {
        return new ResponseEntity<>(gameBoard.getGameBoard(), HttpStatus.OK);
    }
}
