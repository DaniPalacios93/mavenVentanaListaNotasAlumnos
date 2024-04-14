package jpaVentanaListaNotasAlumnos.controladores;

import jpaVentanaListaNotasAlumnos.entities.Materia;

public class ControladorMateria extends SuperControladorJPA {

	
	private static ControladorMateria instance = null;
	
	
	public ControladorMateria() {
		super("materia", Materia.class);
	}
	
	
	
	public static ControladorMateria getInstance() {
		if(instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}
}
