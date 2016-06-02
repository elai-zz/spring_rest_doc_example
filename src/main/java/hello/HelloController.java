package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by estella on 5/30/16.
 */

@Controller
public class HelloController {

    @RequestMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name,
                        Model model) {
        if (name.equals("nobody")) {
            //throw new IllegalArgumentException("Application does not say hi to nobody");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } else {
            model.addAttribute("name", name);
            return new ResponseEntity<String>("greeting", HttpStatus.OK);
        }

    }
}
