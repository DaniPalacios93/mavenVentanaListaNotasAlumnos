package jpaVentanaListaNotasAlumnos.controladores;

import jpaVentanaListaNotasAlumnos.entities.Profesor;

public class ControladorProfesor extends SuperControladorJPA {
	
	private static ControladorProfesor instance = null;
	
	
	public ControladorProfesor() {
		super("profesor", Profesor.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControladorProfesor getInsctance() {
		if(instance == null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}

}
