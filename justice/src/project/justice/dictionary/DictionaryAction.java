package project.justice.dictionary;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary/")
public class DictionaryAction {
	
	@Autowired
	private DictionaryDAO dicDAO = null;
	@Autowired
	private DictionaryDTO dicDTO = null;
	@Autowired
	private SimpleDateFormat sdf = null;
	
	@RequestMapping("list.ju")
	public String dictionaryList(String pageNum, Model model) {
		int pageSize = 10;
		
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage)* pageSize +1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		List dictionaryList = null;
		
		try {
			count = dicDAO.getDictionaryCount();
			if(count>0) {
				dictionaryList = dicDAO.getDictionary(startRow, endRow);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(count>0) {
			int pageCount = count/pageSize + (count% pageSize == 0? 0:1);
			int startPage = (int)(currentPage/10)*10+1;
			int pageBlock = 10;
			int endPage = startPage + pageBlock-1;
			if(endPage>pageCount) {
				endPage = pageCount;
			}
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("startPage", startPage );
			model.addAttribute("endPage", endPage );
		}
		number = count - (currentPage-1)*pageSize;
		model.addAttribute("count", count );
		model.addAttribute("currentPage", currentPage );
		model.addAttribute("number", number );
		model.addAttribute("dictionaryList", dictionaryList );
		
		
		return "dictionary/dictionary/dictionaryList";
	}

}
