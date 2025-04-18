package museumDao;

import java.sql.SQLException;
import java.util.Collection;

import meseum.entity.Article;

public interface JdbcDao <T,K>{
	boolean save(T t) throws SQLException;
	
	Collection<T> findAll() throws SQLException;
	
	T findById (K key) throws SQLException;

	Boolean update(Article article) throws SQLException;

	Boolean delete(Integer id) throws SQLException;
	
	
}
