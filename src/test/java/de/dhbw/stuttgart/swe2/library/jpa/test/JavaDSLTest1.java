package de.dhbw.stuttgart.swe2.library.jpa.test;

import static de.dhbw.stuttgart.swe2.javadsl.FromServiceImpl.from;
import static org.junit.Assert.assertEquals;

import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dhbw.stuttgart.swe2.library.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.library.jpa.Customer;
import de.dhbw.stuttgart.swe2.library.jpa.LendingInformation;
import de.dhbw.stuttgart.swe2.library.jpa.LendingObject;
import de.dhbw.stuttgart.swe2.library.jpa.Library;
import de.dhbw.stuttgart.swe2.library.jpa.Staff;
import de.dhbw.stuttgart.swe2.library.jpa.State;
import de.dhbw.stuttgart.swe2.javadsl.NameFilter;
import de.dhbw.stuttgart.swe2.javadsl.ToMany;

public class JavaDSLTest1 {

	private static final String PERSISTENCE_UNIT_NAME = "derby-embedded-inmemory";
	//private static final String PERSISTENCE_UNIT_NAME = "derby-network";

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
		
		Library library = new Library();
		library.setName("LibraryTest");
		
		List<Staff> staffList = new ArrayList<Staff>();
		Staff staff = null;
		

		List<LendingObject> lendingObjectList = new ArrayList<LendingObject>();
		LendingObject lendingObject = new LendingObject();
		List<LendingInformation> lendingInformationList = new ArrayList<LendingInformation>();
		LendingInformation lendingInformation = new LendingInformation();
		lendingInformation.setState(State.GOOD);
		
		for(int i = 0; i < 5; i++)
		{
			staff = new Staff();
			Integer persNo = new Integer(i+1);
			staff.setPersNo(persNo.toString());
			staff.setSalary(i*500);
			staff.setLendingInfo(lendingInformationList);
			if(i == 3)
			{
				staff.setFirstName("Hanswurst");
			}
			else
			{
				staff.setFirstName("Depp");
			}
			
			staffList.add(staff);

			lendingInformation.setStaff(staff);
			lendingInformationList.add(lendingInformation);
		}
		
		
		lendingObject.setLendingInfo(lendingInformationList);
		
		lendingObjectList.add(lendingObject);
		library.setLendingObject(lendingObjectList);
		

		library.setStaff(staffList);
//
//		EntityManager entityManager = factory.createEntityManager();
//		try {
//			EntityTransaction transaction = entityManager.getTransaction();
//			transaction.begin();
//			try {
//				for(Staff staff : library.getStaff())
//				{
//					entityManager.persist(staff);
//				}
//				entityManager.persist(library);
//				transaction.commit();
//			} finally {
//				if (transaction.isActive())
//					transaction.rollback();
//			}
//			AbstractIdentifiable reloaded = entityManager.find(Library.class, library.getId());
//			assertEquals(library, reloaded);
//		} finally {
//			entityManager.close();
//		}
		
		lendingInformationList = null;
		
		//Library lib = new Library();
				
		lendingInformationList = from(Library.class).join(staff()).filter(new NameFilter()).join(lendingInformation()).get(library);
		
		System.out.println("-----------------------------------------------------");
		System.out.println(lendingInformationList.get(0).getStaff().getFirstName());
		System.out.println("-----------------------------------------------------");
	}

}
