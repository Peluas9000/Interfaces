package ordenador;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class VentaOrdenador extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel cliente,localidad ;
	private JTextField textField;
	private JComboBox<String> localidades;
	private JTextArea textArea;
	
	private JLabel procesador;
	private JLabel memoria;
	private JLabel monitor;
	private JLabel discoDuro;
	private JLabel opciones;
	private ButtonGroup bg1,bg2,bg3,bg4;
	private JRadioButton botonMemoria1;
	private JRadioButton botonMemoria2;
	private JRadioButton botonMemoria3;
	private JRadioButton botonMemoria4;
	private JRadioButton botonMonitor1;
	private JRadioButton botonMonitor2;
	private JRadioButton botonMonitor3;
	private JRadioButton botonMonitor4;
	private JRadioButton botonDisco1;
	private JRadioButton botonDisco2;
	private JRadioButton botonDisco3;
	private JRadioButton botonDisco4;
	
	private JButton añadir,salir,eliminar;
	private DefaultListModel<String> modelo = new DefaultListModel<>();
	private JList<String> listaClientes = new JList<>(modelo);
	private JButton cancelar = new JButton("Cancelar");
	private JButton buscar = new JButton("Buscar");
		private java.util.Vector<Venta> ventas = new java.util.Vector<>();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaOrdenador frame = new VentaOrdenador();
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
	public VentaOrdenador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 cliente = new JLabel("Nombre Cliente");
		cliente.setBounds(10, 21, 100, 14);
		contentPane.add(cliente);
		
		textField = new JTextField();
		textField.setBounds(114, 18, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 localidad = new JLabel("Localidad");
		localidad.setBounds(10, 53, 46, 14);
		contentPane.add(localidad);
		
		
		
		
		JScrollPane scroll = new JScrollPane(listaClientes);
		scroll.setBounds(262, 21, 108, 60); // aumentamos altura visible
		contentPane.add(scroll);

		
		
		localidades =new JComboBox<String>();
		localidades.setBounds(90, 50, 100, 20);
		getContentPane().add(localidades);
		
		localidades.addItem("Villalba");
		localidades.addItem("Galapagar");
		localidades.addItem("Alpedrete");
		localidades.addItem("Moralzarzal");
		localidades.addItem("Colmenarejo");
		
		
		
		//Partes del ordenador por labels
		procesador = new JLabel("Procesador");
		procesador.setFont(new Font("Tahoma", Font.BOLD, 11));
		procesador.setBounds(10, 103, 76, 14);
		contentPane.add(procesador);
		
		memoria = new JLabel("Memoria");
		memoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		memoria.setBounds(126, 103, 64, 14);
		contentPane.add(memoria);
		
		monitor = new JLabel("Monitor");
		monitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		monitor.setBounds(225, 103, 46, 14);
		contentPane.add(monitor);
		
		discoDuro = new JLabel("Disco Duro");
		discoDuro.setFont(new Font("Tahoma", Font.BOLD, 11));
		discoDuro.setBounds(316, 103, 76, 14);
		contentPane.add(discoDuro);
		
		opciones = new JLabel("Opciones");
		opciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		opciones.setBounds(434, 103, 76, 14);
		contentPane.add(opciones);
		
		//Botones 
		
		bg1=new ButtonGroup();
		JRadioButton botonProcesador1 = new JRadioButton("P4 3.0 Gb");
		botonProcesador1.setBounds(10, 124, 109, 23);
		contentPane.add(botonProcesador1);
		
		JRadioButton botonProcesador2 = new JRadioButton("P4 3.2 Gb");
		botonProcesador2.setBounds(10, 150, 109, 23);
		contentPane.add(botonProcesador2);
		
		JRadioButton botonProcesador3 = new JRadioButton("P4 Celeron");
		botonProcesador3.setBounds(10, 176, 109, 23);
		contentPane.add(botonProcesador3);
		
		JRadioButton botonProcesador4 = new JRadioButton("AMD 650");
		botonProcesador4.setBounds(10, 202, 109, 23);
		contentPane.add(botonProcesador4);
		
		bg1.add(botonProcesador1);
		bg1.add(botonProcesador2);
		bg1.add(botonProcesador3);
		bg1.add(botonProcesador4);
		
		//grupo2 de memoria
		bg2=new ButtonGroup();
		botonMemoria1 = new JRadioButton("128 Mb");
		botonMemoria1.setBounds(124, 124, 100, 23);
		contentPane.add(botonMemoria1);
		
		botonMemoria2 = new JRadioButton("256 Mb");
		botonMemoria2.setBounds(124, 150, 98, 23);
		contentPane.add(botonMemoria2);
		
		botonMemoria3 = new JRadioButton("512 Mb");
		botonMemoria3.setBounds(124, 176, 91, 23);
		contentPane.add(botonMemoria3);
		
		botonMemoria4 = new JRadioButton("1024 Mb");
		botonMemoria4.setBounds(124, 202, 98, 23);
		contentPane.add(botonMemoria4);
		
		bg2.add(botonMemoria1);
		bg2.add(botonMemoria2);
		bg2.add(botonMemoria3);
		bg2.add(botonMemoria4);

		//grupo3 monitor
		bg3=new ButtonGroup();

		botonMonitor1 = new JRadioButton("15\"");
		botonMonitor1.setBounds(225, 124, 76, 23);
		contentPane.add(botonMonitor1);
		
		botonMonitor2 = new JRadioButton("17\"");
		botonMonitor2.setBounds(225, 150, 76, 23);
		contentPane.add(botonMonitor2);
		
		botonMonitor3 = new JRadioButton("TFT 15\"");
		botonMonitor3.setBounds(225, 176, 76, 23);
		contentPane.add(botonMonitor3);
		
		botonMonitor4 = new JRadioButton("TFT 17\"");
		botonMonitor4.setBounds(225, 202, 76, 23);
		contentPane.add(botonMonitor4);
		
		bg3.add(botonMonitor1);
		bg3.add(botonMonitor2);
		bg3.add(botonMonitor3);
		bg3.add(botonMonitor4);

		
		//grupo4 disco 
		bg4=new ButtonGroup();

		botonDisco1 = new JRadioButton("60 Gb");
		botonDisco1.setBounds(316, 124, 85, 23);
		contentPane.add(botonDisco1);
		
		botonDisco2 = new JRadioButton("80  Gb");
		botonDisco2.setBounds(316, 150, 76, 23);
		contentPane.add(botonDisco2);
		
		botonDisco3 = new JRadioButton("120 Gb");
		botonDisco3.setBounds(316, 176, 64, 23);
		contentPane.add(botonDisco3);
		
		botonDisco4 = new JRadioButton("200 Gb");
		botonDisco4.setBounds(316, 202, 85, 23);
		contentPane.add(botonDisco4);
		
		bg4.add(botonDisco1);
		bg4.add(botonDisco2);
		bg4.add(botonDisco3);
		bg4.add(botonDisco4);
		
		
		//opciones check
		JCheckBox opciones1 = new JCheckBox("Grabadora DVD");
		opciones1.setBounds(417, 124, 138, 23);
		contentPane.add(opciones1);
		
		JCheckBox opciones2 = new JCheckBox("Wifi");
		opciones2.setBounds(417, 150, 138, 23);
		contentPane.add(opciones2);
		
		JCheckBox opciones3 = new JCheckBox("Sintonizador TV");
		opciones3.setBounds(417, 176, 138, 23);
		contentPane.add(opciones3);
		
		JCheckBox opciones4 = new JCheckBox("Backup/Restore");
		opciones4.setBounds(417, 202, 116, 23);
		contentPane.add(opciones4);
		
		 añadir = new JButton("Añadir");
		añadir.setBounds(10, 269, 89, 23);
		añadir.addActionListener(this);
		contentPane.add(añadir);
	
		
		buscar.setBounds(114, 269, 89, 23);
		buscar.addActionListener(this);
		contentPane.add(buscar);
		
		 eliminar = new JButton("Eliminar");
		eliminar.setBounds(212, 269, 89, 23);
		eliminar.addActionListener(this);
		contentPane.add(eliminar);
		
		cancelar.setBounds(485, 249, 89, 23);
		cancelar.addActionListener(this);
		contentPane.add(cancelar);
		
		 salir = new JButton("Salir");
		salir.setBounds(485, 283, 89, 23);
		salir.addActionListener(this);
		contentPane.add(salir);
		
	
		
		añadir.setEnabled(false);
		buscar.setEnabled(false);
		eliminar.setEnabled(false);
		botonProcesador1.setEnabled(false);
		botonProcesador2.setEnabled(false);
		botonProcesador3.setEnabled(false);
		botonProcesador4.setEnabled(false);
		
		botonDisco1.setEnabled(false);
		botonDisco2.setEnabled(false);
		botonDisco3.setEnabled(false);
		botonDisco4.setEnabled(false);
		
		botonMemoria1.setEnabled(false);
		botonMemoria2.setEnabled(false);
		botonMemoria3.setEnabled(false);
		botonMemoria4.setEnabled(false);
		
		botonMonitor1.setEnabled(false);
		botonMonitor2.setEnabled(false);
		botonMonitor3.setEnabled(false);
		botonMonitor4.setEnabled(false);

		textField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        if (textField.getText().length() >= 15)
		            e.consume(); // bloquea más escritura
		    }
		});
		
		textField.addActionListener(e -> {
			String nombre = textField.getText().trim();
			if (!nombre.isEmpty()) {
				modelo.addElement(nombre);
				textField.setText("");
				textField.requestFocus();

				// Activar botones cuando haya al menos un cliente
				añadir.setEnabled(true);
				buscar.setEnabled(true);
				eliminar.setEnabled(true);
				botonProcesador1.setEnabled(true);
				botonProcesador2.setEnabled(true);
				botonProcesador3.setEnabled(true);
				botonProcesador4.setEnabled(true);
				
				botonDisco1.setEnabled(true);
				botonDisco2.setEnabled(true);
				botonDisco3.setEnabled(true);
				botonDisco4.setEnabled(true);
				
				botonMemoria1.setEnabled(true);
				botonMemoria2.setEnabled(true);
				botonMemoria3.setEnabled(true);
				botonMemoria4.setEnabled(true);
				
				botonMonitor1.setEnabled(true);
				botonMonitor2.setEnabled(true);
				botonMonitor3.setEnabled(true);
				botonMonitor4.setEnabled(true);

				

				
		        if (!nombre.isEmpty() && !modelo.contains(nombre)) {
		            modelo.addElement(nombre);
		            textField.setText("");
		        }
			}
		});
		
		botonProcesador2.setSelected(true);
		botonMemoria4.setSelected(true);
		botonMonitor4.setSelected(true);
		botonDisco4.setSelected(true);
		
	}
		
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == salir) {
	        System.exit(0);
	    }

	    if (e.getSource() == eliminar) {
	        String nombreSel = listaClientes.getSelectedValue();

	        if (nombreSel == null) {
	            JOptionPane.showMessageDialog(this, "Selecciona un cliente para eliminar.");
	            return;
	        }

	        int confirm = JOptionPane.showConfirmDialog(
	            this,
	            "¿Seguro que deseas eliminar la venta de " + nombreSel + "?",
	            "Confirmar eliminación",
	            JOptionPane.YES_NO_OPTION
	        );

	        if (confirm == JOptionPane.YES_OPTION) {
	            // Eliminar del vector de ventas
	            ventas.removeIf(v -> v.getNombreCliente().equalsIgnoreCase(nombreSel));

	            // Eliminar del modelo de la lista
	            modelo.removeElement(nombreSel);

	            // Limpiar campos
	            textField.setText("");
	            bg1.clearSelection();
	            bg2.clearSelection();
	            bg3.clearSelection();
	            bg4.clearSelection();
	            for (var comp : contentPane.getComponents()) {
	                if (comp instanceof JCheckBox) {
	                    ((JCheckBox) comp).setSelected(false);
	                }
	            }

	            JOptionPane.showMessageDialog(this, "Venta eliminada correctamente.");

	            // Restaurar botones
	            añadir.setEnabled(true);
	            buscar.setEnabled(true);
	            eliminar.setEnabled(false);
	        }
	    }


	    // 🔹 Añadir cliente
	    if (e.getSource() == añadir) {
	        String nombre = textField.getText().trim();

	        if (nombre.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Introduce un nombre.", "Aviso", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        if (modelo.contains(nombre)) {
	            JOptionPane.showMessageDialog(this, "Ese cliente ya está en la lista.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }

	        // Añadir nombre al JList
	        modelo.addElement(nombre);

	        String localidadSel = (String) localidades.getSelectedItem();
	        String procesadorSel = getSelectedButtonText(bg1);
	        String memoriaSel = getSelectedButtonText(bg2);
	        String monitorSel = getSelectedButtonText(bg3);
	        String discoSel = getSelectedButtonText(bg4);

	        java.util.List<String> opcionesSel = new java.util.ArrayList<>();
	        for (var comp : contentPane.getComponents()) {
	            if (comp instanceof JCheckBox chk && chk.isSelected()) {
	                opcionesSel.add(chk.getText());
	            }
	        }

	        // Crear y guardar la venta
	        Venta nuevaVenta = new Venta(nombre, localidadSel, procesadorSel, memoriaSel, monitorSel, discoSel, opcionesSel);
	        ventas.add(nuevaVenta);

	        System.out.println("✅ Venta añadida: " + nuevaVenta);
	        textField.setText("");
	    }



	    // 🔹 Buscar cliente
	    if (e.getSource() == buscar) {
	        String nombre = textField.getText().trim();

	        if (nombre.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Introduce un nombre de cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        // Filtramos las ventas del cliente
	        java.util.List<Venta> ventasCliente = new java.util.ArrayList<>();
	        for (Venta v : ventas) {
	            if (v.getNombreCliente().equalsIgnoreCase(nombre)) {
	                ventasCliente.add(v);
	            }
	        }

	        if (ventasCliente.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No se han encontrado ventas para el cliente: " + nombre);
	            return;
	        }

	        // Mostrar la primera venta y preguntar si quiere ver más
	        int index = 0;
	        boolean continuar = true;

	        while (continuar && index < ventasCliente.size()) {
	            Venta v = ventasCliente.get(index);

	            // Mostramos los datos de la venta
	            JOptionPane.showMessageDialog(
	                this,
	                "Venta nº " + (index + 1) + ":\n" +
	                "Cliente: " + v.getNombreCliente() + "\n" +
	                "Localidad: " + v.getLocalidad() + "\n" +
	                "Procesador: " + v.getProcesador() + "\n" +
	                "Memoria: " + v.getMemoria() + "\n" +
	                "Monitor: " + v.getMonitor() + "\n" +
	                "Disco Duro: " + v.getDiscoDuro() + "\n" +
	                "Opciones: " + String.join(", ", v.getOpciones()),
	                "Detalle de venta", JOptionPane.INFORMATION_MESSAGE
	            );

	            index++;
	            if (index < ventasCliente.size()) {
	                int respuesta = JOptionPane.showConfirmDialog(
	                    this,
	                    "¿Deseas ver la siguiente venta de este cliente?",
	                    "Continuar búsqueda",
	                    JOptionPane.YES_NO_OPTION
	                );
	                continuar = (respuesta == JOptionPane.YES_OPTION);
	            }
	        }
	    }

	    
	    if (e.getSource()==cancelar) {
	        textField.setText("");
	        listaClientes.clearSelection();
	        localidades.setSelectedIndex(0);

	        // Desmarcar todos los radio buttons
	        bg1.clearSelection();
	        bg2.clearSelection();
	        bg3.clearSelection();
	        bg4.clearSelection();

	        // Desmarcar todos los checkboxes
	        for (var comp : contentPane.getComponents()) {
	            if (comp instanceof JCheckBox) {
	                ((JCheckBox) comp).setSelected(false);
	            }
	        }
	    }
	}
	
	private String getSelectedButtonText(ButtonGroup bg) {
	    for (java.util.Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = buttons.nextElement();
	        if (button.isSelected()) {
	            return button.getText();
	        }
	    }
	    return "No seleccionado";
	}
	

	
		
	}

