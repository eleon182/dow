package dow.resource;

import dow.resource.FO.CoordinateFO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 10/20/15.
 */
@RequestMapping("/purchase")
@RestController
public class PurchaseResource extends MainResource {

    @RequestMapping(value="/factory", method= RequestMethod.POST)
    ResponseEntity<?> purchaseFactory(@RequestBody CoordinateFO body, @RequestHeader(value = "Authorization") String token) {
        if(purchase.buyFactory(body, token)){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/supplydepot", method= RequestMethod.POST)
    ResponseEntity<?> purchaseSupplyDepot(@RequestBody CoordinateFO body, @RequestHeader(value = "Authorization") String token) {
        if(purchase.buySupplyDepot(body, token)){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}



