package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ordenador.Venta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Ventana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton boton2 = new JButton("Ventana 1");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana1 v1=new Ventana1();
				v1.setVisible(true);
			}
		});
		boton2.setBounds(38, 87, 133, 65);
		contentPane.add(boton2);
		
		JButton boton3 = new JButton("Ventana 3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana3 v3=new Ventana3();
				v3.setVisible(true);
			}
		});
		boton3.setBounds(264, 95, 112, 57);
		contentPane.add(boton3);

	}

}
