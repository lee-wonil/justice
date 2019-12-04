package project.justice.action;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.justice.member.MemberDAO;
import project.justice.member.MemberVO;
//test
@Controller
public class MainAction {

	@Autowired
	MemberDAO memberDAO = null;
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
	@RequestMapping("registPro.ju")
	public String registPro(MemberVO vo,Model model) {
		try {
			memberDAO.insertMember(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "registPro";
	}
}
