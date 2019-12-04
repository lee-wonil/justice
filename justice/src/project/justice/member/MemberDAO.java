package project.justice.member;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDAO implements MemberImpl{
	private SqlSessionTemplate sqlSession =null;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int userCheck(MemberVO vo) throws Exception {
		int check = sqlSession.selectOne("member.userCheck",vo);
		return check;
	}
	public void insertMember(MemberVO vo) throws Exception {
		sqlSession.insert("member.insertMember",vo);
	}
	public int confirmId(MemberVO vo) throws Exception {
		return 0;
	}
	public MemberVO getMember(String id) throws Exception {
		return null;
	}
	public void updateMember(MemberVO vo) throws Exception {		
	}

	public int deleteMember(String id, String passwd) throws Exception {
		return 0;
	}

}
