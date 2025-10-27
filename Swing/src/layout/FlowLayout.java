package layout;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class FlowLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayout frame = new FlowLayout();
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
	public FlowLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JFrame v=new JFrame();
		
		v.getContentPane().setLayout(new java.awt.FlowLayout());
		
		JButton j = new JButton("boton");
		JTextField textField=new JTextField(10);
		JCheckBox checkBox =new JCheckBox("checkbox");
		JLabel etiqueta =new JLabel("Etiqueta");
		
		v.getContentPane().add(j);
		v.getContentPane().add(textField);
		v.getContentPane().add(checkBox);
		v.getContentPane().add(etiqueta);
		
		
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		v.pack();
		v.setVisible(true);
		
		
		
		
	}

}
