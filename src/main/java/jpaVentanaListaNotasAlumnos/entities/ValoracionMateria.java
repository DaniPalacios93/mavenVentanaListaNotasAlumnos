package jpaVentanaListaNotasAlumnos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valoracionmateria")
public class ValoracionMateria extends Entidad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProfesor")
	private Profesor profesor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstudiante")
	private Estudiante estudiante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMateria")
	private Materia materia;
	
	private float valoracion;
	private Date fecha;
	
	
	// CONSTRUCTORES

	public ValoracionMateria() {
		super();
	}
	
	
	// GETTERS & SETTERS
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}


}
