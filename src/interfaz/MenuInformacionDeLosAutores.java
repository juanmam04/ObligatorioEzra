//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MenuInformacionDeLosAutores extends javax.swing.JFrame {

    private Sistema sistema;

    public MenuInformacionDeLosAutores(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        aplicarTema();
        redimensionarImagenes();
    }
    
    private void aplicarTema() {
        if (!sistema.isModoOscuro()) return;

        Color fondo = Color.DARK_GRAY;
        Color texto = Color.WHITE;
        Color borde = Color.WHITE;

        getContentPane().setBackground(fondo);

        lblAutor1.setForeground(texto);
        lblAutor2.setForeground(texto);

        javax.swing.JButton[] botones = { jButton1, jButton2, jButton4 };
        for (javax.swing.JButton btn : botones) {
            btn.setBackground(fondo);
            btn.setForeground(texto);
            btn.setBorder(BorderFactory.createLineBorder(borde));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAutor2 = new javax.swing.JLabel();
        lblAutor1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información de autores");
        getContentPane().setLayout(null);

        lblAutor2.setText("Juan Manuel Martinez - 315351");
        getContentPane().add(lblAutor2);
        lblAutor2.setBounds(300, 370, 240, 40);

        lblAutor1.setText("Ezra Kai Alvez - 297416");
        getContentPane().add(lblAutor1);
        lblAutor1.setBounds(60, 370, 210, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Autor1.jpeg"))); // NOI18N
        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 770, 170, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Autor2.jpeg"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.setMaximumSize(new java.awt.Dimension(407, 336));
        jButton2.setMinimumSize(new java.awt.Dimension(407, 336));
        getContentPane().add(jButton2);
        jButton2.setBounds(280, 20, 210, 330);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Autor1.jpeg"))); // NOI18N
        jButton4.setText("jButton2");
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 20, 220, 330);

        setBounds(0, 0, 539, 485);
    }// </editor-fold>//GEN-END:initComponents

    
    private void redimensionarImagenes() {
        // Imagen de jButton2 (Juan Manuel)
        ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/images/Autor2.jpeg"));
        Image imagenRedim2 = originalIcon2.getImage().getScaledInstance(230, 330, Image.SCALE_SMOOTH);
        jButton2.setIcon(new ImageIcon(imagenRedim2));

        // Imagen de jButton4 (Ezra)
        ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/images/Autor1.jpeg"));
        Image imagenRedim1 = originalIcon1.getImage().getScaledInstance(220, 330, Image.SCALE_SMOOTH);
        jButton4.setIcon(new ImageIcon(imagenRedim1));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel lblAutor1;
    private javax.swing.JLabel lblAutor2;
    // End of variables declaration//GEN-END:variables
}
