package project.justice.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news/")
public class BoardAction {

	
	@Autowired
	private NewsDTO dto = null;
	
	@RequestMapping("news_list.ju")
	public String news_list(NewsDTO dto) {
		return "news_list";
	}
	
	
	
	
}
