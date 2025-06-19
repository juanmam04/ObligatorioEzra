//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.Vehiculo;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenuVehiculo extends javax.swing.JFrame {
    
    private Sistema sistema;

    public MenuVehiculo(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        actualizarListaVehiculos();
        
        lstVehiculos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                int index = lstVehiculos.getSelectedIndex();
                if (index != -1) {
                    Vehiculo vehiculoSeleccionado = sistema.getListaVehiculos().get(index);
                    lblInfoVehiculoSeleccionado.setText(vehiculoSeleccionado.toString());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVehiculos = new javax.swing.JList<>();
        txtEstado = new javax.swing.JTextField();
        lblVehiuculos = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnVaciarVehiculo = new javax.swing.JButton();
        btnAgregarVehiculo = new javax.swing.JButton();
        btnEliminarVehiculo = new javax.swing.JButton();
        lblInfoVehiculoSeleccionado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de vehículos");
        getContentPane().setLayout(null);

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMarca);
        txtMarca.setBounds(100, 80, 200, 27);
        getContentPane().add(txtModelo);
        txtModelo.setBounds(100, 120, 200, 27);

        lstVehiculos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstVehiculos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 38, 240, 160);
        getContentPane().add(txtEstado);
        txtEstado.setBounds(100, 160, 200, 27);

        lblVehiuculos.setText("Vehículos");
        getContentPane().add(lblVehiuculos);
        lblVehiuculos.setBounds(410, 10, 60, 17);

        lblMatricula.setText("Matricula");
        getContentPane().add(lblMatricula);
        lblMatricula.setBounds(20, 40, 110, 17);

        lblMarca.setText("Marca");
        getContentPane().add(lblMarca);
        lblMarca.setBounds(20, 80, 110, 17);

        lblCelular.setText("Modelo");
        getContentPane().add(lblCelular);
        lblCelular.setBounds(20, 120, 110, 17);

        lblEstado.setText("Estado");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(20, 160, 110, 17);

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMatricula);
        txtMatricula.setBounds(100, 40, 200, 27);

        btnVaciarVehiculo.setText("Vaciar");
        btnVaciarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarVehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(btnVaciarVehiculo);
        btnVaciarVehiculo.setBounds(120, 260, 90, 27);

        btnAgregarVehiculo.setText("Agregar");
        btnAgregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarVehiculo);
        btnAgregarVehiculo.setBounds(60, 220, 90, 27);

        btnEliminarVehiculo.setText("Eliminar");
        btnEliminarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarVehiculo);
        btnEliminarVehiculo.setBounds(180, 220, 100, 27);

        lblInfoVehiculoSeleccionado.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblInfoVehiculoSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblInfoVehiculoSeleccionado);
        lblInfoVehiculoSeleccionado.setBounds(320, 210, 240, 150);

        setBounds(0, 0, 581, 402);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void btnVaciarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarVehiculoActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
        "¿Está seguro que desea eliminar todos los vehículos?",
        "Confirmar vaciado",
        JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            sistema.getListaVehiculos().clear();
            actualizarListaVehiculos();
            lblInfoVehiculoSeleccionado.setText(""); // limpia el label
            JOptionPane.showMessageDialog(this, "Lista de vehículos vaciada correctamente.");
        }
    }//GEN-LAST:event_btnVaciarVehiculoActionPerformed

    private void btnAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVehiculoActionPerformed
        try {
            String matricula = txtMatricula.getText().trim().toUpperCase();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            String estado = txtEstado.getText().trim();

            Vehiculo nuevo = new Vehiculo(matricula, marca, modelo, estado);

            if (sistema.agregarVehiculo(nuevo)) {
                JOptionPane.showMessageDialog(this, "Vehículo agregado correctamente.");
                actualizarListaVehiculos();
                limpiarCamposVehiculo();
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un vehículo con esa matrícula.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ingresar datos. Verificá que los campos estén completos.");
        }
    }//GEN-LAST:event_btnAgregarVehiculoActionPerformed

    private void btnEliminarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVehiculoActionPerformed
        int indiceSeleccionado = lstVehiculos.getSelectedIndex();
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo para eliminar.");
            return;
        }

        Vehiculo vehiculoSeleccionado = sistema.getListaVehiculos().get(indiceSeleccionado);
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea eliminar el vehículo con matrícula:\n" + vehiculoSeleccionado.getMatricula().toUpperCase() + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            sistema.getListaVehiculos().remove(vehiculoSeleccionado);
            actualizarListaVehiculos();
            lblInfoVehiculoSeleccionado.setText(""); // limpia el label
            JOptionPane.showMessageDialog(this, "Vehículo eliminado correctamente.");
        }
    }//GEN-LAST:event_btnEliminarVehiculoActionPerformed

    private void actualizarListaVehiculos() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Vehiculo vehiculo : sistema.getListaVehiculos()) {
            modelo.addElement(vehiculo.toString());
        }
        lstVehiculos.setModel(modelo);
    }

    
    private void limpiarCamposVehiculo() {
        txtMatricula.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtEstado.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarVehiculo;
    private javax.swing.JButton btnEliminarVehiculo;
    private javax.swing.JButton btnVaciarVehiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblInfoVehiculoSeleccionado;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblVehiuculos;
    private javax.swing.JList<String> lstVehiculos;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
