package fda;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Correo extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_para;
	private JTextField textField_copia;
	private JTextField textField_copia_oculta;
	private JTextField textField_asunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Correo frame = new Correo();
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
	JButton aceptar;
	JScrollPane scrollpane1;
	JTextArea textArea;
	private JButton btnNewButton;
	String palabra_clave="mostaza";
	private JTextField palabraClave;
	private JLabel bool;
	public Correo() {
		setTitle("  ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPara = new JLabel("Para");
		labelPara.setBounds(10, 11, 66, 21);
		contentPane.add(labelPara);
		
		JLabel lblNewLabel_1 = new JLabel("Copia");
		lblNewLabel_1.setBounds(10, 43, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		textArea = new JTextArea();
		scrollpane1=new JScrollPane(textArea);
		scrollpane1.setBounds(24, 149, 400, 112);
		contentPane.add(scrollpane1);
		
		
		JLabel lblNewLabel_2 = new JLabel("CopiaOculta");
		lblNewLabel_2.setBounds(10, 90, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_para = new JTextField();
		textField_para.setBounds(105, 11, 177, 20);
		contentPane.add(textField_para);
		textField_para.setColumns(10);
		
		textField_copia = new JTextField();
		textField_copia.setBounds(105, 40, 177, 20);
		contentPane.add(textField_copia);
		textField_copia.setColumns(10);
		
		textField_copia_oculta = new JTextField();
		textField_copia_oculta.setBounds(105, 87, 177, 20);
		contentPane.add(textField_copia_oculta);
		textField_copia_oculta.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Asunto");
		lblNewLabel_3.setBounds(10, 124, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_asunto = new JTextField();
		textField_asunto.setBounds(105, 118, 177, 20);
		contentPane.add(textField_asunto);
		textField_asunto.setColumns(10);
		
		 aceptar = new JButton("ACEPTAR");
		aceptar.setBounds(323, 10, 89, 23);
		contentPane.add(aceptar);
		
		btnNewButton = new JButton("Palabra clave");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(315, 39, 106, 23);
		contentPane.add(btnNewButton);
		
		palabraClave = new JTextField();
		palabraClave.setBounds(346, 87, 66, 20);
		contentPane.add(palabraClave);
		palabraClave.setColumns(10);
		
		bool = new JLabel("");
		bool.setBounds(292, 90, 46, 14);
		contentPane.add(bool);
		
		aceptar.addActionListener(this);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aceptar){
			textField_para.setText("");
			textField_copia.setText("");
			textField_copia_oculta.setText("");
			textField_asunto.setText("");
			textArea.setText("");
		}
		
		if(e.getSource()==btnNewButton) {
			if(textArea.getText().contains(palabraClave.getText())) {
				bool.setText("true");
			}else {
				bool.setText("false");
			}
			
		}
		
	}

}
