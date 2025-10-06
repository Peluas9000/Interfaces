package fda;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Desplegable extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desplegable frame = new Desplegable();
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
	JComboBox<String> combo1;
	public Desplegable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		combo1=new JComboBox<String>();
		combo1.setBounds(10, 10, 80, 20);
		add(combo1);
		combo1.addItem("ROJO");	
		combo1.addItem("VERDE");	
		combo1.addItem("AZUL");	
		combo1.addItem("AMARILLO");	
		combo1.addItemListener(this);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==combo1) {
			String elegido=(String)combo1.getSelectedItem();
			setTitle(elegido);
			
		switch(elegido) {
			case "ROJO":
		        getContentPane().setBackground(Color.RED);
				break;
			case "VERDE":
			getContentPane().setBackground(Color.GREEN);
	
				break;
			case "AZUL":
				getContentPane().setBackground(Color.BLUE);

				break;
			
			case "AMARILLO":
				getContentPane().setBackground(Color.YELLOW);

					break;
			}
		
			
			
		}
	}

}
