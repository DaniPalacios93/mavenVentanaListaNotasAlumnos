package jpaVentanaListaNotasAlumnos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jpaVentanaListaNotasAlumnos.controladores.ControladorEstudiante;
import jpaVentanaListaNotasAlumnos.controladores.ControladorMateria;
import jpaVentanaListaNotasAlumnos.controladores.ControladorProfesor;
import jpaVentanaListaNotasAlumnos.controladores.ControladorValoracionMateria;
import jpaVentanaListaNotasAlumnos.entities.Estudiante;
import jpaVentanaListaNotasAlumnos.entities.Materia;
import jpaVentanaListaNotasAlumnos.entities.Profesor;
import jpaVentanaListaNotasAlumnos.entities.ValoracionMateria;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PanelPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudiante.getInstance().findAll();
	
	private Materia materiaSeleccionada;
	private Profesor profesorSelecionado;
	private int notaSelecionada;
	
	private JPanel contentPane;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Integer> jcbNota;
	private JFormattedTextField jftfFecha;
	private JList<Estudiante> jlistAlumnadoNoSeleccionado;
	private	DefaultListModel<Estudiante> listModelAlumnadoNoSeleccionado = new DefaultListModel<Estudiante>();
	private JList<Estudiante> jlistAlumnadoSeleccionado;
	private DefaultListModel<Estudiante> listModelAlumnadoSeleccionado = new DefaultListModel<Estudiante>();
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{1, 0, 1, 1};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Materia: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 2;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.gridwidth = 2;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox<Integer>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.gridwidth = 2;
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		
		/// BTN ACTUALIZAR ALUMNADOS
		JButton btnActualizarAlumnado = new JButton("Actualizar alumnado");
		btnActualizarAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarAlumnado();
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Fecha: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		
		GridBagConstraints gbc_jftfFecha = new GridBagConstraints();
		gbc_jftfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jftfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftfFecha.gridx = 1;
		gbc_jftfFecha.gridy = 3;
		panel.add(getJFormattedTextFieldDatePersonalizado(), gbc_jftfFecha);
		
		
		GridBagConstraints gbc_btnActualizarAlumnado = new GridBagConstraints();
		gbc_btnActualizarAlumnado.anchor = GridBagConstraints.EAST;
		gbc_btnActualizarAlumnado.gridx = 2;
		gbc_btnActualizarAlumnado.gridy = 4;
		panel.add(btnActualizarAlumnado, gbc_btnActualizarAlumnado);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnado no seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alumnado seleccionado");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jlistAlumnadoNoSeleccionado = new JList<Estudiante>(listModelAlumnadoNoSeleccionado);
		GridBagConstraints gbc_jlistAlumnadoNoSeleccionado = new GridBagConstraints();
		gbc_jlistAlumnadoNoSeleccionado.insets = new Insets(0, 0, 0, 5);
		gbc_jlistAlumnadoNoSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_jlistAlumnadoNoSeleccionado.gridx = 0;
		gbc_jlistAlumnadoNoSeleccionado.gridy = 1;
		panel_1.add(jlistAlumnadoNoSeleccionado, gbc_jlistAlumnadoNoSeleccionado);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		
		/// BTN ALL LEFT
		JButton btnAllLeft = new JButton("<<");
		btnAllLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allLeft();
			}
		});
		GridBagConstraints gbc_btnAllLeft = new GridBagConstraints();
		gbc_btnAllLeft.insets = new Insets(0, 0, 5, 0);
		gbc_btnAllLeft.gridx = 0;
		gbc_btnAllLeft.gridy = 0;
		panel_2.add(btnAllLeft, gbc_btnAllLeft);
		
		
		/// BTN ONE LEFT
		JButton btnOneLeft = new JButton("<");
		btnOneLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedToTheLeft();
			}
		});
		GridBagConstraints gbc_btnOneLeft = new GridBagConstraints();
		gbc_btnOneLeft.insets = new Insets(0, 0, 5, 0);
		gbc_btnOneLeft.gridx = 0;
		gbc_btnOneLeft.gridy = 1;
		panel_2.add(btnOneLeft, gbc_btnOneLeft);
		
		
		/// BTN ONE RIGHT
		JButton btnOneRight = new JButton(">");
		btnOneRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedToTheRight();
			}
		});
		GridBagConstraints gbc_btnOneRight = new GridBagConstraints();
		gbc_btnOneRight.insets = new Insets(0, 0, 5, 0);
		gbc_btnOneRight.gridx = 0;
		gbc_btnOneRight.gridy = 2;
		panel_2.add(btnOneRight, gbc_btnOneRight);
		
		
		/// BTN ALL RIGHT
		JButton btnAllRight = new JButton(">>");
		btnAllRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allRight();
			}
		});
		GridBagConstraints gbc_btnAllRight = new GridBagConstraints();
		gbc_btnAllRight.gridx = 0;
		gbc_btnAllRight.gridy = 3;
		panel_2.add(btnAllRight, gbc_btnAllRight);
		
		jlistAlumnadoSeleccionado = new JList<Estudiante>(listModelAlumnadoSeleccionado);
		GridBagConstraints gbc_jlistAlumnadoSeleccionado = new GridBagConstraints();
		gbc_jlistAlumnadoSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_jlistAlumnadoSeleccionado.gridx = 2;
		gbc_jlistAlumnadoSeleccionado.gridy = 1;
		panel_1.add(jlistAlumnadoSeleccionado, gbc_jlistAlumnadoSeleccionado);
		
		
		/// BTN SAVE
		JButton btnSave = new JButton("Guardar las notas de los alumnos seleccionados");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveValoracionMateria();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 2;
		contentPane.add(btnSave, gbc_btnSave);
		
		cargaTodasLasmaterias();
		cargarTodosLosProfesores();
		cargarTodasLasNotas();
	}
	
	/**
	 * 
	 * @return
	 */
	private JFormattedTextField getJFormattedTextFieldDatePersonalizado() {
		jftfFecha = new JFormattedTextField(
				new JFormattedTextField.AbstractFormatter() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null && value instanceof Date) {
					return sdf.format(((Date) value));
				}
				return "";
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				try {
					return sdf.parse(text);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error en la fecha");
					return null;
				}
			}
		});
		jftfFecha.setColumns(20);
		jftfFecha.setValue(new Date());
		return jftfFecha;
	}
	
	/**
	 * 
	 */
	private void cargaTodasLasmaterias() {
		ControladorMateria cm = ControladorMateria.getInstance();
		List<Materia> l = (List<Materia>) cm.findAll();
		
		for(Materia m : l) {
			jcbMateria.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void cargarTodosLosProfesores() {
		ControladorProfesor cp = ControladorProfesor.getInsctance();
		List<Profesor> l = (List<Profesor>) cp.findAll();
	
		for(Profesor p : l) {
			jcbProfesor.addItem(p);
		}
	}
	
	/**
	 * 
	 */
	private void cargarTodasLasNotas() {
		
		for (int i = 0; i <= 10; i++) {
			jcbNota.addItem(i);
		}
	}
	
	/**
	 * 
	 */
	private void actualizarAlumnado() {
		
		materiaSeleccionada = (Materia) jcbMateria.getSelectedItem();
		profesorSelecionado = (Profesor) jcbProfesor.getSelectedItem();
		notaSelecionada = (Integer) jcbNota.getSelectedItem();

		listModelAlumnadoSeleccionado.removeAllElements();
		listModelAlumnadoNoSeleccionado.removeAllElements();
		
		
		for(Estudiante e : estudiantes) {
			
			if(ControladorValoracionMateria.getInsctance().existeEstudianteConValoracion(
					materiaSeleccionada, profesorSelecionado, e, notaSelecionada)){
				
				this.listModelAlumnadoSeleccionado.addElement(e);
			}
			else {
				this.listModelAlumnadoNoSeleccionado.addElement(e);
			}
		}
	}
	
	/**
	 * Pasa todos los valores a la lista
	 */
	private void allLeft() {
		
		 if(!listModelAlumnadoSeleccionado.isEmpty()) {
			 
			for(int i = 0; i < listModelAlumnadoSeleccionado.getSize(); i++) {
				
				listModelAlumnadoNoSeleccionado.addElement(listModelAlumnadoSeleccionado.getElementAt(i));
			}
			 listModelAlumnadoSeleccionado.clear();
		 }
	}
	
	/**
	 * 
	 */
	private void allRight() {
		
		 if(!listModelAlumnadoNoSeleccionado.isEmpty()) {
			 
			for(int i = 0; i < listModelAlumnadoNoSeleccionado.getSize(); i++) {
				
				listModelAlumnadoSeleccionado.addElement(listModelAlumnadoNoSeleccionado.getElementAt(i));
			} 
			 listModelAlumnadoNoSeleccionado.clear();
		 }
	}
	
	/**
	 * 
	 */
	private void selectedToTheRight() {
		
		if(!listModelAlumnadoNoSeleccionado.isEmpty()) {
			
			for(int i= this.jlistAlumnadoNoSeleccionado.getSelectedIndices().length - 1; i >= 0; i--) {
				
				this.listModelAlumnadoSeleccionado.addElement(listModelAlumnadoNoSeleccionado.getElementAt(
						this.jlistAlumnadoNoSeleccionado.getSelectedIndices()[i]));
				
				this.listModelAlumnadoNoSeleccionado.removeElementAt(
						this.jlistAlumnadoNoSeleccionado.getSelectedIndices()[i]);
			}
		}
	}
	
	/**
	 * 
	 */
	private void selectedToTheLeft() {
		
		if(!listModelAlumnadoSeleccionado.isEmpty()) {
			
			for(int i= this.jlistAlumnadoSeleccionado.getSelectedIndices().length - 1; i >= 0; i--) {
				
				this.listModelAlumnadoNoSeleccionado.addElement(listModelAlumnadoSeleccionado.getElementAt(
						this.jlistAlumnadoSeleccionado.getSelectedIndices()[i]));
				
				this.listModelAlumnadoSeleccionado.removeElementAt(
						this.jlistAlumnadoSeleccionado.getSelectedIndices()[i]);
			}
		}
	}
	
	/**
	 * Revisa las listas de alumnos seleccionados, cambiando la nota a los alumnos con una valoracion diferente, y
	 * insertando una nueva valoracion para los alumnos que no la tienen. Y la lista de alumnos NO seleccionados, borrando
	 * aquellas entradas de valoracion con la nota seleccionada.
	 */
	private void saveValoracionMateria () {
		
		ControladorValoracionMateria cvm = ControladorValoracionMateria.getInsctance();
		
		// Tratamos la lista de "alumnos seleccionados"
		if(!listModelAlumnadoSeleccionado.isEmpty()) {
			for(int i = 0; i < listModelAlumnadoSeleccionado.getSize(); i++) {
				
				Estudiante estudianteSeleccionado = listModelAlumnadoSeleccionado.getElementAt(i);
				ValoracionMateria valoracion = cvm.estudianteValoracion(materiaSeleccionada, profesorSelecionado, estudianteSeleccionado);

				if (valoracion != null){
					valoracion.setValoracion(notaSelecionada);
					cvm.updateEntidad(valoracion);
				}
				else {
				
					ValoracionMateria nuevaValoracion = new ValoracionMateria();
					nuevaValoracion.setEstudiante(estudianteSeleccionado);
					nuevaValoracion.setMateria(materiaSeleccionada);
					nuevaValoracion.setProfesor(profesorSelecionado);
					nuevaValoracion.setValoracion(notaSelecionada);
					nuevaValoracion.setFecha((Date) jftfFecha.getValue());
					
					cvm.insertEntidad(nuevaValoracion);
				}
			}
		}
			
		// Tratamos la lista de "alumnos NO seleccionado"
		if(!listModelAlumnadoNoSeleccionado.isEmpty()) {
			for(int i = listModelAlumnadoNoSeleccionado.getSize() - 1; i >= 0; i--) {
				
				Estudiante estudianteSeleccionado = listModelAlumnadoNoSeleccionado.getElementAt(i);
				ValoracionMateria valoracion = cvm.estudianteValoracion(materiaSeleccionada, profesorSelecionado, estudianteSeleccionado);
				
				if(valoracion != null && valoracion.getValoracion() == notaSelecionada) {
					cvm.deleteEntidad(valoracion);
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Base de datos actualizada.");
	}
	

}
