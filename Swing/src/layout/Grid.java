package layout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Grid extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	final int COLUMNAS=3;
	final int FILAS=3;
	private JButton boton[] =new JButton [9];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grid frame = new Grid();
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
	//Matriz , crea una tabla con las dimensiones segun las numeras de columnas dichas 
	public Grid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
	
		

		for(int i=0;i<9;i++) {
			boton[i]=new JButton();
			
		}
		contentPane.setLayout(new GridLayout(FILAS,COLUMNAS));
		
		for(int i=0;i<9;i++) {
			getContentPane().add(boton[i]);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int cont=0;
		JButton botpulsado=(JButton) e.getSource();
		
		
		for(int i=0;i<3;i++) {
			
			for(int j=0;j<3;j++) {
				if(cont%2==0) {
					
				}
			}
		}
		
	}

}
