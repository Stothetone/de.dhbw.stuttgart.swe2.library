package de.dhbw.stuttgart.swe2.library.jpa.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dhbw.stuttgart.swe2.library.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.library.jpa.Library;

public class PersistenceTest2 {

	private static final String PERSISTENCE_UNIT_NAME = "derby-embedded-inmemory";
//	 private static final String PERSISTENCE_UNIT_NAME = "derby-network";

	private static EntityManagerFactory factory;

	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PersistenceTest2.class);

	@org.junit.BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@Test
	public void testLibrary() {
		AbstractIdentifiable library = new Library();
		EntityManager entityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			try {
				entityManager.persist(library);
				transaction.commit();
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
			AbstractIdentifiable reloaded = entityManager.find(Library.class, library.getId());
			assertEquals(library, reloaded);
		} finally {
			entityManager.close();
		}
	}

}