package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaAcademicoPU");

	public static EntityManager geEntityManager() {
		return factory.createEntityManager();

	}

}
