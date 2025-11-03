package tresRaya;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TresEnRaya extends JFrame implements ActionListener {
    
    private JButton[][] botones = new JButton[3][3];
    private boolean turnoAzul = true; // true = Azul, false = Rojo

    public TresEnRaya() {
        setTitle("Tres en Raya");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(3, 3));
        setLocationRelativeTo(null);

        // Crear los 9 botones
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                botones[i][j].setFocusPainted(false);
                botones[i][j].addActionListener(this);
                add(botones[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        // Colorear según el turno
        if (turnoAzul) {
            boton.setBackground(Color.BLUE);
            boton.setEnabled(false);
        } else {
            boton.setBackground(Color.RED);
            boton.setEnabled(false);
        }

        // Comprobar ganador después de cada jugada
        if (hayGanador()) {
            String ganador = turnoAzul ? "Azul" : "Rojo";
            JOptionPane.showMessageDialog(this, 
                "¡El jugador " + ganador + " ha ganado!");
            reiniciarTablero();
            return;
        }

        // Comprobar empate
        if (tableroLleno()) {
            JOptionPane.showMessageDialog(this, 
                "¡Empate! Nadie ganó.");
            reiniciarTablero();
            return;
        }

        // Cambiar turno
        turnoAzul = !turnoAzul;
    }

    private boolean hayGanador() {
        // Comprobar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            // Filas
            if (mismoColor(botones[i][0], botones[i][1], botones[i][2]))
                return true;
            // Columnas
            if (mismoColor(botones[0][i], botones[1][i], botones[2][i]))
                return true;
        }
        // Diagonales
        if (mismoColor(botones[0][0], botones[1][1], botones[2][2])) return true;
        if (mismoColor(botones[0][2], botones[1][1], botones[2][0])) return true;

        return false;
    }

    private boolean mismoColor(JButton b1, JButton b2, JButton b3) {
        Color c1 = b1.getBackground();
        return !c1.equals(Color.WHITE) && 
               c1.equals(b2.getBackground()) && 
               c1.equals(b3.getBackground());
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (botones[i][j].isEnabled()) return false;
            }
        }
        return true;
    }

    private void reiniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].setEnabled(true);
            }
        }
        turnoAzul = true; // Reinicia el turno
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TresEnRaya().setVisible(true));
    }
}
