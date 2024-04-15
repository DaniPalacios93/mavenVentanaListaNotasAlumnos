package jpaVentanaListaNotasAlumnos.controladores;

import jpaVentanaListaNotasAlumnos.entities.Estudiante;


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
	

}
