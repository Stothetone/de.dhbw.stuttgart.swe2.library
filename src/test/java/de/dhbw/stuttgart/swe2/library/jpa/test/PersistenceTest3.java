package de.dhbw.stuttgart.swe2.library.jpa.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dhbw.stuttgart.swe2.library.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.library.jpa.Library;
import de.dhbw.stuttgart.swe2.library.jpa.Staff;

public class PersistenceTest3 {

	//private static final String PERSISTENCE_UNIT_NAME = "derby-embedded-inmemory";
	private static final String PERSISTENCE_UNIT_NAME = "derby-network";

	private static EntityManagerFactory factory;

	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PersistenceTest.class);

	@org.junit.BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@Test
	public void testLibrary() {
		Library library = new Library();
		library.setName("LibraryTest");
		
		List<Staff> staffList = new ArrayList<Staff>();
		for(int i = 0; i < 5; i++)
		{
			Staff staff = new Staff();
			Integer persNo = new Integer(i+1);
			staff.setPersNo(persNo.toString());
			staff.setSalary(i*500);
			
			staffList.add(staff);
		}
		library.setStaff(staffList);

		EntityManager entityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			try {
				for(Staff staff : library.getStaff())
				{
					entityManager.persist(staff);
				}
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
