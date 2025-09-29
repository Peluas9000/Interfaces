package fda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class cda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cda frame = new cda();
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
	public cda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(new Color(192, 192, 192));
		contentPane.add(panel, "name_15442385877000");
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.control);
		textField.setBounds(10, 28, 327, 66);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_3 = new JButton("2");
		btnNewButton_1_3.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_3.setBounds(96, 155, 76, 44);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("3");
		btnNewButton_1_4.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_4.setBounds(175, 155, 76, 44);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("5");
		btnNewButton_1_5.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_5.setBounds(96, 204, 76, 44);
		panel.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_6 = new JButton("6");
		btnNewButton_1_6.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_6.setBounds(175, 204, 76, 44);
		panel.add(btnNewButton_1_6);
		
		JButton btnNewButton_1_7 = new JButton("8");
		btnNewButton_1_7.setIcon(null);
		btnNewButton_1_7.setForeground(new Color(0, 0, 0));
		btnNewButton_1_7.setBackground(SystemColor.activeCaption);
		btnNewButton_1_7.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_7.setBounds(96, 253, 76, 44);
		panel.add(btnNewButton_1_7);
		
		JButton btnNewButton_1_8 = new JButton("9");
		btnNewButton_1_8.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1_8.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_8.setBounds(175, 253, 76, 44);
		panel.add(btnNewButton_1_8);
		
		JButton btnNewButton_1_3_1 = new JButton("1");
		btnNewButton_1_3_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1_3_1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_3_1.setBounds(10, 155, 76, 44);
		panel.add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_3_1_1 = new JButton("4");
		btnNewButton_1_3_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1_3_1_1.setBounds(10, 204, 76, 44);
		panel.add(btnNewButton_1_3_1_1);
		
		JButton btnNewButton_1_3_1_2 = new JButton("7");
		btnNewButton_1_3_1_2.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_3_1_2.setBounds(10, 253, 76, 44);
		panel.add(btnNewButton_1_3_1_2);
		
		JButton btnNewButton_1_3_1_3 = new JButton("+");
		btnNewButton_1_3_1_3.setBounds(261, 155, 76, 44);
		panel.add(btnNewButton_1_3_1_3);
		
		JButton btnNewButton_1_3_1_4 = new JButton("X");
		btnNewButton_1_3_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1_4.setBounds(261, 204, 76, 44);
		panel.add(btnNewButton_1_3_1_4);
		
		JButton btnNewButton_1_3_1_5 = new JButton("0");
		btnNewButton_1_3_1_5.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_3_1_5.setBounds(96, 299, 76, 44);
		panel.add(btnNewButton_1_3_1_5);
		
		JButton btnNewButton_1_3_1_6 = new JButton("=");
		btnNewButton_1_3_1_6.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_3_1_6.setBounds(261, 253, 76, 44);
		panel.add(btnNewButton_1_3_1_6);
		
		JButton btnNewButton_1_3_1_7 = new JButton("-");
		btnNewButton_1_3_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1_7.setBounds(261, 105, 76, 44);
		panel.add(btnNewButton_1_3_1_7);
		
		JButton btnNewButton_1_3_1_8 = new JButton("%");
		btnNewButton_1_3_1_8.setBackground(new Color(135, 206, 235));
		btnNewButton_1_3_1_8.setFont(new Font("Tahoma", Font.ITALIC, 25));
		btnNewButton_1_3_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1_8.setBounds(96, 105, 76, 44);
		panel.add(btnNewButton_1_3_1_8);
		
		JButton btnNewButton_1_3_1_9 = new JButton("CE");
		btnNewButton_1_3_1_9.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		btnNewButton_1_3_1_9.setBounds(10, 105, 76, 44);
		panel.add(btnNewButton_1_3_1_9);
		
		JButton btnNewButton_1_3_1_10 = new JButton("");
		btnNewButton_1_3_1_10.setBackground(new Color(169, 169, 169));
		btnNewButton_1_3_1_10.setIcon(new ImageIcon("C:\\Users\\alumno\\Pictures\\Screenshots\\Captura de pantalla 2025-09-29 133202.png"));
		btnNewButton_1_3_1_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1_3_1_10.setBounds(175, 105, 76, 44);
		panel.add(btnNewButton_1_3_1_10);

	}
}
