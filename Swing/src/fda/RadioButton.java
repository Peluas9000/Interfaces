package fda;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RadioButton extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton jb1,jb2,jb3,jb4;
	private ButtonGroup bg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButton frame = new RadioButton();
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
	public RadioButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		bg=new ButtonGroup();
		jb1=new JRadioButton("640*480");
		jb1.setBounds(10, 20, 100, 30);
		jb1.addChangeListener(this);
		add(jb1);
		bg.add(jb1);
		
		jb2=new JRadioButton("860*600");
		jb2.setBounds(10,70,100,30);
		jb2.addChangeListener(this);
		add(jb2);
		bg.add(jb2);
		
		jb3=new JRadioButton("1024*768");
		jb3.setBounds(10, 120, 100,30);
		jb3.addChangeListener(this);
		add(jb3);
		bg.add(jb3);
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(jb1.isSelected()) {
			setSize(640,480);
		}
		if(jb2.isSelected()) {
			setSize(800,600);
		}
		if(jb3.isSelected()) {
			setSize(1024,768);
		}
	}

}
