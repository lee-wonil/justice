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
		MemberVO vo = sqlSession.selectOne("member.memberId",id);
		return vo;
	}
	public void updateMember(MemberVO vo) throws Exception {
		sqlSession.update("member.memberUpdate",vo);		
	}

	public int deleteMember(String id, String passwd) throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		int count = sqlSession.selectOne("member.userCheck",vo);
		if(count!=1) {	// 비밀번호가 다른 경우
			return -1;	// -1 리턴 받음
		}
		else {
			sqlSession.delete("member.memberDelete", vo.getId());
		}
		return 0;
	}

}
