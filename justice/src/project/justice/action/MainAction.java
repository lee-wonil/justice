package project.justice.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//test
@Controller
public class MainAction {

	@RequestMapping("main.ju")
	public String main() {
		return "main";
	}
	@RequestMapping("login.ju")
	public String login() {		
		return "login";
	}
	@RequestMapping("loginPro.ju")
	public String loginPro(String id,String passwd,Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		return "loginPro";
	}
	@RequestMapping("registForm.ju")
	public String rigistForm() {
		return "registForm";
	}
}
