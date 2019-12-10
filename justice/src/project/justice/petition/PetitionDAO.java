package project.justice.petition;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class PetitionDAO {
	private SqlSessionTemplate sqlSession =null;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<PetitionDTO> getSelectAll() throws Exception {
		List<PetitionDTO> list = sqlSession.selectList("petition.seleteAll");
		return list;
	}
}
