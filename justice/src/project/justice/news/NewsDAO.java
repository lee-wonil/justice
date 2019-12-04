package project.justice.news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class NewsDAO implements NewsImpl {
	private SqlSessionTemplate sqlSession =null;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession= sqlSession;
	}
	
	public List newsList() throws Exception{
		List<NewsDTO> newsList = sqlSession.selectList("news.newsList");
		return newsList;
	}
}
