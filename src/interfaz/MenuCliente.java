//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.Cliente;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenuCliente extends javax.swing.JFrame {
    
    private Sistema sistema;
    
    public MenuCliente(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        actualizarListaClientes();

        lstClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                int index = lstClientes.getSelectedIndex();
                if (index != -1) {
                    Cliente clienteSeleccionado = sistema.getListaClientes().get(index);
                    lblInfoClienteSeleccionado.setText(
                        "<html>Nombre: " + clienteSeleccionado.getNombre().toUpperCase() +
                        "<br>Dirección: " + clienteSeleccionado.getDireccion().toUpperCase() +
                        "<br>Cédula: " + clienteSeleccionado.getCedula() +
                        "<br>Celular: " + clienteSeleccionado.getCelular() +
                        "<br>Año ingreso: " + clienteSeleccionado.getAnoIngreso() + "</html>"
                    );
                }
            }
        });
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
        btnEliminar = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList<>();
        btnAgregar1 = new javax.swing.JButton();
        lblInfoClienteSeleccionado = new javax.swing.JLabel();
        lblCliente1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de clientes");
        getContentPane().setLayout(null);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(140, 50, 230, 27);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(140, 140, 230, 27);
        getContentPane().add(txtCelular);
        txtCelular.setBounds(140, 190, 230, 27);
        getContentPane().add(txtAnoDeIngreso);
        txtAnoDeIngreso.setBounds(140, 230, 230, 27);

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(30, 50, 110, 17);

        lblDireccion.setText("Dirección");
        getContentPane().add(lblDireccion);
        lblDireccion.setBounds(30, 140, 110, 17);

        lblCelular.setText("Celular");
        getContentPane().add(lblCelular);
        lblCelular.setBounds(30, 190, 80, 17);

        lblAnoDeIngreso.setText("Año de ingreso");
        getContentPane().add(lblAnoDeIngreso);
        lblAnoDeIngreso.setBounds(30, 230, 120, 17);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(200, 320, 90, 27);

        lblCedula.setText("Cédula");
        getContentPane().add(lblCedula);
        lblCedula.setBounds(30, 90, 100, 20);

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula);
        txtCedula.setBounds(140, 90, 230, 27);

        lstClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstClientes);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(400, 90, 320, 160);

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar1);
        btnAgregar1.setBounds(90, 320, 90, 27);

        lblInfoClienteSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblInfoClienteSeleccionado);
        lblInfoClienteSeleccionado.setBounds(430, 280, 250, 190);

        lblCliente1.setText("Clientes");
        getContentPane().add(lblCliente1);
        lblCliente1.setBounds(400, 50, 80, 17);

        setBounds(0, 0, 740, 527);
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

        try {
            String nombre = txtNombre.getText().trim();
            String direccion = txtDireccion.getText().trim();
            int celular = Integer.parseInt(txtCelular.getText().trim());
            int cedula = Integer.parseInt(txtCedula.getText().trim());
            int anho = Integer.parseInt(txtAnoDeIngreso.getText().trim());
            
            Cliente nuevo = new Cliente(nombre, direccion, celular, cedula, anho);
            
            if (sistema.agregarCliente(nuevo)) {
                JOptionPane.showMessageDialog(this, "Cliente agregado correctamente.");
                actualizarListaClientes(); // lo hacemos abajo
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un cliente con esa cédula.");
            }
            
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos numéricos. Verificá cédula, celular y año.");
            }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indiceSeleccionado = lstClientes.getSelectedIndex(); // Agarra el cliente seleccionado en la lista
        
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para eliminar.");
            return;
        }
        
        Cliente clienteSeleccionado = sistema.getListaClientes().get(indiceSeleccionado); // Busca el cliente en la lista y lo selecciona
        
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea eliminar al cliente:\n" + clienteSeleccionado.getNombre().toUpperCase() + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            sistema.eliminarClientePorCedula(clienteSeleccionado.getCedula());
            actualizarListaClientes();
            JOptionPane.showMessageDialog(this, "Cliente eliminado: " + clienteSeleccionado.getNombre().toUpperCase());

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    
    private void actualizarListaClientes() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Cliente unCliente : sistema.getListaClientes()) {
            modelo.addElement(unCliente.getNombre().toUpperCase());
        }
        lstClientes.setModel(modelo);
    }
    
    private void limpiarCampos() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
        txtCedula.setText("");
        txtAnoDeIngreso.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuCliente().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnoDeIngreso;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblInfoClienteSeleccionado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList<String> lstClientes;
    private javax.swing.JTextField txtAnoDeIngreso;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
