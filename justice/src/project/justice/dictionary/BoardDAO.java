package project.justice.dictionary;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BoardDAO implements BoardDAOImpl {

	private SqlSessionTemplate sqlSession =null;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int getBoardCount(String category, String keyword) throws Exception{
		HashMap params = new HashMap();
		params.put("category",category);
		params.put("keyword",keyword);
		int count = sqlSession.selectOne("d_board_DB.getCount",params);
		return count;
	}
	// 게시판 글 가져오는 메서드
	@Override
	public List getBoardList(String pageNum, String category, String keyword, int start, int end) throws Exception{
		List list = null;
		HashMap params = new HashMap();
		params.put("start", start);
		params.put("end", end);
		params.put("category",category);
		params.put("keyword",keyword);
		list = sqlSession.selectList("d_board_DB.getBoardList", params);
		return list;
	}
	// 글 내용(content) 가져오는 메서드
	@Override
	public BoardDTO getContent(int d_board_no) throws Exception{
		BoardDTO brdDTO = sqlSession.selectOne("getPost", d_board_no);;
		return brdDTO;
	}
	// 사전에서 다른 단어 제시할때 원 단어 가져오기
	public String getWordData(int word_no) throws Exception{
		String wname = null;
		wname = sqlSession.selectOne("d_board_DB.getWordData",word_no);
		return wname;
	}
	
	// 게시글 작성 메서드
	@Override
	public int insertPost(BoardDTO brdDTO) throws Exception{
		int check = 0;
		check = sqlSession.insert("insertPost", brdDTO);
		return check;
	}
	// 게시글 수정시 정보 가져오는 메서드
	@Override
	public BoardDTO getUpdatePost(int d_board_no) throws Exception{
		BoardDTO brdDTO = sqlSession.selectOne("getPost", d_board_no);
		return brdDTO;
	}
	// 게시글 수정 메서드
	@Override
	public int updatePost(BoardDTO brdDTO) throws Exception{
		return 0;
	}
	// 게시글 삭제 메서드
	@Override
	public int deletePost(int d_board_no, String user_id, String passwd) throws Exception{
		return 0;
	}
	// 추천 메서드
	@Override
	public int getRecommend(int d_board_no, String user_id) throws Exception{
		return 0;
	}
	// 투표게시판으로 옮기는 메서드
	@Override
	public int insertVoting(int d_board_no) throws Exception{
		return 0;
	}
	
}
