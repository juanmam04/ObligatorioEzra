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

public class MenuSalida extends javax.swing.JFrame {
    
    private Sistema sistema;

    public MenuSalida(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        cargarListas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblComentarios = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEmpleado = new javax.swing.JList<>();
        lblListaEntradas = new javax.swing.JLabel();
        lblListaEmpleado = new javax.swing.JLabel();
        lblHoraSalida = new javax.swing.JLabel();
        txtFechaYHora = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        kstVehiculos = new javax.swing.JList<>();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salidas");
        getContentPane().setLayout(null);

        lblComentarios.setText("Comentarios");
        getContentPane().add(lblComentarios);
        lblComentarios.setBounds(20, 290, 120, 30);

        lstEmpleado.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstEmpleado);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 60, 230, 150);

        lblListaEntradas.setText("Vehiculos actuales");
        getContentPane().add(lblListaEntradas);
        lblListaEntradas.setBounds(20, 20, 170, 30);

        lblListaEmpleado.setText("Empleado que retira");
        getContentPane().add(lblListaEmpleado);
        lblListaEmpleado.setBounds(270, 20, 170, 30);

        lblHoraSalida.setText("Fecha y Hora de salida");
        getContentPane().add(lblHoraSalida);
        lblHoraSalida.setBounds(20, 240, 150, 30);

        txtFechaYHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaYHoraActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaYHora);
        txtFechaYHora.setBounds(170, 240, 340, 27);

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane4.setViewportView(txtComentarios);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(110, 290, 400, 60);

        kstVehiculos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(kstVehiculos);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(20, 60, 230, 150);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(210, 380, 110, 27);

        setBounds(0, 0, 554, 464);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaYHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaYHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaYHoraActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int indexVehiculo = kstVehiculos.getSelectedIndex();
        int indexEmpleado = lstEmpleado.getSelectedIndex();
        String fechaHoraTexto = txtFechaYHora.getText().trim();
        String comentarios = txtComentarios.getText().trim();

        if (indexVehiculo == -1 || indexEmpleado == -1 || fechaHoraTexto.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debés seleccionar un vehículo, un empleado y completar la fecha y hora.");
            return;
        }

        // Separar fecha y hora
        String[] partes = fechaHoraTexto.split(" ");
        if (partes.length != 2) {
            javax.swing.JOptionPane.showMessageDialog(this, "Formato incorrecto. Usá: dd/MM/yyyy HH:mm");
            return;
        }

        String fecha = partes[0];
        String hora = partes[1];

        Vehiculo vehiculo = sistema.getListaVehiculos().get(indexVehiculo);
        Empleado empleado = sistema.getListaEmpleados().get(indexEmpleado);
        Entrada entradaAsociada = null;

        for (Entrada entrada : sistema.obtenerEntradasActivas()) {
            if (entrada.getVehiculo().getMatricula().equalsIgnoreCase(vehiculo.getMatricula())) {
                entradaAsociada = entrada;
                break;
            }
        }

        if (entradaAsociada == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró entrada activa para ese vehículo.");
            return;
        }

        Salida salida = new Salida(entradaAsociada, fecha, hora, empleado, comentarios);
        if (sistema.agregarSalida(salida)) {
            String mensaje = "Salida registrada correctamente.\n";

            Contrato contrato = null;
            for (Contrato cont : sistema.getListaContratos()) {
                if (cont.getVehiculo().getMatricula().equalsIgnoreCase(vehiculo.getMatricula())) {
                    contrato = cont;
                    break;
                }
            }

            if (contrato != null) {
                mensaje += "Contrato activo con valor mensual: " + contrato.getValor();
            } else {
                mensaje += "Este vehículo no tiene contrato activo.";
            }

            javax.swing.JOptionPane.showMessageDialog(this, mensaje);
            dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo registrar la salida. Revisá la hora o la entrada asociada.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cargarListas() {
        DefaultListModel<String> modeloEntradas = new DefaultListModel<>();
        for (Entrada entrada : sistema.obtenerEntradasActivas()) {
            modeloEntradas.addElement(entrada.getVehiculo().getMatricula().toUpperCase());
        }
        kstVehiculos.setModel(modeloEntradas);

        DefaultListModel<String> modeloEmpleados = new DefaultListModel<>();
        for (Empleado empleado : sistema.getListaEmpleados()) {
            modeloEmpleados.addElement(empleado.getNombre().toUpperCase());
        }
        lstEmpleado.setModel(modeloEmpleados);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> kstVehiculos;
    private javax.swing.JLabel lblComentarios;
    private javax.swing.JLabel lblHoraSalida;
    private javax.swing.JLabel lblListaEmpleado;
    private javax.swing.JLabel lblListaEntradas;
    private javax.swing.JList<String> lstEmpleado;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtFechaYHora;
    // End of variables declaration//GEN-END:variables
}
