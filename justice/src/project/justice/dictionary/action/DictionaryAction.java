package project.justice.dictionary.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary/")
public class DictionaryAction {
	
	@RequestMapping("list.ju")
	public String dictionaryList(String pageNum, Model model) {
		int pageSize = 10;
		
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startrow = (currentPage)* pageSize +1;
		
		
		return "dictionary/dictionary/dictionaryList";
	}

}
