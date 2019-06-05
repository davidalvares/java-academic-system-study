package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CrudDAO<T> implements Dao<T> {

	private static EntityManager manager = ConnectionFactory.geEntityManager();

	@Override
	public void save(T entity) {
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
	}

	@Override
	public void update(T entity) {
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();

	}

	@Override
	public void remove(T entity, Long id) {
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();

	}

	@Override
	public T findById(Class<T> entity, Long id) {
		return manager.find(entity, id);
	}

	@Override
	public List<T> findAll(Class<T> entity) {

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entity);
		Root<T> entidades = cq.from(entity);
		TypedQuery<T> allQuery = manager.createQuery(cq);
		List<T> resultadoDaLista = allQuery.getResultList();

		return resultadoDaLista;

	}

}
