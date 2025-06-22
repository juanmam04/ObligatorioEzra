//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.Cliente;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.Color;


public class MenuCliente extends javax.swing.JFrame {
    
    private Sistema sistema;
    
    public MenuCliente(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        actualizarListaClientes();
        aplicarTema();

        lstClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                int index = lstClientes.getSelectedIndex();
                if (index != -1) {
                    Cliente clienteSeleccionado = sistema.getListaClientes().get(index);
                    lblInfoClienteSeleccionado.setText(clienteSeleccionado.toString());
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
        txtNombre.setBounds(140, 60, 230, 27);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(140, 140, 230, 27);
        getContentPane().add(txtCelular);
        txtCelular.setBounds(140, 180, 230, 27);
        getContentPane().add(txtAnoDeIngreso);
        txtAnoDeIngreso.setBounds(140, 220, 230, 27);

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(30, 60, 110, 17);

        lblDireccion.setText("Dirección");
        getContentPane().add(lblDireccion);
        lblDireccion.setBounds(30, 140, 110, 17);

        lblCelular.setText("Celular");
        getContentPane().add(lblCelular);
        lblCelular.setBounds(30, 180, 80, 17);

        lblAnoDeIngreso.setText("Año de ingreso");
        getContentPane().add(lblAnoDeIngreso);
        lblAnoDeIngreso.setBounds(30, 220, 120, 17);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(200, 290, 90, 27);

        lblCedula.setText("Cédula");
        getContentPane().add(lblCedula);
        lblCedula.setBounds(30, 100, 100, 20);

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula);
        txtCedula.setBounds(140, 100, 230, 27);

        lstClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstClientes);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 70, 210, 160);

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar1);
        btnAgregar1.setBounds(90, 290, 90, 27);

        lblInfoClienteSeleccionado.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblInfoClienteSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblInfoClienteSeleccionado);
        lblInfoClienteSeleccionado.setBounds(390, 250, 250, 190);

        lblCliente1.setText("Clientes");
        getContentPane().add(lblCliente1);
        lblCliente1.setBounds(410, 30, 80, 17);

        setBounds(0, 0, 657, 489);
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
                actualizarListaClientes();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un cliente con esa cédula.");
            }
            
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos numéricos. Verificá cédula, celular y año.");
            }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indiceSeleccionado = lstClientes.getSelectedIndex(); 
        
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
    
    private void aplicarTema() {
        
        if (!sistema.isModoOscuro()) return; // Si el modo oscuro no está activo, no tocar nada

        Color fondo = sistema.isModoOscuro() ? Color.DARK_GRAY : Color.WHITE;
        Color texto = sistema.isModoOscuro() ? Color.WHITE : Color.BLACK;
        Color borde = Color.WHITE;

        getContentPane().setBackground(fondo);

        // Labels
        lblNombre.setForeground(texto);
        lblDireccion.setForeground(texto);
        lblCelular.setForeground(texto);
        lblAnoDeIngreso.setForeground(texto);
        lblCedula.setForeground(texto);
        lblCliente1.setForeground(texto);
        lblInfoClienteSeleccionado.setForeground(texto);

        // TextFields
        javax.swing.border.Border border = javax.swing.BorderFactory.createLineBorder(borde);
        javax.swing.JTextField[] campos = {txtNombre, txtDireccion, txtCelular, txtCedula, txtAnoDeIngreso};
        for (javax.swing.JTextField campo : campos) {
            campo.setBackground(fondo);
            campo.setForeground(texto);
            campo.setCaretColor(texto);
            campo.setBorder(border);
        }

        // Botones
        javax.swing.JButton[] botones = {btnAgregar1, btnEliminar};
        for (javax.swing.JButton boton : botones) {
            boton.setBackground(fondo);
            boton.setForeground(texto);
            boton.setBorder(border);
        }

        // Lista
        lstClientes.setBackground(fondo);
        lstClientes.setForeground(texto);
        lstClientes.setSelectionBackground(new Color(70, 130, 180)); // celeste oscuro
        lstClientes.setSelectionForeground(Color.WHITE);
    }


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
