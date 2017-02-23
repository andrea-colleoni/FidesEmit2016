package it.emit.java.sakila.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import it.emit.java.sakila.Film;

public class FilmTest {

	EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("sakila");
	}

	@Test
	public void test() {
		EntityManager em = emf.createEntityManager();
		Film f = em.find(Film.class, 1);
		assertNotNull(f);
	}

}
