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
		return "member/main";
	}
	@RequestMapping("login.ju")
	public String login() {		
		return "member/login";
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
		return "member/loginPro";
	}
	@RequestMapping("registForm.ju")
	public String rigistForm() {
		return "member/registForm";
	}
	@RequestMapping("registPro.ju")
	public String registPro(MemberVO vo,Model model) {
		try {
			memberDAO.insertMember(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/registPro";
	}
	@RequestMapping("logout.ju")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}
	@RequestMapping("memberEdit.ju")
	public String memberEdit() {			
		return "member/memberEdit";
	}
	@RequestMapping("memberEdit2.ju")
	public String memberEdit2(MemberVO vo,Model model) {		
		return "member/memberEdit2";
	}
	@RequestMapping("changeMember.ju")
	public String changeMember(MemberVO vo,Model model) {

		try {
			int check = memberDAO.userCheck(vo);
			if(check==1) {
				vo = memberDAO.getMember(vo.getId());
				model.addAttribute("email", vo.getEmail());
			}
			model.addAttribute("check", check);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "member/changeMember";
	}
	@RequestMapping("changeMemberPro.ju")
	public String changeMemberPro(MemberVO vo,HttpSession session) {
		try {
			memberDAO.updateMember(vo);
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/changeMemberPro";
	}
	@RequestMapping("deleteMember.ju")
	public String deleteMember() {			
		return "member/deleteMember";
	}
	@RequestMapping("deleteMemberPro.ju")
	public String deleteMemberPro(HttpSession session,String passwd,Model model) {		
		String id = (String)session.getAttribute("memId");
		try {
			int result = memberDAO.deleteMember(id, passwd);
			model.addAttribute("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/deleteMemberPro";
	}
}
