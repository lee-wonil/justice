package project.justice.dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class DictionaryDAO implements DictionaryDAOImpl {
	private SqlSessionTemplate sqlSession =null;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 사전 숫자 가져오기
	public int getDictionaryCount() throws Exception{
		int count = sqlSession.selectOne("dictionaryDB.getCount");
		return count;
	}
	// 리스트 읽어오기
	public List getDictionary(int start, int end) throws Exception{
		HashMap params = new HashMap();
		params.put("start", start);
		params.put("end", end);
		List list = sqlSession.selectList("dictionaryDB.getDictionaryList",params);
		return list;
	}
	// 글 읽어오기
	public DictionaryDTO getDictionaryContent(int word_no) throws Exception{
		DictionaryDTO dicDTO = null;
		return dicDTO;
	}
	
	// (관리자가) 단어 신규 등록
	public int insertDictionary(DictionaryDTO dicDTO) throws Exception{
		int check = 0;
		check = sqlSession.insert("insertDictionary",dicDTO);
		return check;
	}
	// 수정할 단어 정보 가져오기
	public DictionaryDTO getUpdateDictionary(int word_no) throws Exception{
		DictionaryDTO dicDTO = null;
		return dicDTO;
	}
	// (관리자가) 단어 수정
	public int updateDictionary(DictionaryDTO dicDTO) throws Exception{
		int check = 0;
		return check;
	}
	// (관리자가) 단어 삭제
	public int deleteDictionary(int word_no, String passwd) throws Exception{
		int check = 0;
		return check;
	}
	// 리스트에서 단어 추천시 추천수 1증가
	public int getRecommend(int word_no, String user_id) throws Exception{
		int check = 0;
		String id_list = sqlSession.selectOne("confirmRecommend", word_no);
		String [] id_arr = id_list.split(",");
		if(Arrays.asList(id_arr).contains(user_id)) {
			check = -1;
		}else if(!Arrays.asList(id_arr).contains(user_id)){
			HashMap params = new HashMap();
			params.put("word_no", word_no);
			params.put("user_id", user_id);
			check = sqlSession.update("getRecommend", params);
		}
		return check;
	}
	// 게시글 신고
	public int getReport(int word_no, String user_id) throws Exception{
		int check = 0;
		return check;
	}
	
	
}
