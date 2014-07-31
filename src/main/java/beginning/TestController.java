package beginning;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
	@Inject
	TestRepository testRepository;
	
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "helloWorld";
    }
	
    @RequestMapping(value = "db", method = RequestMethod.GET)
    @ResponseBody
    public String dbHelloWorld(Model model) {
    	Object obj = testRepository.test();
        model.addAttribute("message", "Hello db - " + obj);
        return "helloWorld";
    }
}