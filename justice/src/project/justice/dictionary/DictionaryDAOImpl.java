package project.justice.dictionary;
import java.util.List;

public interface DictionaryDAOImpl {

	// 사전 숫자 가져오기
	public int getDictionaryCount() throws Exception;
	// 리스트 읽어오기
	public List getDictionary(int start, int end) throws Exception;
	// 글 읽어오기
	public DictionaryDTO getDictionaryContent(int word_no) throws Exception;
	// (관리자가) 단어 신규 등록
	public int insertDictionary(DictionaryDTO dicDTO) throws Exception;
	// 수정할 단어 정보 가져오기
	public DictionaryDTO getUpdateDictionary(int word_no) throws Exception;
	// (관리자가) 단어 수정
	public int updateDictionary(DictionaryDTO dicDTO) throws Exception;
	// (관리자가) 단어 삭제
	public int deleteDictionary(int word_no, String passwd) throws Exception;
	// 리스트에서 단어 추천시 추천수 1증가
	public int getRecommend(int word_no, String user_id) throws Exception;
	// 게시글 신고
	public int getReport(int word_no, String user_id) throws Exception;
}
