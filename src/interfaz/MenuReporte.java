//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

// Muchisima ayuda de ChatGPT pero siempre entendiendo lo que estamos agregando

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
import java.awt.Font;
import java.awt.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MenuReporte extends javax.swing.JFrame {
    
    private Sistema sistema;

    public MenuReporte(Sistema unSistema) {
        this.sistema = unSistema;
        initComponents();
        setLocationRelativeTo(null);
        pack();
        aplicarTema();
        setVisible(true);       
        cbTodosMovimientosHistorial.addActionListener(e -> {
        cbEntradasHistorial.setSelected(false);
        cbSalidasHistorial.setSelected(false);
        cbServiciosHistorial.setSelected(false);
        });

        cbEntradasHistorial.addActionListener(e -> {
            cbTodosMovimientosHistorial.setSelected(false);
            cbSalidasHistorial.setSelected(false);
            cbServiciosHistorial.setSelected(false);
        });

        cbSalidasHistorial.addActionListener(e -> {
            cbTodosMovimientosHistorial.setSelected(false);
            cbEntradasHistorial.setSelected(false);
            cbServiciosHistorial.setSelected(false);
        });

        cbServiciosHistorial.addActionListener(e -> {
            cbTodosMovimientosHistorial.setSelected(false);
            cbEntradasHistorial.setSelected(false);
            cbSalidasHistorial.setSelected(false);
        });
        
        cbOrdenCrecienteHistorial.addActionListener(e -> cbOrdenDecrecienteHistorial.setSelected(false));
        cbOrdenDecrecienteHistorial.addActionListener(e -> cbOrdenCrecienteHistorial.setSelected(false));
        
        cbTodosMovimientosHistorial.setSelected(true);
        cbOrdenCrecienteHistorial.setSelected(true);
        
        DefaultListModel<String> modeloVehiculos = new DefaultListModel<>();
        for (Vehiculo v : sistema.getListaVehiculos()) {
            modeloVehiculos.addElement(v.getMatricula().toUpperCase());
        }
        lstVehiculosHistorial.setModel(modeloVehiculos);
        
        DefaultListModel<String> modeloServicios = new DefaultListModel<>();
        for (String s : sistema.obtenerServiciosMasUtilizados()) {
            modeloServicios.addElement(s);
        }
        lstServiciosMasUtilizados.setModel(modeloServicios);
        
        lblVehiculos5.setText(sistema.getEstadiaMasLarga());
        
        DefaultListModel<String> modeloEmpleados = new DefaultListModel<>();
        for (String s : sistema.obtenerEmpleadosConMenosMovimientos()) {
            modeloEmpleados.addElement(s);
        }
        
        lstEmpleadosPocosMovimientos.setModel(modeloEmpleados);
        
        DefaultListModel<String> modeloClientes = new DefaultListModel<>();
        for (String s : sistema.obtenerClientesConMasContratos()) {
            modeloClientes.addElement(s);
        }
        
        lstClientesMasContratos.setModel(modeloClientes);

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
        lstVehiculosHistorial = new javax.swing.JList<>();
        lblVehiculos1 = new javax.swing.JLabel();
        lblVehiculos2 = new javax.swing.JLabel();
        cbOrdenDecrecienteHistorial = new javax.swing.JCheckBox();
        cbServiciosHistorial = new javax.swing.JCheckBox();
        cbOrdenCrecienteHistorial = new javax.swing.JCheckBox();
        cbTodosMovimientosHistorial = new javax.swing.JCheckBox();
        cbEntradasHistorial = new javax.swing.JCheckBox();
        cbSalidasHistorial = new javax.swing.JCheckBox();
        btnExportarHistorial = new javax.swing.JButton();
        btnConsultarHistorial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblVehiculos3 = new javax.swing.JLabel();
        txtFechaYHoraMovimientos = new javax.swing.JTextField();
        btnConsultarMovimientos = new javax.swing.JButton();
        panelMovimientosPorFranja = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");

        jPanel1.setLayout(null);

        lblVehiculos.setText("Orden por fecha/hora");
        jPanel1.add(lblVehiculos);
        lblVehiculos.setBounds(250, 20, 130, 17);

        lstVehiculosHistorial.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lstVehiculosHistorial);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(20, 60, 207, 158);

        lblVehiculos1.setText("Movimientos");
        jPanel1.add(lblVehiculos1);
        lblVehiculos1.setBounds(250, 70, 90, 17);

        lblVehiculos2.setText("Vehículos");
        jPanel1.add(lblVehiculos2);
        lblVehiculos2.setBounds(20, 20, 90, 17);

        cbOrdenDecrecienteHistorial.setText("Decreciente");
        cbOrdenDecrecienteHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdenDecrecienteHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(cbOrdenDecrecienteHistorial);
        cbOrdenDecrecienteHistorial.setBounds(510, 20, 110, 21);

        cbServiciosHistorial.setText("Servicios");
        cbServiciosHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServiciosHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(cbServiciosHistorial);
        cbServiciosHistorial.setBounds(350, 160, 90, 21);

        cbOrdenCrecienteHistorial.setText("Creciente");
        cbOrdenCrecienteHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdenCrecienteHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(cbOrdenCrecienteHistorial);
        cbOrdenCrecienteHistorial.setBounds(400, 20, 90, 21);

        cbTodosMovimientosHistorial.setText("Todos");
        cbTodosMovimientosHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosMovimientosHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(cbTodosMovimientosHistorial);
        cbTodosMovimientosHistorial.setBounds(350, 70, 90, 21);

        cbEntradasHistorial.setText("Entradas");
        cbEntradasHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntradasHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(cbEntradasHistorial);
        cbEntradasHistorial.setBounds(350, 100, 90, 21);

        cbSalidasHistorial.setText("Salidas");
        cbSalidasHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSalidasHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(cbSalidasHistorial);
        cbSalidasHistorial.setBounds(350, 130, 90, 21);

        btnExportarHistorial.setText("Exportar");
        btnExportarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportarHistorial);
        btnExportarHistorial.setBounds(420, 210, 110, 27);

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
        lblVehiculos3.setBounds(10, 20, 200, 17);

        txtFechaYHoraMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaYHoraMovimientosActionPerformed(evt);
            }
        });
        jPanel2.add(txtFechaYHoraMovimientos);
        txtFechaYHoraMovimientos.setBounds(220, 20, 280, 27);

        btnConsultarMovimientos.setText("Consultar");
        btnConsultarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarMovimientosActionPerformed(evt);
            }
        });
        jPanel2.add(btnConsultarMovimientos);
        btnConsultarMovimientos.setBounds(520, 20, 110, 27);

        javax.swing.GroupLayout panelMovimientosPorFranjaLayout = new javax.swing.GroupLayout(panelMovimientosPorFranja);
        panelMovimientosPorFranja.setLayout(panelMovimientosPorFranjaLayout);
        panelMovimientosPorFranjaLayout.setHorizontalGroup(
            panelMovimientosPorFranjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        panelMovimientosPorFranjaLayout.setVerticalGroup(
            panelMovimientosPorFranjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel2.add(panelMovimientosPorFranja);
        panelMovimientosPorFranja.setBounds(30, 80, 580, 340);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbOrdenDecrecienteHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdenDecrecienteHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrdenDecrecienteHistorialActionPerformed

    private void cbServiciosHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServiciosHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbServiciosHistorialActionPerformed

    private void cbOrdenCrecienteHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdenCrecienteHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrdenCrecienteHistorialActionPerformed

    private void cbTodosMovimientosHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosMovimientosHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTodosMovimientosHistorialActionPerformed

    private void cbEntradasHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntradasHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEntradasHistorialActionPerformed

    private void cbSalidasHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSalidasHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSalidasHistorialActionPerformed

    private void btnExportarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarHistorialActionPerformed
        // TODO add your handling code here:
        String matricula = lstVehiculosHistorial.getSelectedValue();
        if (matricula == null) {
            JOptionPane.showMessageDialog(this, "Seleccioná un vehículo.");
            return;
        }

        boolean entradas = cbEntradasHistorial.isSelected();
        boolean salidas = cbSalidasHistorial.isSelected();
        boolean servicios = cbServiciosHistorial.isSelected();
        boolean todos = cbTodosMovimientosHistorial.isSelected();
        boolean creciente = cbOrdenCrecienteHistorial.isSelected();

        ArrayList<String[]> resultados = sistema.generarHistorialDeVehiculo(
            matricula.trim().toUpperCase(), entradas, salidas, servicios, todos, creciente);

        try (java.io.PrintWriter writer = new java.io.PrintWriter(matricula + ".txt")) {
            for (String[] fila : resultados) {
                String linea = String.join(" | ", fila); // separador visible
                writer.println(linea);
            }
            JOptionPane.showMessageDialog(this, "Historial exportado como " + matricula + ".txt");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al exportar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnExportarHistorialActionPerformed

    private void btnConsultarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarHistorialActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblHistorial.getModel();
        modelo.setRowCount(0); // limpiar tabla

        String matriculaSeleccionada = lstVehiculosHistorial.getSelectedValue();
        if (matriculaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccioná un vehículo.");
            return;
        }

        String matricula = matriculaSeleccionada.trim().toUpperCase();
        boolean entradas = cbEntradasHistorial.isSelected();
        boolean salidas = cbSalidasHistorial.isSelected();
        boolean servicios = cbServiciosHistorial.isSelected();
        boolean todos = cbTodosMovimientosHistorial.isSelected();
        boolean creciente = cbOrdenCrecienteHistorial.isSelected();

        ArrayList<String[]> resultados = sistema.generarHistorialDeVehiculo(matricula, entradas, salidas, servicios, todos, creciente);

        for (String[] fila : resultados) {
            modelo.addRow(fila);
        }
    }//GEN-LAST:event_btnConsultarHistorialActionPerformed

    private void txtFechaYHoraMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaYHoraMovimientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaYHoraMovimientosActionPerformed

    private void btnConsultarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarMovimientosActionPerformed
        panelMovimientosPorFranja.removeAll();
        panelMovimientosPorFranja.setLayout(new java.awt.GridLayout(5, 4, 10, 10)); // 4 columnas + 1 título vertical

        String fechaStr = txtFechaYHoraMovimientos.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaStr, formatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Usá dd/MM/yyyy");
            return;
        }

        java.util.List<LocalDate> dias = java.util.Arrays.asList(
            fecha.minusDays(1),
            fecha,
            fecha.plusDays(1)
        );

        String[] franjasHorarias = {
            "00:00 - 05:59",
            "06:00 - 11:59",
            "12:00 - 17:59",
            "18:00 - 23:59"
        };

        // Primera celda vacía (esquina superior izquierda)
        panelMovimientosPorFranja.add(new JLabel(""));

        // Encabezados de fechas
        for (LocalDate dia : dias) {
            JLabel lblFecha = new JLabel(dia.format(formatter), SwingConstants.CENTER);
            lblFecha.setFont(new Font("Arial", Font.BOLD, 14));
            panelMovimientosPorFranja.add(lblFecha);
        }

        // Filas de franjas
        for (int f = 0; f < 4; f++) {
            // Título de franja horaria
            JLabel lblFranja = new JLabel(franjasHorarias[f], SwingConstants.CENTER);
            lblFranja.setFont(new Font("Arial", Font.BOLD, 13));
            panelMovimientosPorFranja.add(lblFranja);

            int horaInicio = f * 6;
            int horaFin = horaInicio + 6;

            for (LocalDate dia : dias) {
                ArrayList<String> movimientos = sistema.getMovimientosEnFranja(dia, horaInicio, horaFin);
                int cantidad = movimientos.size();

                JButton btn = new JButton(String.valueOf(cantidad));
                btn.setFont(new Font("Arial", Font.BOLD, 16));
                btn.setForeground(Color.BLACK);
                btn.setFocusPainted(false);
                btn.setOpaque(true);
                btn.setBorderPainted(false);

                if (cantidad <= 2) {
                    btn.setBackground(Color.GREEN);
                } else if (cantidad <= 5) {
                    btn.setBackground(Color.YELLOW);
                } else {
                    btn.setBackground(Color.RED);
                }

                btn.addActionListener(e -> {
                    String detalle = String.join("\n", movimientos);
                    JOptionPane.showMessageDialog(this, detalle.isEmpty() ? "Sin movimientos." : detalle);
                });

                panelMovimientosPorFranja.add(btn);
            }
        }

        panelMovimientosPorFranja.revalidate();
        panelMovimientosPorFranja.repaint();
    }//GEN-LAST:event_btnConsultarMovimientosActionPerformed

    private void aplicarTema() {
        if (!sistema.isModoOscuro()) return;

        Color fondo = Color.DARK_GRAY;
        Color texto = Color.WHITE;
        Color borde = Color.WHITE;

        getContentPane().setBackground(fondo);
        jPanel1.setBackground(fondo);
        jPanel2.setBackground(fondo);
        jPanel3.setBackground(fondo);
        panelMovimientosPorFranja.setBackground(fondo);

        // Labels
        JLabel[] labels = {
            lblVehiculos, lblVehiculos1, lblVehiculos2, lblVehiculos3, lblVehiculos4,
            lblVehiculos5, lblVehiculos6, lblVehiculos7, lblVehiculos8
        };
        for (JLabel lbl : labels) {
            lbl.setForeground(texto);
        }

        // Checkboxes
        javax.swing.JCheckBox[] checks = {
            cbEntradasHistorial, cbOrdenCrecienteHistorial, cbOrdenDecrecienteHistorial,
            cbSalidasHistorial, cbServiciosHistorial, cbTodosMovimientosHistorial
        };
        for (javax.swing.JCheckBox cb : checks) {
            cb.setBackground(fondo);
            cb.setForeground(texto);
        }

        // TextField
        txtFechaYHoraMovimientos.setBackground(fondo);
        txtFechaYHoraMovimientos.setForeground(texto);
        txtFechaYHoraMovimientos.setCaretColor(texto);
        txtFechaYHoraMovimientos.setBorder(javax.swing.BorderFactory.createLineBorder(borde));

        // Botones
        JButton[] botones = {btnConsultarHistorial, btnExportarHistorial, btnConsultarMovimientos};
        for (JButton b : botones) {
            b.setBackground(fondo);
            b.setForeground(texto);
            b.setBorder(javax.swing.BorderFactory.createLineBorder(borde));
        }

        // Listas
        javax.swing.JList[] listas = {
            lstVehiculosHistorial, lstClientesMasContratos,
            lstServiciosMasUtilizados, lstEmpleadosPocosMovimientos
        };
        for (javax.swing.JList lista : listas) {
            lista.setBackground(fondo);
            lista.setForeground(texto);
            lista.setSelectionBackground(new Color(70, 130, 180));
            lista.setSelectionForeground(Color.WHITE);
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarHistorial;
    private javax.swing.JButton btnConsultarMovimientos;
    private javax.swing.JButton btnExportarHistorial;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbEntradasHistorial;
    private javax.swing.JCheckBox cbOrdenCrecienteHistorial;
    private javax.swing.JCheckBox cbOrdenDecrecienteHistorial;
    private javax.swing.JCheckBox cbSalidasHistorial;
    private javax.swing.JCheckBox cbServiciosHistorial;
    private javax.swing.JCheckBox cbTodosMovimientosHistorial;
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
    private javax.swing.JList<String> lstVehiculosHistorial;
    private javax.swing.JPanel panelMovimientosPorFranja;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextField txtFechaYHoraMovimientos;
    // End of variables declaration//GEN-END:variables
}
