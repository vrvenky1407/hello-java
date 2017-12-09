package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @Autowired
	private GreetingTranslator greetingTranslator;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, 
    					   @RequestParam(value="lang", required=false, defaultValue="en") String lang, 
    					   Model model) {
    	model.addAttribute("hello", greetingTranslator.sayHelloIn(lang));
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/addgreeting")
    @ResponseBody
    public String addGreeting(@RequestParam(value="lang", required=true) String lang, 
                              @RequestParam(value="greeting", required=true) String greeting) {
        Greeting newGreeting = new Greeting(lang, greeting);
        if (greetingTranslator.add(newGreeting) != null) {
            return "OK";
        } else {
            return "Failed";
        }
    }

}