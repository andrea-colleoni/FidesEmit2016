package it.emit.java.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("15novembre-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Automobile a = em.find(Automobile.class, "AB123CD");	
		//System.out.println(a.getModello());
		//inserimento(em);
		List<Automobile> lista = em.createQuery(
				"Select a From Automobile a Where a.marca='Fiat'",
				Automobile.class).getResultList();
		lista.forEach(a -> System.out.println(a.getModello()));
		
	}
	
	public static void inserimento(EntityManager em) {
		Automobile auto = new Automobile();
		auto.setCilindrata(1600);
		auto.setDataImmatricolazione(new Date());
		auto.setMarca("Opel");
		auto.setModello("Corsa");
		auto.setTarga("AB127CD");
		auto.setVelocitaMax(320);

		em.getTransaction().begin();
		em.persist(auto);
		em.getTransaction().commit();
	}
	
	public void modifica(EntityManager em) {
		Automobile a = em.find(Automobile.class, "AB123CD");
		a.setModello("Grande Punto");
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();			
	}

}
