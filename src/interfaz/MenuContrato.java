//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

public class MenuContrato extends javax.swing.JFrame {

    public MenuContrato() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        lblEmpleados = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList<>();
        lblVehiculos = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstEmpleados = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstVehiculos = new javax.swing.JList<>();
        lblNumeroDeContrato = new javax.swing.JLabel();
        lblValorMensual = new javax.swing.JLabel();
        txtValorMensual = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        lblContratos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstContratos = new javax.swing.JList<>();
        btnRegistrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de contratos");
        getContentPane().setLayout(null);

        lblEmpleados.setText("Empleados");
        getContentPane().add(lblEmpleados);
        lblEmpleados.setBounds(460, 30, 90, 16);

        lblClientes.setText("Clientes");
        getContentPane().add(lblClientes);
        lblClientes.setBounds(20, 30, 60, 16);

        lstClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstClientes);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 70, 194, 146);

        lblVehiculos.setText("Vehículos");
        getContentPane().add(lblVehiculos);
        lblVehiculos.setBounds(230, 30, 90, 16);

        lstEmpleados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstEmpleados);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(460, 70, 198, 146);

        lstVehiculos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lstVehiculos);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(230, 70, 207, 146);

        lblNumeroDeContrato.setText("Número de contrato: 1");
        getContentPane().add(lblNumeroDeContrato);
        lblNumeroDeContrato.setBounds(20, 250, 150, 20);

        lblValorMensual.setText("Valor Mensual");
        getContentPane().add(lblValorMensual);
        lblValorMensual.setBounds(230, 250, 110, 16);
        getContentPane().add(txtValorMensual);
        txtValorMensual.setBounds(330, 250, 110, 22);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(550, 470, 100, 23);

        lblContratos.setText("Contratos");
        getContentPane().add(lblContratos);
        lblContratos.setBounds(20, 310, 70, 16);

        lstContratos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstContratos);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(100, 310, 429, 130);

        btnRegistrar1.setText("Registrar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar1);
        btnRegistrar1.setBounds(420, 470, 100, 23);

        setBounds(0, 0, 696, 543);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuContrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblContratos;
    private javax.swing.JLabel lblEmpleados;
    private javax.swing.JLabel lblNumeroDeContrato;
    private javax.swing.JLabel lblValorMensual;
    private javax.swing.JLabel lblVehiculos;
    private javax.swing.JList<String> lstClientes;
    private javax.swing.JList<String> lstContratos;
    private javax.swing.JList<String> lstEmpleados;
    private javax.swing.JList<String> lstVehiculos;
    private javax.swing.JTextField txtValorMensual;
    // End of variables declaration//GEN-END:variables
}
