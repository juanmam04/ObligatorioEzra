//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package interfaz;

import dominio.Sistema;
import dominio.Empleado;
import dominio.Entrada;
import dominio.Vehiculo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenuEntrada extends javax.swing.JFrame {

    private Sistema sistema;

    public MenuEntrada(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        actualizarListas();
        aplicarTema();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVehiculo = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        lblFechaYHora = new javax.swing.JLabel();
        lblNotas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmpleado = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstVehiculo = new javax.swing.JList<>();
        txtNotas = new javax.swing.JTextField();
        txtFechaYHora = new javax.swing.JTextField();
        lblRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de vehículos al Parking");
        getContentPane().setLayout(null);

        lblVehiculo.setText("Vehículo");
        getContentPane().add(lblVehiculo);
        lblVehiculo.setBounds(26, 14, 140, 17);

        lblEmpleado.setText("Empleado que recibe");
        getContentPane().add(lblEmpleado);
        lblEmpleado.setBounds(318, 14, 170, 17);

        lblFechaYHora.setText("Fecha y hora (dd/mm/aaaa HH:mm)");
        getContentPane().add(lblFechaYHora);
        lblFechaYHora.setBounds(26, 244, 210, 17);

        lblNotas.setText("Notas");
        getContentPane().add(lblNotas);
        lblNotas.setBounds(26, 295, 50, 17);

        lstEmpleado.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstEmpleado);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(318, 42, 282, 158);

        lstVehiculo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstVehiculo);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(26, 42, 194, 158);
        getContentPane().add(txtNotas);
        txtNotas.setBounds(75, 292, 550, 27);
        getContentPane().add(txtFechaYHora);
        txtFechaYHora.setBounds(240, 240, 383, 27);

        lblRegistrar.setText("Registrar");
        lblRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(lblRegistrar);
        lblRegistrar.setBounds(264, 350, 90, 27);

        setBounds(0, 0, 652, 453);
    }// </editor-fold>//GEN-END:initComponents

    
    private ArrayList<Vehiculo> vehiculosVisibles = new ArrayList<>();
    private ArrayList<Empleado> empleadosVisibles = new ArrayList<>();



    
    private void lblRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblRegistrarActionPerformed
        int indexVehiculo = lstVehiculo.getSelectedIndex();
        int indexEmpleado = lstEmpleado.getSelectedIndex();

        if (indexVehiculo == -1 || indexEmpleado == -1) {
            JOptionPane.showMessageDialog(this, "Debés seleccionar un vehículo y un empleado.");
            return;
        }

        String fechaHoraTexto = txtFechaYHora.getText().trim();
        String[] partes = fechaHoraTexto.split(" ");
        if (partes.length != 2) {
            JOptionPane.showMessageDialog(this, "Formato de fecha y hora incorrecto. Usá: dd/MM/yyyy HH:mm");
            return;
        }

        String fecha = partes[0];
        String hora = partes[1];

        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}") || !hora.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Formato inválido. Fecha: dd/MM/yyyy | Hora: HH:mm");
            return;
        }

        Vehiculo vehiculoSeleccionado = vehiculosVisibles.get(indexVehiculo);
        Empleado empleadoSeleccionado = empleadosVisibles.get(indexEmpleado);
        String nota = txtNotas.getText().trim();

        Entrada nueva = new Entrada(vehiculoSeleccionado, fecha, hora, empleadoSeleccionado, nota);

        if (sistema.agregarEntrada(nueva)) {
            JOptionPane.showMessageDialog(this, "Entrada registrada correctamente.");
            txtFechaYHora.setText("");
            txtNotas.setText("");
            lstVehiculo.clearSelection();
            lstEmpleado.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Ese vehículo ya tiene una entrada activa.");
        }
    }//GEN-LAST:event_lblRegistrarActionPerformed

    private void actualizarListas() {
        // Vehículos
        DefaultListModel<String> modeloVehiculos = new DefaultListModel<>();
        vehiculosVisibles.clear(); 

        for (Vehiculo v : sistema.getListaVehiculos()) {
            modeloVehiculos.addElement(v.getMatricula().toUpperCase());
            vehiculosVisibles.add(v); 
        }
        lstVehiculo.setModel(modeloVehiculos);

        // Empleados (usa lista auxiliar)
        DefaultListModel<String> modeloEmpleados = new DefaultListModel<>();
        empleadosVisibles.clear();

        for (Empleado e : sistema.getListaEmpleados()) {
            modeloEmpleados.addElement(e.getNombre().toUpperCase());
            empleadosVisibles.add(e);
        }
        lstEmpleado.setModel(modeloEmpleados);
    }

    
    private void aplicarTema() {
        if (!sistema.isModoOscuro()) return;

        java.awt.Color fondo = java.awt.Color.DARK_GRAY;
        java.awt.Color texto = java.awt.Color.WHITE;
        java.awt.Color borde = java.awt.Color.WHITE;

        getContentPane().setBackground(fondo);

        // Labels
        javax.swing.JLabel[] labels = {
            lblVehiculo, lblEmpleado, lblFechaYHora, lblNotas
        };
        for (javax.swing.JLabel lbl : labels) {
            lbl.setForeground(texto);
        }

        // TextFields
        javax.swing.JTextField[] campos = {txtFechaYHora, txtNotas};
        for (javax.swing.JTextField campo : campos) {
            campo.setBackground(fondo);
            campo.setForeground(texto);
            campo.setCaretColor(texto);
            campo.setBorder(javax.swing.BorderFactory.createLineBorder(borde));
        }

        // Botón
        lblRegistrar.setBackground(fondo);
        lblRegistrar.setForeground(texto);
        lblRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(borde));

        // Listas
        javax.swing.JList[] listas = {lstVehiculo, lstEmpleado};
        for (javax.swing.JList lista : listas) {
            lista.setBackground(fondo);
            lista.setForeground(texto);
            lista.setSelectionBackground(new java.awt.Color(70, 130, 180));
            lista.setSelectionForeground(java.awt.Color.WHITE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblFechaYHora;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JButton lblRegistrar;
    private javax.swing.JLabel lblVehiculo;
    private javax.swing.JList<String> lstEmpleado;
    private javax.swing.JList<String> lstVehiculo;
    private javax.swing.JTextField txtFechaYHora;
    private javax.swing.JTextField txtNotas;
    // End of variables declaration//GEN-END:variables
}
