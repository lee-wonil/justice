package project.justice.dictionary;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dboard/")
public class BoardAction {
	
	/*
	 * @Autowired private BoardDAO boardDAO = null;
	 * 
	 * @Autowired private BoardDTO boardDTO = null;
	 */
	
	@RequestMapping("boardList.ju")
	public String boardList(String pageNum, Model model, HttpSession session) {
		
		return "/dictionary/dicBoard/boardList";
	}
	

}
