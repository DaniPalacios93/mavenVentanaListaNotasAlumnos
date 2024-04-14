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
	 * @return
	 */
	private List<? extends Entidad> findAll (){
		return (List<Entidad>) getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad).getResultList();
	}
	
	/**
	 * 
	 * @param e
	 */
	private void update (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
}
