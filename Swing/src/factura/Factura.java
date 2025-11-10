
package factura;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Factura extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField asuntoText;
	private JTextField cantidadText;
	private JComboBox<String> tipoCombo;
	private JButton añadir, editar, eliminar;
	private JLabel lblMensaje;

	// COMPONENTES AÑADIDOS
	private JSpinner spinnerDia, spinnerMes, spinnerAnio;
	private JList<String> listaFacturas;
	private DefaultListModel<String> modeloLista;

	// ALMACENAMIENTO DE DATOS
	private ArrayList<FacturaObjeto> facturas;
	private int indiceEdicion = -1; // -1 = modo añadir, >= 0 = modo editar
	private JButton exportarPdf;

	/**
	 * Create the frame.
	 */
	public Factura() {
		// Inicializar lista de facturas
		facturas = new ArrayList<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ETIQUETAS
		JLabel asunto = new JLabel("Asunto:");
		asunto.setBounds(10, 14, 180, 14);
		contentPane.add(asunto);

		JLabel fecha = new JLabel("Fecha:");
		fecha.setBounds(10, 44, 150, 14);
		contentPane.add(fecha);

		JLabel cantidad = new JLabel("Cantidad:");
		cantidad.setBounds(10, 74, 100, 14);
		contentPane.add(cantidad);

		JLabel tipo = new JLabel("Tipo:");
		tipo.setBounds(10, 104, 46, 14);
		contentPane.add(tipo);

		// CAMPO ASUNTO (1)
		asuntoText = new JTextField();
		asuntoText.setBounds(200, 11, 150, 20);
		contentPane.add(asuntoText);
		asuntoText.setColumns(10);

		// CAMPO CANTIDAD (3)
		cantidadText = new JTextField();
		cantidadText.setBounds(200, 71, 100, 20);
		contentPane.add(cantidadText);
		cantidadText.setColumns(10);

		// SPINNERS DE FECHA (2)
		// Día: 1-31
		SpinnerNumberModel modeloDia = new SpinnerNumberModel(1, 1, 31, 1);
		spinnerDia = new JSpinner(modeloDia);
		spinnerDia.setBounds(200, 41, 50, 20);
		JSpinner.NumberEditor editorDia = new JSpinner.NumberEditor(spinnerDia, "#");
		spinnerDia.setEditor(editorDia);
		contentPane.add(spinnerDia);

		// Mes: 1-12
		SpinnerNumberModel modeloMes = new SpinnerNumberModel(1, 1, 12, 1);
		spinnerMes = new JSpinner(modeloMes);
		spinnerMes.setBounds(265, 41, 50, 20);
		JSpinner.NumberEditor editorMes = new JSpinner.NumberEditor(spinnerMes, "#");
		spinnerMes.setEditor(editorMes);
		contentPane.add(spinnerMes);

		// Año: 2020-2100
		SpinnerNumberModel modeloAnio = new SpinnerNumberModel(2024, 2020, 2100, 1);
		spinnerAnio = new JSpinner(modeloAnio);
		spinnerAnio.setBounds(330, 41, 70, 20);
		JSpinner.NumberEditor editorAnio = new JSpinner.NumberEditor(spinnerAnio, "#");
		spinnerAnio.setEditor(editorAnio);
		contentPane.add(spinnerAnio);

		// COMBOBOX TIPO (4)
		tipoCombo = new JComboBox<>();
		tipoCombo.setBounds(200, 101, 150, 22);
		contentPane.add(tipoCombo);
		tipoCombo.addItem("Empresas");
		tipoCombo.addItem("Particulares");

		// JLIST DE FACTURAS (5)
		modeloLista = new DefaultListModel<>();
		listaFacturas = new JList<>(modeloLista);
		listaFacturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Listener para detectar selección
		listaFacturas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int indice = listaFacturas.getSelectedIndex();
					if (indice >= 0) {
						mostrarMensaje("Factura seleccionada. Puede Editar o Eliminar", new Color(0, 100, 200));
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(listaFacturas);
		scrollPane.setBounds(10, 140, 400, 150);
		contentPane.add(scrollPane);

		// BOTONES (7, 8, 9)
		añadir = new JButton("Añadir");
		añadir.setBounds(420, 140, 110, 30);
		contentPane.add(añadir);

		editar = new JButton("Editar");
		editar.setBounds(420, 180, 110, 30);
		contentPane.add(editar);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(420, 220, 110, 30);
		contentPane.add(eliminar);

		// LABEL DE MENSAJES (6)
		lblMensaje = new JLabel("Bienvenido al Gestor de Facturas");
		lblMensaje.setBounds(10, 310, 520, 30);
		lblMensaje.setForeground(new Color(0, 150, 0));
		contentPane.add(lblMensaje);
		
		exportarPdf = new JButton("Exportar PDF");
		
		exportarPdf.setBounds(420, 255, 110, 30);
		contentPane.add(exportarPdf);

		// Action en botones
		añadir.addActionListener(this);
		editar.addActionListener(this);
		eliminar.addActionListener(this);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == añadir) {
			if (indiceEdicion == -1) {
				añadirFactura();
			} else {
				actualizarFactura();
			}
		} else if (e.getSource() == editar) {
			editarFactura();
		} else if (e.getSource() == eliminar) {
			eliminarFactura();
		}else if(e.getSource()==exportarPdf) {
			
			    GestionFacturas.exportarFacturasAPDF(this.getFacturas());
			
		}
		
	}

	// MÉTODO AÑADIR FACTURA
	private void añadirFactura() {
		try {
			// 1. VALIDAR ASUNTO (1-10 caracteres)
			String asunto = asuntoText.getText().trim();
			if (asunto.isEmpty() || asunto.length() > 10) {
				mostrarMensaje("ERROR: El asunto debe tener entre 1 y 10 caracteres", Color.RED);
				return;
			}

			// 2. VERIFICAR QUE NO EXISTE EL ASUNTO
			if (existeAsunto(asunto)) {
				mostrarMensaje("ERROR: Ya existe una factura con ese asunto", Color.RED);
				return;
			}

			// 3. VALIDAR FECHA
			int dia = (Integer) spinnerDia.getValue();
			int mes = (Integer) spinnerMes.getValue();
			int anio = (Integer) spinnerAnio.getValue();

			LocalDate fecha = validarFecha(dia, mes, anio);
			if (fecha == null) {
				return; // El error ya fue mostrado en validarFecha
			}

			// 4. VALIDAR CANTIDAD
			Double cantidad = validarCantidad();
			if (cantidad == null) {
				return; // El error ya fue mostrado en validarCantidad
			}

			// 5. OBTENER TIPO
			String tipo = (String) tipoCombo.getSelectedItem();

			// 6. CREAR Y AÑADIR FACTURA
			FacturaObjeto nuevaFactura = new FacturaObjeto(asunto, String.valueOf(cantidad), tipo, fecha);
			facturas.add(nuevaFactura);

			// 7. AÑADIR AL JLIST CON FORMATO
			String facturaTexto = formatearFactura(nuevaFactura);
			modeloLista.addElement(facturaTexto);

			limpiarFormulario();
			mostrarMensaje("✓ Factura añadida correctamente", new Color(0, 150, 0));

		} catch (Exception ex) {
			mostrarMensaje("ERROR: " + ex.getMessage(), Color.RED);
		}
	}

	// MÉTODO EDITAR FACTURA
	private void editarFactura() {
		int indice = listaFacturas.getSelectedIndex();

		if (indice == -1) {
			mostrarMensaje("ERROR: Debe seleccionar una factura para editar", Color.RED);
			return;
		}

		// Obtener la factura seleccionada
		FacturaObjeto factura = facturas.get(indice);

		// Cargar datos en el formulario
		asuntoText.setText(factura.getAsunto());
		spinnerDia.setValue(factura.getFecha().getDayOfMonth());
		spinnerMes.setValue(factura.getFecha().getMonthValue());
		spinnerAnio.setValue(factura.getFecha().getYear());
		cantidadText.setText(factura.getCantidad());
		tipoCombo.setSelectedItem(factura.getTipo());

		// Activar modo edición
		indiceEdicion = indice;
		añadir.setText("Actualizar");
		asuntoText.setEditable(false);
		asuntoText.setBackground(new Color(240, 240, 240));

		mostrarMensaje("Modo edición: Modifique los campos y pulse Actualizar", new Color(0, 100, 200));
	}

	// MÉTODO ACTUALIZAR FACTURA
	private void actualizarFactura() {
		try {
			// 1. OBTENER ASUNTO (no se cambia)
			String asunto = asuntoText.getText().trim();

			// 2. VALIDAR FECHA
			int dia = (Integer) spinnerDia.getValue();
			int mes = (Integer) spinnerMes.getValue();
			int anio = (Integer) spinnerAnio.getValue();

			LocalDate fecha = validarFecha(dia, mes, anio);
			if (fecha == null) {
				return;
			}

			// 3. VALIDAR CANTIDAD
			Double cantidad = validarCantidad();
			if (cantidad == null) {
				return;
			}

			// 4. OBTENER TIPO
			String tipo = (String) tipoCombo.getSelectedItem();

			// 5. ACTUALIZAR LA FACTURA
			FacturaObjeto facturaActualizada = new FacturaObjeto(asunto, String.valueOf(cantidad), tipo, fecha);
			facturas.set(indiceEdicion, facturaActualizada);

			// 6. ACTUALIZAR EN EL JLIST
			String facturaTexto = formatearFactura(facturaActualizada);
			modeloLista.set(indiceEdicion, facturaTexto);

			// 7. SALIR DEL MODO EDICIÓN
			cancelarModoEdicion();
			mostrarMensaje("✓ Factura actualizada correctamente", new Color(0, 150, 0));

		} catch (Exception ex) {
			mostrarMensaje("ERROR: " + ex.getMessage(), Color.RED);
		}
	}

	// MÉTODO ELIMINAR FACTURA
	private void eliminarFactura() {
		int indice = listaFacturas.getSelectedIndex();

		if (indice == -1) {
			mostrarMensaje("ERROR: Debe seleccionar una factura para eliminar", Color.RED);
			return;
		}

		// Confirmar eliminación
		int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta factura?",
				"Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (confirmacion == JOptionPane.YES_OPTION) {
			// Eliminar de las listas
			facturas.remove(indice);
			modeloLista.remove(indice);

			// Si estábamos editando esta factura, cancelar modo edición
			if (indiceEdicion == indice) {
				cancelarModoEdicion();
			}

			mostrarMensaje("✓ Factura eliminada correctamente", new Color(0, 150, 0));
		}
	}

	// MÉTODOS DE VALIDACIÓN

	private LocalDate validarFecha(int dia, int mes, int anio) {
		try {
			// Intentar crear la fecha (valida automáticamente fechas imposibles)
			LocalDate fecha = LocalDate.of(anio, mes, dia);

			// Validar que sea >= 01/01/2020
			LocalDate fechaMinima = LocalDate.of(2020, 1, 1);
			if (fecha.isBefore(fechaMinima)) {
				mostrarMensaje("ERROR: La fecha debe ser posterior al 1 de enero de 2020", Color.RED);
				return null;
			}

			return fecha;

		} catch (DateTimeException e) {
			mostrarMensaje("ERROR: Fecha inválida. Ej: 40/01/2020 no existe", Color.RED);
			return null;
		}
	}

	private Double validarCantidad() {
		String cantidadTexto = cantidadText.getText().trim();

		if (cantidadTexto.isEmpty()) {
			mostrarMensaje("ERROR: La cantidad no puede estar vacía", Color.RED);
			return null;
		}

		try {
			double cantidad = Double.parseDouble(cantidadTexto);

			if (cantidad < 0) {
				mostrarMensaje("ERROR: La cantidad debe ser mayor o igual a 0", Color.RED);
				return null;
			}

			return cantidad;

		} catch (NumberFormatException e) {
			mostrarMensaje("ERROR: La cantidad debe ser un número válido. Ej: 100.50", Color.RED);
			return null;
		}
	}

	private boolean existeAsunto(String asunto) {
		for (FacturaObjeto f : facturas) {
			if (f.getAsunto().equalsIgnoreCase(asunto)) {
				return true;
			}
		}
		return false;
	}

	// MÉTODOS AUXILIARES

	private String formatearFactura(FacturaObjeto factura) {
		// Formato: Asunto : DD/MM/AAAA : Cantidad€ : Tipo
		LocalDate fecha = factura.getFecha();
		String fechaFormateada = String.format("%02d/%02d/%04d", fecha.getDayOfMonth(), fecha.getMonthValue(),
				fecha.getYear());

		return factura.getAsunto() + " : " + fechaFormateada + " : " + factura.getCantidad() + "€ : "
				+ factura.getTipo();
	}
	
	private void limpiarFormulario() {
		asuntoText.setText("");
		spinnerDia.setValue(1);
		spinnerMes.setValue(1);
		spinnerAnio.setValue(2024);
		cantidadText.setText("");
		tipoCombo.setSelectedIndex(0);
		listaFacturas.clearSelection();
	}

	private void cancelarModoEdicion() {
		indiceEdicion = -1;
		añadir.setText("Añadir");
		asuntoText.setEditable(true);
		asuntoText.setBackground(Color.WHITE);
		limpiarFormulario();
	}

	private void mostrarMensaje(String msg, Color color) {
		lblMensaje.setForeground(color);
		lblMensaje.setText(msg);
	}
	
	public ArrayList<FacturaObjeto> getFacturas() {
	    return facturas;
	}

	


}
