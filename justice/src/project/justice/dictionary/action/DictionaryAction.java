package project.justice.dictionary.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary/")
public class DictionaryAction {
	
	@RequestMapping("list.ju")
	public String dictionaryList() {
		
		
		return "dictionary/dictionary/dictionaryList";
	}

}
