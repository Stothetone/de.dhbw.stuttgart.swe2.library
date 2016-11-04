package de.dhbw.stuttgart.swe2.library.jpa.test;

import static de.dhbw.stuttgart.swe2.javadsl.FromServiceImpl.from;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dhbw.stuttgart.swe2.library.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.library.jpa.Customer;
import de.dhbw.stuttgart.swe2.library.jpa.LendingInformation;
import de.dhbw.stuttgart.swe2.library.jpa.Library;
import de.dhbw.stuttgart.swe2.library.jpa.Staff;
import de.dhbw.stuttgart.swe2.javadsl.ToMany;

public class JavaDSLTest1 {

	//private static final String PERSISTENCE_UNIT_NAME = "derby-embedded-inmemory";
	private static final String PERSISTENCE_UNIT_NAME = "derby-network";

	private static EntityManagerFactory factory;
	
	private static ToMany<Library, Staff> staff()
	{
		return new LibraryToStaff(); 
	}
	
	private static ToMany<Staff, LendingInformation> lendingInformation()
	{
		return new StaffToLendingInformation(); 
	}
	
	private static class StaffToLendingInformation implements ToMany<Staff, LendingInformation>
	{
		@Override
		public List<LendingInformation> get(Staff input) {
			return input.getLendingInfo();
		}
	}
	
	private static class LibraryToStaff implements ToMany<Library, Staff>
	{
		@Override
		public List<Staff> get(Library input) {
			return input.getStaff();
		}
	}
	
	@org.junit.BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@Test
	public void testLibrary() {
		
		Library lib = new Library();		
		List<LendingInformation> lendingInformation = from(Library.class).join(staff()).join(lendingInformation()).get(lib);
		
		LendingInformation lendingOne = lendingInformation.get(0);

		
		EntityManager entityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			try {
				transaction.commit();
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
	}

}
