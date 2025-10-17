package fda;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;

public class VentaOrdenador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel cliente,localidad ;
	private JTextField textField;
	private JComboBox<String> localidades;
	private JTextArea textArea;
	private JLabel listaClientes;
	private JLabel procesador;
	private JLabel memoria;
	private JLabel monitor;
	private JLabel discoDuro;
	private JLabel opciones;
	private ButtonGroup bg1;
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(380, 16, 153, 69);
		contentPane.add(textArea_1);
		
		listaClientes = new JLabel("Lista de clientes");
		listaClientes.setBounds(262, 21, 108, 14);
		contentPane.add(listaClientes);
		
		localidades =new JComboBox<String>();
		localidades.setBounds(90, 50, 100, 20);
		getContentPane().add(localidades);
		
		localidades.addItem("Villalba");
		localidades.addItem("Galapagar");
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
		discoDuro.setBounds(371, 103, 76, 14);
		contentPane.add(discoDuro);
		
		opciones = new JLabel("Opciones");
		opciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		opciones.setBounds(496, 103, 76, 14);
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
		
		botonMonitor1 = new JRadioButton("New radio button");
		botonMonitor1.setBounds(225, 124, 109, 23);
		contentPane.add(botonMonitor1);
		
		botonMonitor2 = new JRadioButton("New radio button");
		botonMonitor2.setBounds(225, 150, 109, 23);
		contentPane.add(botonMonitor2);
		
		botonMonitor3 = new JRadioButton("New radio button");
		botonMonitor3.setBounds(225, 176, 109, 23);
		contentPane.add(botonMonitor3);
		
		botonMonitor4 = new JRadioButton("New radio button");
		botonMonitor4.setBounds(225, 202, 109, 23);
		contentPane.add(botonMonitor4);
		
		botonDisco1 = new JRadioButton("New radio button");
		botonDisco1.setBounds(359, 124, 109, 23);
		contentPane.add(botonDisco1);
		
		botonDisco2 = new JRadioButton("New radio button");
		botonDisco2.setBounds(359, 150, 109, 23);
		contentPane.add(botonDisco2);
		
		botonDisco3 = new JRadioButton("New radio button");
		botonDisco3.setBounds(359, 176, 109, 23);
		contentPane.add(botonDisco3);
		
		botonDisco4 = new JRadioButton("New radio button");
		botonDisco4.setBounds(359, 202, 109, 23);
		contentPane.add(botonDisco4);
		
		
		
		
		
	}
}
