package fda;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AceptarContinuar extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField texto1;
	private JCheckBox aceptar;
	private JButton continuar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceptarContinuar frame = new AceptarContinuar();
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
	public AceptarContinuar() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		aceptar=new JCheckBox("Aceptar");
		aceptar.setBounds(10,100,50,30);
		aceptar.addChangeListener(this);
		getContentPane().add(aceptar);
		
		continuar =new JButton("Continuar");
		continuar.setEnabled(false);
		continuar.addActionListener(this);
		getContentPane().add(continuar);
		
		texto1=new JTextField("Esta de acuerdo con las normas del servicio");
		
		getContentPane().add(texto1);
		
	}

	

	@Override
	public void stateChanged(ChangeEvent e) {
		if(aceptar.isSelected()==true) {
			continuar.setEnabled(true);
		}else {
			continuar.setEnabled(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	

}
