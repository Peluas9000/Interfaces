package fda;

import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Checkbox extends JFrame implements ChangeListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox check1,check2,check3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkbox frame = new Checkbox();
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
	public Checkbox() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		check1=new JCheckBox("Ingles");
		check2=new JCheckBox("Frances");
		check3=new JCheckBox("Aleman");
		
		
		add(check1);
		check1.addChangeListener(this);
		add(check2);
		check2.addChangeListener(this);
		add(check3);
		check3.addChangeListener(this);
		
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(check1.isSelected()==true) {
		setTitle(check1.getText());
		}if(check2.isSelected()==true) {
			setTitle(check2.getText());
		}if(check3.isSelected()==true) {
				setTitle(check3.getText());
		}
	}

}
