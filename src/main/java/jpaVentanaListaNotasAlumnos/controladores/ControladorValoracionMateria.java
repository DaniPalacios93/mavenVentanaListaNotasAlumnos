package jpaVentanaListaNotasAlumnos.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpaVentanaListaNotasAlumnos.entities.Estudiante;
import jpaVentanaListaNotasAlumnos.entities.Materia;
import jpaVentanaListaNotasAlumnos.entities.Profesor;
import jpaVentanaListaNotasAlumnos.entities.ValoracionMateria;

public class ControladorValoracionMateria extends SuperControladorJPA {

private static ControladorValoracionMateria instance = null;
	
	
	public ControladorValoracionMateria() {
		super("valoracionmateria", ValoracionMateria.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControladorValoracionMateria getInsctance() {
		if(instance == null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}
	
	
	/*
	 * 
	 */
	public boolean existeEstudianteConValoracion(Materia materia, Profesor profesor, Estudiante estudiante, int nota) {
		
		EntityManager em = getEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idMateria = " + materia.getId() + 
				" and idProfesor = " + profesor.getId() + " and idEstudiante = " + estudiante.getId() +
				" and valoracion = " + nota , ValoracionMateria.class);
		
		List<ValoracionMateria> v = q.getResultList();
		
		if(v.isEmpty()) return false;
		
		return true;
	}
	
	
}
