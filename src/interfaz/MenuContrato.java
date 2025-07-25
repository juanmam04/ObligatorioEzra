//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.Cliente;
import dominio.Contrato;
import dominio.Empleado;
import dominio.Vehiculo;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenuContrato extends javax.swing.JFrame {
    
    private Sistema sistema;

    public MenuContrato(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        actualizarListaContratos();
        actualizarListas();
        aplicarTema();
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
        lblEmpleados.setBounds(480, 20, 90, 17);

        lblClientes.setText("Clientes");
        getContentPane().add(lblClientes);
        lblClientes.setBounds(40, 20, 60, 17);

        lstClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstClientes);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 60, 194, 158);

        lblVehiculos.setText("Vehículos");
        getContentPane().add(lblVehiculos);
        lblVehiculos.setBounds(250, 20, 90, 17);

        lstEmpleados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstEmpleados);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(480, 60, 198, 158);

        lstVehiculos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lstVehiculos);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(250, 60, 207, 158);

        lblNumeroDeContrato.setText("Número de contrato: 1");
        getContentPane().add(lblNumeroDeContrato);
        lblNumeroDeContrato.setBounds(20, 250, 150, 20);

        lblValorMensual.setText("Valor Mensual");
        getContentPane().add(lblValorMensual);
        lblValorMensual.setBounds(230, 250, 110, 17);
        getContentPane().add(txtValorMensual);
        txtValorMensual.setBounds(330, 250, 110, 27);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(380, 470, 100, 27);

        lblContratos.setText("Contratos");
        getContentPane().add(lblContratos);
        lblContratos.setBounds(20, 310, 70, 17);

        lstContratos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstContratos);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(100, 310, 500, 130);

        btnRegistrar1.setText("Registrar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar1);
        btnRegistrar1.setBounds(250, 470, 100, 27);

        setBounds(0, 0, 707, 543);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int index = lstContratos.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un contrato para eliminar.");
            return;
        }

        Contrato contratoSeleccionado = sistema.getListaContratos().get(index);
        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Está seguro que desea eliminar el contrato #" + contratoSeleccionado.getNumero() + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            sistema.eliminarContrato(contratoSeleccionado);
            actualizarListaContratos();
            JOptionPane.showMessageDialog(this, "Contrato eliminado.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        int indexCliente = lstClientes.getSelectedIndex();
        int indexVehiculo = lstVehiculos.getSelectedIndex();
        int indexEmpleado = lstEmpleados.getSelectedIndex();

        if (indexCliente == -1 || indexVehiculo == -1 || indexEmpleado == -1) {
            JOptionPane.showMessageDialog(this, "Debés seleccionar un cliente, un vehículo y un empleado.");
            return;
        }

        String valor = txtValorMensual.getText().trim();
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresá un valor mensual.");
            return;
        }

        try {
            Double.parseDouble(valor); 
            Vehiculo vehiculoSeleccionado = sistema.getListaVehiculos().get(indexVehiculo);
            Empleado empleadoSeleccionado = sistema.getListaEmpleados().get(indexEmpleado);
            Cliente clienteSeleccionado = sistema.getListaClientes().get(indexCliente);
            Contrato nuevo = new Contrato(clienteSeleccionado, vehiculoSeleccionado, empleadoSeleccionado, valor);

            if (sistema.agregarContrato(nuevo)) {
                JOptionPane.showMessageDialog(this, "Contrato registrado correctamente.");
                actualizarListaContratos();
                lblNumeroDeContrato.setText("Número de contrato: " + (nuevo.getNumero() + 1));
                txtValorMensual.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un contrato con ese vehículo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor mensual inválido.");
        }
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void actualizarListaContratos() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Contrato contrato : sistema.getListaContratos()) {
            modelo.addElement(contrato.toString());
        }
        lstContratos.setModel(modelo);
    }
    
    private void actualizarListas() {
        DefaultListModel<String> modeloClientes = new DefaultListModel<>();
        for (Cliente cliente : sistema.getListaClientes()) {
            modeloClientes.addElement(cliente.getNombre().toUpperCase());
        }
        lstClientes.setModel(modeloClientes);

        DefaultListModel<String> modeloVehiculos = new DefaultListModel<>();
        for (Vehiculo vehiculo : sistema.getListaVehiculos()) {
            modeloVehiculos.addElement(vehiculo.getMatricula().toUpperCase());
        }
        lstVehiculos.setModel(modeloVehiculos);

        DefaultListModel<String> modeloEmpleados = new DefaultListModel<>();
        for (Empleado empleado : sistema.getListaEmpleados()) {
            modeloEmpleados.addElement(empleado.getNombre().toUpperCase());
        }
        lstEmpleados.setModel(modeloEmpleados);
    }
    
    private void aplicarTema() {
        if (!sistema.isModoOscuro()) return;

        java.awt.Color fondo = java.awt.Color.DARK_GRAY;
        java.awt.Color texto = java.awt.Color.WHITE;
        java.awt.Color borde = java.awt.Color.WHITE;

        getContentPane().setBackground(fondo);

        // Labels
        javax.swing.JLabel[] labels = {
            lblClientes, lblVehiculos, lblEmpleados, lblNumeroDeContrato,
            lblValorMensual, lblContratos
        };
        for (javax.swing.JLabel lbl : labels) {
            lbl.setForeground(texto);
        }

        // TextField
        txtValorMensual.setBackground(fondo);
        txtValorMensual.setForeground(texto);
        txtValorMensual.setCaretColor(texto);
        txtValorMensual.setBorder(javax.swing.BorderFactory.createLineBorder(borde));

        // Botones
        javax.swing.JButton[] botones = {btnRegistrar1, btnEliminar};
        for (javax.swing.JButton btn : botones) {
            btn.setBackground(fondo);
            btn.setForeground(texto);
            btn.setBorder(javax.swing.BorderFactory.createLineBorder(borde));
        }

        // Listas
        javax.swing.JList[] listas = {lstClientes, lstVehiculos, lstEmpleados, lstContratos};
        for (javax.swing.JList lista : listas) {
            lista.setBackground(fondo);
            lista.setForeground(texto);
            lista.setSelectionBackground(new java.awt.Color(70, 130, 180));
            lista.setSelectionForeground(java.awt.Color.WHITE);
        }
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
