package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name,
                        Model model) {
        if (name.equals("nobody")) {
            throw new IllegalArgumentException("Application does not say hi to nobody");
        } else {
            model.addAttribute("name", name);
            return "greeting";
        }

    }
}
