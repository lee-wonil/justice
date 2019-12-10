package project.justice.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.justice.petition.PetitionDAO;
import project.justice.petition.PetitionDTO;

@Controller
@RequestMapping("/petitions/")
public class PetitionAction {
	@Autowired
	PetitionDAO petitionDAO = null;
	@Autowired
	PetitionDTO petitionDTO= null;
	
	@RequestMapping("main.ju")
	public String main() {
		return "petitions/main";
	}
	@RequestMapping("main2.ju")
	public String main2(Model model) {
		try {
			List<PetitionDTO> list = petitionDAO.getSelectAll();
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "petitions/main2";
	}
}
