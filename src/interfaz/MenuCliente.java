//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;
public class MenuCliente extends javax.swing.JFrame {

    /**
     * Creates new form MenuCliente
     */
    public MenuCliente() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtAnoDeIngreso = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblAnoDeIngreso = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCliente = new javax.swing.JList<>();
        btnAgregar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de clientes");
        getContentPane().setLayout(null);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(120, 50, 200, 22);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(120, 140, 200, 22);
        getContentPane().add(txtCelular);
        txtCelular.setBounds(120, 180, 200, 22);
        getContentPane().add(txtAnoDeIngreso);
        txtAnoDeIngreso.setBounds(120, 230, 200, 22);

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(30, 50, 50, 16);

        lblDireccion.setText("Dirección");
        getContentPane().add(lblDireccion);
        lblDireccion.setBounds(30, 140, 50, 16);

        lblCelular.setText("Celular");
        getContentPane().add(lblCelular);
        lblCelular.setBounds(30, 190, 44, 16);

        lblAnoDeIngreso.setText("Año de ingreso");
        getContentPane().add(lblAnoDeIngreso);
        lblAnoDeIngreso.setBounds(30, 230, 90, 16);

        lblEliminar.setText("Eliminar");
        getContentPane().add(lblEliminar);
        lblEliminar.setBounds(350, 300, 90, 23);

        lblCliente.setText("Clientes");
        getContentPane().add(lblCliente);
        lblCliente.setBounds(350, 50, 80, 16);

        lblCedula.setText("Cédula");
        getContentPane().add(lblCedula);
        lblCedula.setBounds(30, 90, 51, 20);

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula);
        txtCedula.setBounds(120, 90, 200, 22);

        lstCliente.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstCliente);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(350, 90, 240, 160);

        btnAgregar1.setText("Agrergar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar1);
        btnAgregar1.setBounds(240, 300, 90, 23);

        setBounds(0, 0, 649, 406);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnoDeIngreso;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JButton lblEliminar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList<String> lstCliente;
    private javax.swing.JTextField txtAnoDeIngreso;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
