package jpaVentanaListaNotasAlumnos.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia extends Entidad{
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String Acronimo;
	private int curso_id;
	
	@OneToMany(mappedBy = "materia")
	private List<ValoracionMateria> notas;

	
	// CONSTRUCTOR
	
	public Materia() {
		super();
	}


	// GETTERS & SETTERS
	
	@Override
	public String toString() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return Acronimo;
	}

	public void setAcronimo(String acronimo) {
		Acronimo = acronimo;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
	
}
