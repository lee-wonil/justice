package project.justice.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//test
@Controller
public class MainAction {

	@RequestMapping("main.ju")
	public String main() {
		return "main";
	}
}