package project.justice.action;

import javax.servlet.http.HttpSession;

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
	public String loginPro(MemberVO vo,HttpSession session,Model model) {
		try {
		 int check = memberDAO.userCheck(vo);
		 if(check==1) {
			 session.setAttribute("memId", vo.getId());
		 }
		 model.addAttribute("check", check);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			e.printStackTrace();
		}
		return "registPro";
	}
	@RequestMapping("logout.ju")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}
