package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EclipseLinkTest {
	public static void main(String[] args){
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("eclipselink");
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
	}
}
