//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

public class MenuVehiculo extends javax.swing.JFrame {

    public MenuVehiculo() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDireccion = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVehiculos = new javax.swing.JList<>();
        txtEstado = new javax.swing.JTextField();
        lblVehiuculos = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnVaciar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de vehículos");
        getContentPane().setLayout(null);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(93, 58, 170, 22);
        getContentPane().add(txtModelo);
        txtModelo.setBounds(93, 86, 170, 22);

        lstVehiculos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstVehiculos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 30, 125, 146);
        getContentPane().add(txtEstado);
        txtEstado.setBounds(93, 114, 170, 22);

        lblVehiuculos.setText("Vehículos");
        getContentPane().add(lblVehiuculos);
        lblVehiuculos.setBounds(340, 6, 70, 16);

        lblMatricula.setText("Matricula");
        getContentPane().add(lblMatricula);
        lblMatricula.setBounds(24, 33, 57, 16);

        lblMarca.setText("Marca");
        getContentPane().add(lblMarca);
        lblMarca.setBounds(24, 61, 57, 16);

        lblCelular.setText("Modelo");
        getContentPane().add(lblCelular);
        lblCelular.setBounds(24, 89, 51, 16);

        lblEstado.setText("Estado");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(24, 117, 51, 16);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(93, 30, 170, 22);

        btnVaciar.setText("Vaciar");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVaciar);
        btnVaciar.setBounds(20, 270, 90, 23);

        btnAgregar.setText("Agrergar");
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(130, 270, 90, 23);

        btnRegistrar1.setText("Eliminar");
        getContentPane().add(btnRegistrar1);
        btnRegistrar1.setBounds(340, 274, 100, 23);

        setBounds(0, 0, 581, 361);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVaciarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblVehiuculos;
    private javax.swing.JList<String> lstVehiculos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
