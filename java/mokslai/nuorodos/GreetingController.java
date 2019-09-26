package mokslai.nuorodos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@GetMapping("/kategorijos")
	public String kategorijos(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "kategorijos";
	    
	}
	
	@GetMapping("/zymos")
	public String zymos(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "zymos";
	    
	}
	
	@GetMapping("/nuorodos")
	public String nuorodos(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
	        model.addAttribute("name", name);
	        return "nuorodos";
	    
	}
}