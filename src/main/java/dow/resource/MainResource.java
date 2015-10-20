package dow.resource;

import dow.data.AWSDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/check")
@RestController
public class MainResource {

    @RequestMapping("/tables")
    ResponseEntity<?> getDetails() {
        AWSDatabase temp = new AWSDatabase();
        return new ResponseEntity<>(temp.listTables(), HttpStatus.OK);
    }

}
