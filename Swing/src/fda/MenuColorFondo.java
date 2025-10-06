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
	private JMenu m;
	private JMenuItem m1, m2, m3;

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
		m = new JMenu("Opciones");
		mb.add(m);
		m1 = new JMenuItem("Rojo");

		m1.addActionListener(this);

		m.add(m1);

		m2 = new JMenuItem("Verde");

		m2.addActionListener(this);
		m.add(m2);
		m3 = new JMenuItem("Azul");

		m3.addActionListener(this);
		m.add(m3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Container c=this.getContentPane();
		if(e.getSource()==m1) {
			c.setBackground(Color.RED);
		}if(e.getSource()==m2) {
			c.setBackground(Color.GREEN);
		}if(e.getSource()==m3) {
			c.setBackground(Color.BLUE);
		}
		
	}

}
