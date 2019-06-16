package dao;

import java.util.List;

public interface Dao<T> {

	public void save(T entity);

	public void update(T entity);

	public void remove(T entity);

	public T findById(Class<T> entity, Long id);

	public List<T> findAll(Class<T> entity);

}
