//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

public class MenuInformacionDeLosAutores extends javax.swing.JFrame {

    public MenuInformacionDeLosAutores() {
        initComponents();
        setLocationRelativeTo(null);
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
        lblAutor2.setBounds(310, 370, 180, 40);

        lblAutor1.setText("Ezra Kai Alvez - 297416");
        getContentPane().add(lblAutor1);
        lblAutor1.setBounds(60, 370, 150, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Autor1.jpeg"))); // NOI18N
        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 770, 170, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Autor2.jpeg"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.setMaximumSize(new java.awt.Dimension(407, 336));
        jButton2.setMinimumSize(new java.awt.Dimension(407, 336));
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 20, 210, 330);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Autor1.jpeg"))); // NOI18N
        jButton4.setText("jButton2");
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 20, 220, 330);

        setBounds(0, 0, 539, 485);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuInformacionDeLosAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInformacionDeLosAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInformacionDeLosAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInformacionDeLosAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInformacionDeLosAutores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel lblAutor1;
    private javax.swing.JLabel lblAutor2;
    // End of variables declaration//GEN-END:variables
}
