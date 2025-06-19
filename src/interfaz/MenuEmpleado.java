//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.Empleado;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenuEmpleado extends javax.swing.JFrame {

    private Sistema sistema;

    public MenuEmpleado(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        actualizarListaEmpleados(); 
        
        lstEmpleados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                int index = lstEmpleados.getSelectedIndex();
                if (index != -1) {
                    Empleado empleadoSeleccionado = sistema.getListaEmpleados().get(index);
                    lblInfoEmpleadoSeleccionado.setText(empleadoSeleccionado.toString());
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDireccion = new javax.swing.JLabel();
        btnVaciar = new javax.swing.JButton();
        lblCelular = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmpleados = new javax.swing.JList<>();
        lblClientes = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        btnEliminarEmp = new javax.swing.JButton();
        txtNumeroEmp = new javax.swing.JTextField();
        lblAnoDeIngreso1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblInfoEmpleadoSeleccionado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Empleados");
        getContentPane().setLayout(null);

        lblDireccion.setText("Dirección");
        getContentPane().add(lblDireccion);
        lblDireccion.setBounds(40, 170, 120, 17);

        btnVaciar.setText("Vaciar");
        btnVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVaciar);
        btnVaciar.setBounds(140, 340, 100, 27);

        lblCelular.setText("Número empleado");
        getContentPane().add(lblCelular);
        lblCelular.setBounds(40, 220, 120, 17);

        lstEmpleados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(380, 70, 220, 170);

        lblClientes.setText("Empleados");
        getContentPane().add(lblClientes);
        lblClientes.setBounds(380, 40, 110, 17);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(170, 70, 180, 27);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(60, 290, 100, 27);

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula);
        txtCedula.setBounds(170, 120, 180, 27);

        btnEliminarEmp.setText("Eliminar");
        btnEliminarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarEmp);
        btnEliminarEmp.setBounds(220, 290, 90, 27);
        getContentPane().add(txtNumeroEmp);
        txtNumeroEmp.setBounds(170, 220, 180, 27);

        lblAnoDeIngreso1.setText("Cédula");
        getContentPane().add(lblAnoDeIngreso1);
        lblAnoDeIngreso1.setBounds(40, 120, 120, 17);

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(40, 70, 120, 17);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(170, 170, 180, 27);

        lblInfoEmpleadoSeleccionado.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblInfoEmpleadoSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblInfoEmpleadoSeleccionado);
        lblInfoEmpleadoSeleccionado.setBounds(370, 260, 240, 150);

        setBounds(0, 0, 630, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            String nombre = txtNombre.getText().trim();
            String direccion = txtDireccion.getText().trim();
            int cedula = Integer.parseInt(txtCedula.getText().trim());
            int numeroEmp = Integer.parseInt(txtNumeroEmp.getText().trim());
            
            Empleado nuevo = new Empleado(nombre, cedula, direccion, numeroEmp);
            
            if (sistema.agregarEmpleado(nuevo)) {
                JOptionPane.showMessageDialog(this, "Empleado agregado correctamente.");
                actualizarListaEmpleados();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un empleado con esa cédula.");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos numéricos. Verificá cédula y número de empleado.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpActionPerformed
        int indiceSeleccionado = lstEmpleados.getSelectedIndex();
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado para eliminar.");
            return;
        }
        Empleado empleadoSeleccionado = sistema.getListaEmpleados().get(indiceSeleccionado);
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea eliminar al empleado:\n" + empleadoSeleccionado.getNombre().toUpperCase() + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            sistema.getListaEmpleados().remove(empleadoSeleccionado);
            actualizarListaEmpleados();
            lblInfoEmpleadoSeleccionado.setText(""); // limpia el label
            JOptionPane.showMessageDialog(this, "Empleado " + empleadoSeleccionado.getNombre().toUpperCase() + " eliminado correctamente.");
        }
    }//GEN-LAST:event_btnEliminarEmpActionPerformed

    private void btnVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea vaciar la lista de empleados?",
            "Confirmar vaciado",
            JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            sistema.getListaEmpleados().clear(); // Borra todos los empleados
            actualizarListaEmpleados();          // Refresca la JList
            lblInfoEmpleadoSeleccionado.setText(""); // Limpia el label
            JOptionPane.showMessageDialog(this, "Lista de empleados vaciada correctamente.");
        }
    }//GEN-LAST:event_btnVaciarActionPerformed

    
    private void actualizarListaEmpleados() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Empleado empleado : sistema.getListaEmpleados()) {
            modelo.addElement(empleado.getNombre().toUpperCase());
        }
        lstEmpleados.setModel(modelo);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCedula.setText("");
        txtNumeroEmp.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminarEmp;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnoDeIngreso1;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblInfoEmpleadoSeleccionado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList<String> lstEmpleados;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroEmp;
    // End of variables declaration//GEN-END:variables
}
