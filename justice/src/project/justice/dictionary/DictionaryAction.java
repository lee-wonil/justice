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
	private ReportDTO rptDTO = null;
	@Autowired
	private DictionaryDAO dicDAO = null;
	@Autowired
	private DictionaryDTO dicDTO = null;
	@Autowired
	private SimpleDateFormat sdf = null;
	
	// 리스트
	@RequestMapping("list.ju")
	public String dictionaryList(String pageNum, Model model) {
		int pageSize = 10;
		model.addAttribute("pageSize",pageSize);
		
		if(pageNum == null) {
			pageNum = "1";
		}
		model.addAttribute("pageNum", pageNum);
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1)* pageSize +1;
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
	
	//추가
	@RequestMapping("insertDictionary.ju")
	public String insertDictionary() {
		
		return "dictionary/dictionary/insertDictionary";
	}
	//추가
	@RequestMapping("insertDictionaryPro.ju")
	public String insertDictionaryPro(DictionaryDTO dicDTO, Model model) {
		try {
			int check = dicDAO.insertDictionary(dicDTO);
			model.addAttribute("check", check);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "dictionary/dictionary/insertDictionaryPro";
	}
	//수정
	@RequestMapping("updateDictionary.ju")
	public String updateDictionary(int word_no,String pageNum, Model model) {
		try {
			DictionaryDTO dicDTO = dicDAO.getUpdateDictionary(word_no);
			model.addAttribute("dicDTO", dicDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "dictionary/dictionary/updateDictionary";
	}
	//수정
	
	@RequestMapping("updateDictionaryPro.ju")
	public String updateDictionaryPro(DictionaryDTO dicDTO, Model model) {
		try {
			int check = dicDAO.updateDictionary(dicDTO);
			model.addAttribute("check", check);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "dictionary/dictionary/updateDictionaryPro";
		
		
	}
	
	//삭제
	@RequestMapping("deleteDictionary.ju")
	public String deleteDictionary(int word_no, Model model) {
		int check = 0;
		try{
			check = dicDAO.deleteDictionary(word_no);
			model.addAttribute("check",check);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "dictionary/dictionary/deleteDictionaryPro";
	}
	
	
	//추천
	@RequestMapping("recommendDictionary.ju")
	public String recommendDictionary(Model model, int word_no) {
		// 매개변수 ID 추가
		String user_id = "kim";
		try {
			int check = dicDAO.getRecommend(word_no, user_id);
			model.addAttribute("check",check);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "dictionary/dictionary/recommendDictionary";
	}
	
	// 신고
	@RequestMapping("reportDictionary.ju")
	public String reportDictionary(Model model, int word_no) {
		try {
			DictionaryDTO dicDTO = dicDAO.getUpdateDictionary(word_no);
			model.addAttribute("dicDTO", dicDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "dictionary/dictionary/reportDictionary";
	}
	//신고
	@RequestMapping("reportDictionaryPro.ju")
	public String reportDictionaryPro(ReportDTO rptDTO, Model model) {
		// report 페이지에 세션 체크후 user_id 값 추가
		try {
			int check = dicDAO.reportWord(rptDTO);
			model.addAttribute("check",check);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "dictionary/dictionary/reportDictionaryPro";
	}
	
	//신고 게시물 조회
	@RequestMapping("showReport.ju")
	public String showReport(Model model) {
		try {
			List reportList = dicDAO.getReportList();
			model.addAttribute("reportList", reportList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "dictionary/dictionary/showReport";
	}
	
	@RequestMapping("showReportPro.ju")
	public String showReportPro(Model model, int word_no) {
		try{
			List reportContent = dicDAO.getReport(word_no);
			model.addAttribute("reportContent", reportContent);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "dictionary/dictionary/showReportPro";
	}
	
	
	
	
	
	

}
