package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.jdbc.MyBatisSqlSessionFactory;



public class TitleDaoImpl implements TitleDao {
	private static final String namespace = "mappers.TitleMapper";

	@Override
	public List<Title> selectTitleByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectTitleByAll");
		}
	}

	@Override
	public int insertTitle(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertTitle", title);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteTitle(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteTitle", title);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateTitle(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateTitle", title);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Title selectTitleByCode(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectTitleByCode", title);
		}
	}

}
