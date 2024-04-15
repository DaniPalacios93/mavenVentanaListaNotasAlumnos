package jpaVentanaListaNotasAlumnos.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpaVentanaListaNotasAlumnos.entities.Estudiante;
import jpaVentanaListaNotasAlumnos.entities.Materia;
import jpaVentanaListaNotasAlumnos.entities.Profesor;
import tutorialJava.modelosBasesDeDatosComunesJPA.ventaDeCoches.Coche;

public class ControladorEstudiante extends SuperControladorJPA {
	
	private static ControladorEstudiante instance = null;
	
	
	public ControladorEstudiante() {
		super ("estudiante", Estudiante.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControladorEstudiante getInstance() {
		if (instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	
	
	
	public boolean existeEstudiante(Materia materia, Profesor profesor, int nota) {
		
		EntityManager em = getEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM coche where id = ?",
				Coche.class);
		
		return true;
	}
	
	

}
