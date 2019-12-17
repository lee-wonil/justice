package project.justice.dictionary;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dboard/")
public class BoardAction {
	
	 @Autowired
	 private BoardDAO brdDAO = null;
	 @Autowired
	 private BoardDTO brdDTO = null;
	 
	 @RequestMapping("boardContent.ju")
	 public String boardContent(Model model, int d_board_no) throws Exception {
		 BoardDTO brdDTO = brdDAO.getContent(d_board_no);
		 model.addAttribute("brdDTO", brdDTO);
		 return "/dictionary/dicBoard/boardContent";
	 }
	
	@RequestMapping("boardList.ju")
	public String boardList(@RequestParam(defaultValue="1") String pageNum,
							@RequestParam(defaultValue="wname") String category,
							@RequestParam(defaultValue="") String keyword,
							Model model, HttpSession session) {
		String admin = (String)session.getAttribute("admin");
		String memId = (String)session.getAttribute("memId");
		model.addAttribute("memId");
		
		if(admin!= null) {
			model.addAttribute("admin");
		}
		int pageSize=10;
		model.addAttribute("pageSize");
		model.addAttribute("pageNum");
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1)* pageSize +1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		List boardList = null;
		try {
			count = brdDAO.getBoardCount(category, keyword);
			System.out.println(count);
			if(count>0) {
				boardList = brdDAO.getBoardList(pageNum, category, keyword, startRow, endRow);
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
		model.addAttribute("boardList", boardList );
		
		
		return "/dictionary/dicBoard/boardList";
	}
	
	@RequestMapping("boardWrite.ju")
	public String boardWrite(Model model, String word_no, HttpSession session) throws Exception {
		String memId = (String)session.getAttribute("memId");
		model.addAttribute("user_id",memId);
		
		if(word_no!=null) {
			String wname = brdDAO.getWordData(Integer.parseInt(word_no));
			model.addAttribute("wname",wname);
		}
		model.addAttribute("word_no", word_no);
		
		return "/dictionary/dicBoard/boardWrite";
	}
	
	@RequestMapping("boardWritePro.ju")
	public String boardWritePro(Model model, HttpSession session, BoardDTO brdDTO) throws Exception {
		int check = 0;
		if((String)session.getAttribute("memId")==null) {
			check = -1;
		}else if(brdDTO.getWname() == null || brdDTO.getPrompt() == null || brdDTO.getUser_id() == null || brdDTO.getDetail_content() ==null || brdDTO.getPrompt() ==null ) {
			check = -2;
		}else {
			check = brdDAO.insertPost(brdDTO);
		}
		model.addAttribute("check",check);
		
		
		return "/dictionary/dicBoard/boardWritePro";
	}
	
	@RequestMapping("boardUpdate.ju")
	public String boardUpdate(Model model,HttpSession session, int d_board_no) throws Exception {
		String memId = (String)session.getAttribute("memId");
		BoardDTO brdDTO = brdDAO.getUpdatePost(d_board_no);
		
		int check = 0;
		
		if(memId.equals(brdDTO.getUser_id())) {
			System.out.println("hello");
		}
		
		return "/dictionary/dicBoard/boardUpdate";
	}
	
	@RequestMapping("boardUpdatePro.ju")
	public String boardUpdatePro() {
		return "/dictionary/dicBoard/boardUpdatePro";
	}
	
	@RequestMapping("boardDelete.ju")
	public String boardDelete() {
		return "/dictionary/dicBoard/boardDelete";
	}
	
	
	@RequestMapping("boardRecommend.ju")
	public String boardRecommend() {
		return "/dictionary/dicBoard/boardRecommend";
	}
	
	@RequestMapping("insertVoting.ju")
	public String insertVoting() {
		return "/dictionary/dicBoard/insertVoting";
	}
	
		
}
