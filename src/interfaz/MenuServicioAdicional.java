//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.ServicioAdicional;
import dominio.Empleado;
import dominio.Vehiculo;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;

public class MenuServicioAdicional extends javax.swing.JFrame {
    
    private Sistema sistema;

    public MenuServicioAdicional(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        cargarListas();
        inicializarComboServicios();
        
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Vehiculo v : sistema.getListaVehiculos()) {
            ArrayList<ServicioAdicional> servicios = sistema.obtenerServiciosDeVehiculo(v);
            if (servicios.isEmpty()) {
                modelo.addElement(v.getMatricula().toUpperCase() + " (Sin servicios)");
            } else {
                for (ServicioAdicional s : servicios) {
                    modelo.addElement(s.toString());
                }
            }
        }
        lstVehiculo.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmpleado = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVehiculo = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEmpleado = new javax.swing.JList<>();
        lblVehiculo = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        lblFechaYHora = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtFechaYHora = new javax.swing.JTextField();
        cmbServicio = new javax.swing.JComboBox<>();
        txtCombo = new javax.swing.JTextField();
        lblInfoServicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Servicios Adicionales");
        getContentPane().setLayout(null);

        lblEmpleado.setText("Empleados");
        getContentPane().add(lblEmpleado);
        lblEmpleado.setBounds(260, 20, 180, 17);

        lblCosto.setText("Costo");
        getContentPane().add(lblCosto);
        lblCosto.setBounds(260, 230, 60, 17);

        lstVehiculo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstVehiculo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 210, 158);

        lstEmpleado.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstEmpleado);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(260, 50, 210, 158);

        lblVehiculo.setText("Vehículos");
        getContentPane().add(lblVehiculo);
        lblVehiculo.setBounds(20, 20, 210, 17);

        lblServicio.setText("Servicio");
        getContentPane().add(lblServicio);
        lblServicio.setBounds(20, 230, 80, 17);

        lblFechaYHora.setText("Fecha y hora (DD/MM/AAAA HH:MM");
        getContentPane().add(lblFechaYHora);
        lblFechaYHora.setBounds(20, 270, 220, 17);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(40, 320, 100, 27);

        txtFechaYHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaYHoraActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaYHora);
        txtFechaYHora.setBounds(260, 270, 210, 27);

        cmbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServicioActionPerformed(evt);
            }
        });
        getContentPane().add(cmbServicio);
        cmbServicio.setBounds(80, 230, 150, 27);

        txtCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComboActionPerformed(evt);
            }
        });
        getContentPane().add(txtCombo);
        txtCombo.setBounds(301, 230, 170, 27);

        lblInfoServicio.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblInfoServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblInfoServicio);
        lblInfoServicio.setBounds(180, 300, 300, 140);

        setBounds(0, 0, 492, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int indexVehiculo = lstVehiculo.getSelectedIndex();
        int indexEmpleado = lstEmpleado.getSelectedIndex();
        String tipoServicio = (String) cmbServicio.getSelectedItem();
        String fechaHora = txtFechaYHora.getText().trim();
        String costoTexto = txtCombo.getText().trim();

        if (indexVehiculo == -1 || indexEmpleado == -1 || tipoServicio == null ||
            fechaHora.isEmpty() || costoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        String[] partes = fechaHora.split(" ");
        if (partes.length != 2 || 
            !partes[0].matches("\\d{2}/\\d{2}/\\d{4}") || 
            !partes[1].matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Formato inválido. Usá: dd/MM/yyyy HH:mm");
            return;
        }

        String fecha = partes[0];
        String hora = partes[1];

        double costo;
        try {
            costo = Double.parseDouble(costoTexto);
            if (costo < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El costo debe ser un número válido y positivo.");
            return;
        }

        Vehiculo vehiculo = sistema.getListaVehiculos().get(indexVehiculo);
        Empleado empleado = sistema.getListaEmpleados().get(indexEmpleado);

        ServicioAdicional nuevo = new ServicioAdicional(tipoServicio, fecha, hora, vehiculo, empleado, costo);
        if (sistema.agregarServicioAdicional(nuevo)) {
            JOptionPane.showMessageDialog(this, "Servicio registrado correctamente.");
            txtFechaYHora.setText("");
            txtCombo.setText("");
            lstVehiculo.clearSelection();
            lstEmpleado.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el servicio.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cmbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbServicioActionPerformed

    private void txtComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComboActionPerformed

    private void txtFechaYHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaYHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaYHoraActionPerformed

   private void cargarListas() {
        DefaultListModel<String> modeloVehiculos = new DefaultListModel<>();
        for (Vehiculo vehiculo : sistema.getListaVehiculos()) {
            modeloVehiculos.addElement(vehiculo.getMatricula().toUpperCase());
        }
        lstVehiculo.setModel(modeloVehiculos);

        DefaultListModel<String> modeloEmpleados = new DefaultListModel<>();
        for (Empleado empleado : sistema.getListaEmpleados()) {
            modeloEmpleados.addElement(empleado.getNombre().toUpperCase());
        }
        lstEmpleado.setModel(modeloEmpleados);
    }
   
   private void inicializarComboServicios() {
        cmbServicio.removeAllItems();
        cmbServicio.addItem("lavado");
        cmbServicio.addItem("cambio de rueda");
        cmbServicio.addItem("limpieza de tapizado");
        cmbServicio.addItem("cambio de luces");
        cmbServicio.addItem("otro");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbServicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblFechaYHora;
    private javax.swing.JLabel lblInfoServicio;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblVehiculo;
    private javax.swing.JList<String> lstEmpleado;
    private javax.swing.JList<String> lstVehiculo;
    private javax.swing.JTextField txtCombo;
    private javax.swing.JTextField txtFechaYHora;
    // End of variables declaration//GEN-END:variables
}
