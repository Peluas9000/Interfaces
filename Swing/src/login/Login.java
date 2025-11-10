package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContraseña;
	private List<Formulario> lista=new ArrayList<Formulario>();
	

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel usuario = new JLabel("USUARIO");
		usuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		usuario.setBounds(22, 47, 90, 14);
		contentPane.add(usuario);
		
		JLabel contraseña = new JLabel("CONTRASEÑA");
		contraseña.setFont(new Font("Tahoma", Font.BOLD, 17));
		contraseña.setBounds(19, 98, 129, 21);
		contentPane.add(contraseña);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(158, 44, 224, 27);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContraseña = new JTextField();
		textContraseña.setBounds(158, 92, 224, 27);
		contentPane.add(textContraseña);
		textContraseña.setColumns(10);
		
		//añadri ususarios previos 
		
		//boton y accion del boton
		JButton login = new JButton("INICIAR SESION");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Formulario f:lista) {
					if(textUsuario.getText().equals(f.getUsuario()) && textContraseña.getText().equals(f.getContrasenia())) {
						dispose();
						InicioSesionActivado inicio=new InicioSesionActivado();
						inicio.setVisible(true);
						
					}else {
						String p= JOptionPane.showInputDialog("Contraseña o usuario incorrecto");
						
					}
				}
			}
		});
		login.setFont(new Font("Tahoma", Font.BOLD, 17));
		login.setBounds(22, 176, 185, 38);
		contentPane.add(login);
		
		JButton registrar = new JButton("REGISTRARSE");
		registrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.add(new Formulario(textUsuario.getText(), textContraseña.getText()));
				textContraseña.setText("");
				textUsuario.setText("");
			}
		});
		registrar.setBounds(247, 176, 177, 38);
		contentPane.add(registrar);
		
		
		
	}
}
