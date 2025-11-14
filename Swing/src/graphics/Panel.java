package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import static java.awt.Font.PLAIN;


import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Panel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
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
	public Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 783);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		initPanel();
		initPantalla();
		


	}
	
	
	void initPanel() {
		contentPane=new JPanel();
		getContentPane().add(contentPane);
		contentPane.setPreferredSize(new Dimension(800,600));
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		
		//Degradado Fondo 
		GradientPaint gp2 = new GradientPaint(400, 350, Color.LIGHT_GRAY, 300, 550, Color.BLUE);
			g2d.setPaint(gp2); 
			g2d.fillRect(0, 0, getWidth(), 
				getHeight());
		//Linea
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(30, 70, 770, 70);
		
		//Rectangulo
		g2d.setColor(Color.blue);
		g2d.fillRect(30, 100, 350, 60);
		g2d.setColor(Color.black);
		g2d.drawRect(30, 100, 350, 60);
		
		//Rectangulo redondeado 
		g2d.setColor(Color.CYAN);
		g2d.drawRoundRect(420, 100, 350, 60, 50, 50);
		
		//Arco 
		g2d.setColor(Color.PINK);
		g2d.drawArc(30, 200, 100, 100, 180, -90);
		
		//Circulo 
		g2d.setColor(Color.red);
		g2d.fillOval(240, 200, 150, 100);
		g2d.setColor(Color.red);
		g2d.drawOval(100, 200, 100, 100);
		
		//Ovalo (con relleno y borde )
		
		g2d.setColor(Color.YELLOW);
		g2d.fillOval(240, 200, 150, 100);
		g2d.setColor(Color.black);
		g2d.drawOval(240, 200, 150, 100);
		
		//Pligono (3 lados)
		int[] triangulo_x= {450,510,570};
		int[] triangulo_y= {300,200,300};
		g2d.setColor(Color.orange);
		g2d.drawPolygon(triangulo_x,triangulo_y,3);
		
		//Poligono (5 lados con relleno y borde)
		int[]pentagono_x = {670, 650, 700, 750, 730}; 
		int[]pentagono_y = {300, 245, 200, 245, 300}; 
		g2d.setColor(Color.magenta); 
		g2d.fillPolygon(pentagono_x, pentagono_y, 5); 
		g2d.setColor(Color.black); 
		g2d.drawPolygon(pentagono_x, pentagono_y, 5);
		
		//Texto
		g2d.setColor(Color.black);
		g2d.setFont(new Font("ARIAL",PLAIN,32));
		g2d.drawString("Esto es un texto",30, 400);
		
//		//Imagen
		Toolkit t=Toolkit.getDefaultToolkit();
		Image imagen=t.getImage("C:\\Users\\alumno\\Downloads\\hola.png");
		
		g2d.drawImage(imagen, 30, 450,this);
		
		//Degradado 
		GradientPaint gp= new GradientPaint(400,350, Color.red,770,550,Color.green);
		g2d.setPaint(gp);
		g2d.fillRect(400, 350, 370, 200);
		
		
		
	
		
		
	}
	
	public void initPantalla() {
		setTitle("Ejemplo 19");
		setSize(1111,840);
		setResizable(false);
	}

}
