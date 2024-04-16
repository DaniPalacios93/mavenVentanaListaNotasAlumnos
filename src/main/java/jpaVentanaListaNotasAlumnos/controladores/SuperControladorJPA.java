package jpaVentanaListaNotasAlumnos.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import jpaVentanaListaNotasAlumnos.entities.Entidad;



public class SuperControladorJPA {
	
	private static EntityManager em = null;
	private String nombreTabla ="";
	private Class tipoEntidad;

	
	
	// CONSTRUCTOR
	
	public SuperControladorJPA (String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	
	
	//protected, para que las subclases tengan visibilidad sobre este metodo. 
	//Singleton para que solo haya un EntityManager en el programa
	protected EntityManager getEntityManager () {
		if(em == null) {
			em =  Persistence.createEntityManagerFactory("ventanaListaNotaAlumnos").createEntityManager();
		}
		return em;
	}
	
	/**
	 * Esto devuelve una lista de cualquier objeto que extienda de entidad
	 * COmo a la query le metemos como segundo argumento el "tipoEntidad" la lista resiltante sera de ese tipo.
	 * @return
	 */
	public List<? extends Entidad> findAll (){
		return getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad).getResultList();
	}
	
	/**
	 * 
	 * @param e
	 */
	public void updateEntidad (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 */
	public void deleteEntidad (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
	}
	
	/**
	 * 
	 */
	public void insertEntidad (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
