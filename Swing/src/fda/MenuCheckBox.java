package fda;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//AÑADIMOS  EN LE ULTIMO MENU 3 ITEMS CHECKNB
public class MenuCheckBox extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar mb;
	private JMenu m;
	private JMenuItem m1, m2;
	private JMenu m3;
	private JCheckBox check1,check2;

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
	public MenuCheckBox() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		mb = new JMenuBar();
		setJMenuBar(mb);
		
		m = new JMenu("Opciones");
		m3 = new JMenu("Azul");
		

		mb.add(m);

		m1 = new JMenuItem("Rojo");
		m.add(m1);
		m1.addActionListener(this);

		

		m2 = new JMenuItem("Verde");

		m.add(m2);
		m2.addActionListener(this);
		

		m.add(m3);

		check1 = new JCheckBox("celestese");
		
		check1.addChangeListener(this);
		m3.add(check1);
		
		check2 = new JCheckBox("celestese");
		
		check2.addChangeListener(this);
		m3.add(check2);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Container c = this.getContentPane();
		if (e.getSource() == m1) {
			c.setBackground(Color.RED);
		}
		if (e.getSource() == m2) {
			c.setBackground(Color.GREEN);
		}
		

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

}
