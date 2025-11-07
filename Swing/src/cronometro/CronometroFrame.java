	package cronometro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


	/**
	 * Create the frame.
	 */
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class CronometroFrame extends JFrame {
	    private JLabel lblTiempo;
	    private JButton btnPausar, btnReiniciar;
	    private Timer timer;
	    private int segundos = 0;
	    private boolean corriendo = false;

	    public CronometroFrame() {
	        setTitle("Cronómetro");
	        setLayout(null);
	        setSize(300, 200);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        lblTiempo = new JLabel("00:00", SwingConstants.CENTER);
	        lblTiempo.setFont(new Font("Consolas", Font.BOLD, 36));
	        lblTiempo.setBounds(50, 30, 200, 50);
	        add(lblTiempo);

	        btnPausar = new JButton("Iniciar");
	        btnPausar.setBounds(40, 100, 90, 30);
	        add(btnPausar);

	        btnReiniciar = new JButton("Reiniciar");
	        btnReiniciar.setBounds(160, 100, 90, 30);
	        add(btnReiniciar);

	        // ⏱️ TIMER cada segundo
	        timer = new Timer(1000, e -> {
	            segundos++;
	            lblTiempo.setText(formatearTiempo(segundos));
	        });

	        // 🔘 Acción botón Iniciar / Pausar
	        btnPausar.addActionListener(e -> {
	            if (!corriendo) {
	                timer.start();
	                corriendo = true;
	                btnPausar.setText("Pausar");
	            } else {
	                timer.stop();
	                corriendo = false;
	                btnPausar.setText("Reanudar");
	            }
	        });

	        // 🔄 Acción botón Reiniciar
	        btnReiniciar.addActionListener(e -> {
	            timer.stop();
	            segundos = 0;
	            lblTiempo.setText("00:00");
	            corriendo = false;
	            btnPausar.setText("Iniciar");
	        });
	    }

	    // Método auxiliar para mostrar minutos:segundos
	    private String formatearTiempo(int totalSegundos) {
	        int minutos = totalSegundos / 60;
	        int segundos = totalSegundos % 60;
	        return String.format("%02d:%02d", minutos, segundos);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new CronometroFrame().setVisible(true));
	    }
	}


