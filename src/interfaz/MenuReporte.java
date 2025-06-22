//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.Salida;
import dominio.Empleado;
import dominio.Entrada;
import dominio.Vehiculo;
import dominio.Contrato;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MenuReporte extends javax.swing.JFrame {
    
    private Sistema sistema;


    public MenuReporte(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        
        cbTodos.addActionListener(e -> {
        cbEntradas.setSelected(false);
        cbSalidas.setSelected(false);
        cbServicios.setSelected(false);
        });

        cbEntradas.addActionListener(e -> {
            cbTodos.setSelected(false);
            cbSalidas.setSelected(false);
            cbServicios.setSelected(false);
        });

        cbSalidas.addActionListener(e -> {
            cbTodos.setSelected(false);
            cbEntradas.setSelected(false);
            cbServicios.setSelected(false);
        });

        cbServicios.addActionListener(e -> {
            cbTodos.setSelected(false);
            cbEntradas.setSelected(false);
            cbSalidas.setSelected(false);
        });
        
        cbOrdenCreciente.addActionListener(e -> cbOrdenDecreciente.setSelected(false));
        cbOrdenDecreciente.addActionListener(e -> cbOrdenCreciente.setSelected(false));
        
        cbTodos.setSelected(true);
        cbOrdenCreciente.setSelected(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblVehiculos = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstVehiculos = new javax.swing.JList<>();
        lblVehiculos1 = new javax.swing.JLabel();
        lblVehiculos2 = new javax.swing.JLabel();
        cbOrdenDecreciente = new javax.swing.JCheckBox();
        cbServicios = new javax.swing.JCheckBox();
        cbOrdenCreciente = new javax.swing.JCheckBox();
        cbTodos = new javax.swing.JCheckBox();
        cbEntradas = new javax.swing.JCheckBox();
        cbSalidas = new javax.swing.JCheckBox();
        btnConsultar = new javax.swing.JButton();
        btnConsultarHistorial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblVehiculos3 = new javax.swing.JLabel();
        txtFechaYHoraMovimientos = new javax.swing.JTextField();
        btnConsultarMovimientos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblVehiculos4 = new javax.swing.JLabel();
        lblVehiculos5 = new javax.swing.JLabel();
        lblVehiculos6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstClientesMasContratos = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstServiciosMasUtilizados = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstEmpleadosPocosMovimientos = new javax.swing.JList<>();
        lblVehiculos7 = new javax.swing.JLabel();
        lblVehiculos8 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        lblVehiculos.setText("Orden por fecha/hora");
        jPanel1.add(lblVehiculos);
        lblVehiculos.setBounds(250, 20, 130, 17);

        lstVehiculos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lstVehiculos);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(20, 60, 207, 158);

        lblVehiculos1.setText("Movimientos");
        jPanel1.add(lblVehiculos1);
        lblVehiculos1.setBounds(250, 70, 90, 17);

        lblVehiculos2.setText("Vehículos");
        jPanel1.add(lblVehiculos2);
        lblVehiculos2.setBounds(20, 20, 90, 17);

        cbOrdenDecreciente.setText("Decreciente");
        cbOrdenDecreciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdenDecrecienteActionPerformed(evt);
            }
        });
        jPanel1.add(cbOrdenDecreciente);
        cbOrdenDecreciente.setBounds(510, 20, 110, 21);

        cbServicios.setText("Servicios");
        cbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServiciosActionPerformed(evt);
            }
        });
        jPanel1.add(cbServicios);
        cbServicios.setBounds(350, 160, 90, 21);

        cbOrdenCreciente.setText("Creciente");
        cbOrdenCreciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdenCrecienteActionPerformed(evt);
            }
        });
        jPanel1.add(cbOrdenCreciente);
        cbOrdenCreciente.setBounds(400, 20, 90, 21);

        cbTodos.setText("Todos");
        cbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosActionPerformed(evt);
            }
        });
        jPanel1.add(cbTodos);
        cbTodos.setBounds(350, 70, 90, 21);

        cbEntradas.setText("Entradas");
        cbEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntradasActionPerformed(evt);
            }
        });
        jPanel1.add(cbEntradas);
        cbEntradas.setBounds(350, 100, 90, 21);

        cbSalidas.setText("Salidas");
        cbSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSalidasActionPerformed(evt);
            }
        });
        jPanel1.add(cbSalidas);
        cbSalidas.setBounds(350, 130, 90, 21);

        btnConsultar.setText("Exportar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar);
        btnConsultar.setBounds(420, 210, 110, 27);

        btnConsultarHistorial.setText("Consultar");
        btnConsultarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarHistorial);
        btnConsultarHistorial.setBounds(280, 210, 110, 27);

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha y hora", "Tipo", "Empleado", "Informacion"
            }
        ));
        jScrollPane1.setViewportView(tblHistorial);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(6, 250, 630, 190);

        jTabbedPane1.addTab("Historial", jPanel1);

        jPanel2.setLayout(null);

        lblVehiculos3.setText("Fecha a consultar (dd/MM/aaaa)");
        jPanel2.add(lblVehiculos3);
        lblVehiculos3.setBounds(20, 20, 250, 17);

        txtFechaYHoraMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaYHoraMovimientosActionPerformed(evt);
            }
        });
        jPanel2.add(txtFechaYHoraMovimientos);
        txtFechaYHoraMovimientos.setBounds(220, 20, 270, 27);

        btnConsultarMovimientos.setText("Consultar");
        btnConsultarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarMovimientosActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarMovimientos);
        btnConsultarMovimientos.setBounds(510, 20, 110, 27);

        jTabbedPane1.addTab("Movimientos", jPanel2);

        jPanel3.setLayout(null);

        lblVehiculos4.setText("Clientes con más contratos");
        jPanel3.add(lblVehiculos4);
        lblVehiculos4.setBounds(450, 20, 250, 17);
        jPanel3.add(lblVehiculos5);
        lblVehiculos5.setBounds(170, 250, 250, 120);

        lblVehiculos6.setText("Empleados con menos movimientos");
        jPanel3.add(lblVehiculos6);
        lblVehiculos6.setBounds(210, 20, 250, 17);

        lstClientesMasContratos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(lstClientesMasContratos);

        jPanel3.add(jScrollPane7);
        jScrollPane7.setBounds(440, 60, 180, 158);

        lstServiciosMasUtilizados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(lstServiciosMasUtilizados);

        jPanel3.add(jScrollPane8);
        jScrollPane8.setBounds(30, 60, 170, 158);

        lstEmpleadosPocosMovimientos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(lstEmpleadosPocosMovimientos);

        jPanel3.add(jScrollPane9);
        jScrollPane9.setBounds(230, 60, 180, 158);

        lblVehiculos7.setText("Servicios más utilizados");
        jPanel3.add(lblVehiculos7);
        lblVehiculos7.setBounds(40, 20, 250, 17);

        lblVehiculos8.setText("Estadia más larga:");
        jPanel3.add(lblVehiculos8);
        lblVehiculos8.setBounds(40, 250, 250, 17);

        jTabbedPane1.addTab("Estadísticas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbOrdenDecrecienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdenDecrecienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrdenDecrecienteActionPerformed

    private void cbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbServiciosActionPerformed

    private void cbOrdenCrecienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdenCrecienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrdenCrecienteActionPerformed

    private void cbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTodosActionPerformed

    private void cbEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEntradasActionPerformed

    private void cbSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSalidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSalidasActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnConsultarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarHistorialActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblHistorial.getModel();
        modelo.setRowCount(0); // limpiar tabla

        String matriculaSeleccionada = lstVehiculos.getSelectedValue();
        if (matriculaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccioná un vehículo.");
            return;
        }

        String matricula = matriculaSeleccionada.trim().toUpperCase();
        boolean entradas = cbEntradas.isSelected();
        boolean salidas = cbSalidas.isSelected();
        boolean servicios = cbServicios.isSelected();
        boolean todos = cbTodos.isSelected();
        boolean creciente = cbOrdenCreciente.isSelected();

        ArrayList<String[]> resultados = sistema.generarHistorialDeVehiculo(matricula, entradas, salidas, servicios, todos, creciente);

        for (String[] fila : resultados) {
            modelo.addRow(fila);
        }
    }//GEN-LAST:event_btnConsultarHistorialActionPerformed

    private void txtFechaYHoraMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaYHoraMovimientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaYHoraMovimientosActionPerformed

    private void btnConsultarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarMovimientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarMovimientosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarHistorial;
    private javax.swing.JButton btnConsultarMovimientos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbEntradas;
    private javax.swing.JCheckBox cbOrdenCreciente;
    private javax.swing.JCheckBox cbOrdenDecreciente;
    private javax.swing.JCheckBox cbSalidas;
    private javax.swing.JCheckBox cbServicios;
    private javax.swing.JCheckBox cbTodos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblVehiculos;
    private javax.swing.JLabel lblVehiculos1;
    private javax.swing.JLabel lblVehiculos2;
    private javax.swing.JLabel lblVehiculos3;
    private javax.swing.JLabel lblVehiculos4;
    private javax.swing.JLabel lblVehiculos5;
    private javax.swing.JLabel lblVehiculos6;
    private javax.swing.JLabel lblVehiculos7;
    private javax.swing.JLabel lblVehiculos8;
    private javax.swing.JList<String> lstClientesMasContratos;
    private javax.swing.JList<String> lstEmpleadosPocosMovimientos;
    private javax.swing.JList<String> lstServiciosMasUtilizados;
    private javax.swing.JList<String> lstVehiculos;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextField txtFechaYHoraMovimientos;
    // End of variables declaration//GEN-END:variables
}
