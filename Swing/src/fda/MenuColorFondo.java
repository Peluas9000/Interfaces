package fda;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuColorFondo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar mb;
	private JMenu menu;
	private JMenuItem item1, item2;
	private JMenu menu2;
	private JMenuItem item4,item5;

	
	private JMenu menu3;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuColorFondo frame = new MenuColorFondo();
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
	public MenuColorFondo() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		mb = new JMenuBar();
		setJMenuBar(mb);
		
		menu2=new JMenu("Azul");
		menu = new JMenu("Opciones");
		
		mb.add(menu);
		
		
		
		
		item1 = new JMenuItem("Rojo");
		
		item1.addActionListener(this);

		menu.add(item1);

		item2 = new JMenuItem("Verde");

		item2.addActionListener(this);
		menu.add(item2);
	
		menu.add(menu2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Container c=this.getContentPane();
		if(e.getSource()==item1) {
			c.setBackground(Color.RED);
		}if(e.getSource()==item2) {
			c.setBackground(Color.GREEN);
		}if(e.getSource()==menu2) {
			c.setBackground(Color.BLUE);
		}
		
	}

}
