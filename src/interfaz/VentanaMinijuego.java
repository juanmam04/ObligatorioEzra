//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import dominio.Minijuego; // Importa tu clase de juego


public class VentanaMinijuego extends JFrame {

    private Minijuego juegoPanel;
    public VentanaMinijuego() {

        super("Ping Pong - Minijuego");
        // Crear una instancia de tu juego
        juegoPanel = new Minijuego();

        // Añadir el panel del juego a la ventana
        // Es crucial que el JPanel tenga un tamaño preferido o un Layout Manager para ocupar espacio.
        add(juegoPanel, BorderLayout.CENTER);

        // Ajustar el tamaño de la ventana al tamaño preferido del panel del juego
        // O puedes establecer un tamaño fijo: setSize(800, 600);
        pack(); // Ajusta el JFrame a los tamaños preferidos de sus componentes.

        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Opcional: Para que se abra maximizada (como vimos antes)
        // setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true); // Hace visible la ventana

        // Asegurarse de que el panel del juego tenga el foco para recibir eventos de teclado
        // Esto es importante si el JFrame tiene otros componentes que podrían robar el foco.
        juegoPanel.requestFocusInWindow();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    public static void main(String[] args) {
    // Ejecutar en el Event Dispatch Thread (EDT)
    // Esto es una buena práctica en Swing
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new VentanaMinijuego();
             }
        });
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

