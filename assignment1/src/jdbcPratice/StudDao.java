package jdbcPratice;


import java.util.Collection;

public interface StudDao<T,K> {
	Collection<T> getAll();
	T getOne(K key);
	void add(T t);
}
