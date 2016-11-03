package de.dhbw.stuttgart.swe2.library.jpa.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dhbw.stuttgart.swe2.library.jpa.AbstractIdentifiable;
import de.dhbw.stuttgart.swe2.library.jpa.Book;
import de.dhbw.stuttgart.swe2.library.jpa.Customer;
import de.dhbw.stuttgart.swe2.library.jpa.IdCard;
import de.dhbw.stuttgart.swe2.library.jpa.LendingInformation;
import de.dhbw.stuttgart.swe2.library.jpa.LendingObject;

public class PersistenceTest5 {

	//private static final String PERSISTENCE_UNIT_NAME = "derby-embedded-inmemory";
	private static final String PERSISTENCE_UNIT_NAME = "derby-network";

	private static EntityManagerFactory factory;

	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PersistenceTest.class);

	@org.junit.BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	@Test
	public void testCustomer() {
		
		//Why is the customer-ID in idCard not automatically set without explicitly telling idCard to take the customer id
		Customer customer = new Customer();
		IdCard idCard = new IdCard();
		Date date = new Date();
		date.getTime();
		
		idCard.setValidUntil(date);
		idCard.setCustomer(customer);
		customer.setIdCard(idCard);
		
		
		List<LendingObject> lendingObjectList = new ArrayList<LendingObject>();
		List<LendingInformation> lendingInformationList = new ArrayList<LendingInformation>();
		
		LendingInformation lendingInformation = new LendingInformation();

		LendingObject lendingObject = new LendingObject();
		lendingObjectList.add(lendingObject);
		lendingInformationList.add(lendingInformation);
		
		Book book = new Book();
		book.setLendingObjects(lendingObjectList);
		
		lendingObject.setLendingInfo(lendingInformationList);
		lendingObject.setObjectInformation(book);
		
		lendingInformation.setCustomer(customer);
		lendingInformation.setLendingObject(lendingObject);
		
		EntityManager entityManager = factory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			try {
				entityManager.persist(lendingInformation);
				entityManager.persist(lendingObject);
				entityManager.persist(book);
				entityManager.persist(idCard);
				entityManager.persist(customer);
				transaction.commit();
			} finally {
				if (transaction.isActive())
					transaction.rollback();
			}
			AbstractIdentifiable reloaded = entityManager.find(Customer.class, customer.getId());
			assertEquals(customer, reloaded);
		} finally {
			entityManager.close();
		}
	}

}
