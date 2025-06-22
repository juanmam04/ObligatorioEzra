//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351
package interfaz;

import dominio.ArchivoGrabacion;
import dominio.ArchivoLectura;
import dominio.Sistema;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane; // Para los diálogos

public class MenuParking extends javax.swing.JFrame {

    private Sistema sistema; // Tu instancia de Sistema
    private static final String NOMBRE_ARCHIVO_DATOS = "DATOS.ser"; // Nombre del archivo para guardar/cargar

    public MenuParking() {
        // Al iniciar la aplicación, intenta cargar los datos.
        // Si no existen o hay un error, se inicializa un nuevo Sistema.
        sistema = cargarSistemaAlInicio();
        if (sistema == null) {
            // Si la carga falla o el archivo no existe, inicializa un nuevo sistema vacío
            sistema = new Sistema();
            JOptionPane.showMessageDialog(this, "No se encontraron datos previos o hubo un error al cargar. Se inició un nuevo sistema.", "Inicio de Aplicación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Datos cargados exitosamente al inicio de la aplicación.", "Inicio de Aplicación", JOptionPane.INFORMATION_MESSAGE);
        }

        initComponents();
        aplicarTema();
    }

    private Sistema cargarSistemaAlInicio() {
        ArchivoLectura lector = new ArchivoLectura(NOMBRE_ARCHIVO_DATOS);
        Sistema sistemaCargado = null;

        // Verifica si el archivo existe para leer. Si no, no intenta leer el objeto.
        if (lector.existeArchivoParaLeer()) {
            // No pedimos confirmación aquí, esto es al inicio automático.
            // El método leerSistema ya maneja la confirmación si se le llama directamente.
            // Para la carga inicial, podrías querer un comportamiento diferente.
            // Si quieres que el inicio sea silencioso y solo cargue si puede,
            // puedes modificar leerSistema para que no pida confirmación o crear
            // otro método en ArchivoLectura para carga sin confirmación.
            // Por simplicidad, asumiré que en este punto no quieres confirmar al usuario.
            // Vamos a adaptar el método leerSistema para que la primera carga
            // del constructor no pida confirmación.

            try {
                // Leer el objeto sin pedir confirmación en el constructor de MenuParking
                // Para esto, modificaremos ligeramente ArchivoLectura.
                // Opción 1: Crear un método public Object leerObjetoSinConfirmacion() en ArchivoLectura
                // Opción 2: Manejar la confirmación aquí en MenuParking para la carga inicial

                // Por ahora, para la carga INICIAL, vamos a leer sin el diálogo de confirmación
                // que está dentro de ArchivoLectura. Puedes refactorizar ArchivoLectura
                // para tener un método específico para "carga silenciosa" si lo prefieres.
                // Aquí simularemos esa "carga silenciosa" accediendo directamente al stream.
                FileInputStream fileIn = new FileInputStream(NOMBRE_ARCHIVO_DATOS);
                ObjectInputStream objIn = new ObjectInputStream(fileIn);
                Object objetoLeido = objIn.readObject();
                if (objetoLeido instanceof Sistema) {
                    sistemaCargado = (Sistema) objetoLeido;
                } else {
                    System.err.println("El archivo DATOS.ser no contiene un objeto Sistema válido.");
                }
                objIn.close();
                fileIn.close();
            } catch (FileNotFoundException e) {
                // Esto ya lo maneja el constructor de ArchivoLectura con existeArchivoParaLeer
                System.out.println("Archivo DATOS.ser no encontrado al inicio.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar datos al inicio: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Error al cargar datos guardados: " + e.getMessage() + ". Se iniciará con datos nuevos.", "Error de Carga", JOptionPane.ERROR_MESSAGE);
            }
        }
        lector.cerrar(); // Asegurarse de cerrar el lector incluso si no se usó el método leerSistema completo
        return sistemaCargado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClaroOscuro = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menGestion = new javax.swing.JMenu();
        itmGestionDeClientes = new javax.swing.JMenuItem();
        itmGestionDeVehiculos = new javax.swing.JMenuItem();
        itmGestionDeEmpleados = new javax.swing.JMenuItem();
        itmGestionDeContratos = new javax.swing.JMenuItem();
        menMovimientos = new javax.swing.JMenu();
        itmEntradas = new javax.swing.JMenuItem();
        itmSalidas = new javax.swing.JMenuItem();
        itmServiciosAdicionales = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        itmReportes = new javax.swing.JMenuItem();
        itmRecuperacionDeDatos = new javax.swing.JMenuItem();
        itmGrabacionDeDatos = new javax.swing.JMenuItem();
        itmMinijuego = new javax.swing.JMenuItem();
        itmInformacionDeAutores = new javax.swing.JMenuItem();
        helpMenu1 = new javax.swing.JMenu();
        itmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Parking");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        btnClaroOscuro.setText("Claro/Oscuro");
        btnClaroOscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaroOscuroActionPerformed(evt);
            }
        });
        getContentPane().add(btnClaroOscuro);
        btnClaroOscuro.setBounds(151, 126, 110, 27);

        menGestion.setMnemonic('f');
        menGestion.setText("Gestión");

        itmGestionDeClientes.setMnemonic('o');
        itmGestionDeClientes.setText("Gestión de Clientes ");
        itmGestionDeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmGestionDeClientesActionPerformed(evt);
            }
        });
        menGestion.add(itmGestionDeClientes);

        itmGestionDeVehiculos.setMnemonic('s');
        itmGestionDeVehiculos.setText("Gestión de Vehículos");
        itmGestionDeVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmGestionDeVehiculosActionPerformed(evt);
            }
        });
        menGestion.add(itmGestionDeVehiculos);

        itmGestionDeEmpleados.setMnemonic('a');
        itmGestionDeEmpleados.setText("Gestión de Empleados");
        itmGestionDeEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmGestionDeEmpleadosActionPerformed(evt);
            }
        });
        menGestion.add(itmGestionDeEmpleados);

        itmGestionDeContratos.setMnemonic('x');
        itmGestionDeContratos.setText("Gestión de Contratos");
        itmGestionDeContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmGestionDeContratosActionPerformed(evt);
            }
        });
        menGestion.add(itmGestionDeContratos);

        menuBar.add(menGestion);
        menGestion.getAccessibleContext().setAccessibleName("");

        menMovimientos.setMnemonic('e');
        menMovimientos.setText("Movimientos");

        itmEntradas.setMnemonic('t');
        itmEntradas.setText("Entradas");
        itmEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEntradasActionPerformed(evt);
            }
        });
        menMovimientos.add(itmEntradas);

        itmSalidas.setMnemonic('y');
        itmSalidas.setText("Salidas");
        itmSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmSalidasActionPerformed(evt);
            }
        });
        menMovimientos.add(itmSalidas);

        itmServiciosAdicionales.setMnemonic('p');
        itmServiciosAdicionales.setText("Servicios Adicionales");
        itmServiciosAdicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmServiciosAdicionalesActionPerformed(evt);
            }
        });
        menMovimientos.add(itmServiciosAdicionales);

        menuBar.add(menMovimientos);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Varios");

        itmReportes.setMnemonic('c');
        itmReportes.setText("Reportes");
        itmReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmReportesActionPerformed(evt);
            }
        });
        helpMenu.add(itmReportes);

        itmRecuperacionDeDatos.setMnemonic('a');
        itmRecuperacionDeDatos.setText("Recuperación de datos");
        itmRecuperacionDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRecuperacionDeDatosActionPerformed(evt);
            }
        });
        helpMenu.add(itmRecuperacionDeDatos);

        itmGrabacionDeDatos.setMnemonic('a');
        itmGrabacionDeDatos.setText("Grabación de datos");
        itmGrabacionDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmGrabacionDeDatosActionPerformed(evt);
            }
        });
        helpMenu.add(itmGrabacionDeDatos);

        itmMinijuego.setMnemonic('a');
        itmMinijuego.setText("Minijuego");
        itmMinijuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMinijuegoActionPerformed(evt);
            }
        });
        helpMenu.add(itmMinijuego);

        itmInformacionDeAutores.setMnemonic('a');
        itmInformacionDeAutores.setText("Información de Autores");
        itmInformacionDeAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmInformacionDeAutoresActionPerformed(evt);
            }
        });
        helpMenu.add(itmInformacionDeAutores);

        menuBar.add(helpMenu);

        helpMenu1.setMnemonic('h');
        helpMenu1.setText("Terminar");
        helpMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenu1ActionPerformed(evt);
            }
        });

        itmSalir.setMnemonic('a');
        itmSalir.setText("Salir");
        itmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmSalirActionPerformed(evt);
            }
        });
        helpMenu1.add(itmSalir);

        menuBar.add(helpMenu1);

        setJMenuBar(menuBar);

        setBounds(0, 0, 416, 311);
    }// </editor-fold>//GEN-END:initComponents

    private void itmGestionDeContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmGestionDeContratosActionPerformed
        MenuContrato menu = new MenuContrato(sistema);
        menu.setVisible(true);
    }//GEN-LAST:event_itmGestionDeContratosActionPerformed

    private void itmGestionDeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmGestionDeClientesActionPerformed
        MenuCliente menu = new MenuCliente(sistema);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }//GEN-LAST:event_itmGestionDeClientesActionPerformed

    private void itmGestionDeVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmGestionDeVehiculosActionPerformed
        MenuVehiculo menu = new MenuVehiculo(sistema);
        menu.setVisible(true);
    }//GEN-LAST:event_itmGestionDeVehiculosActionPerformed

    private void itmGrabacionDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmGrabacionDeDatosActionPerformed
        grabarDatos();
    }//GEN-LAST:event_itmGrabacionDeDatosActionPerformed

    private void btnClaroOscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaroOscuroActionPerformed
        sistema.cambiarModo();
        aplicarTema(); // Aplica el nuevo tema en esta ventana
    }//GEN-LAST:event_btnClaroOscuroActionPerformed

    private void helpMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpMenu1ActionPerformed

    private void itmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itmSalirActionPerformed

    private void itmGestionDeEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmGestionDeEmpleadosActionPerformed
        MenuEmpleado menu = new MenuEmpleado(sistema);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }//GEN-LAST:event_itmGestionDeEmpleadosActionPerformed

    private void itmEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEntradasActionPerformed
        MenuEntrada menu = new MenuEntrada(sistema);
        menu.setVisible(true);
    }//GEN-LAST:event_itmEntradasActionPerformed

    private void itmSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSalidasActionPerformed
        MenuSalida menu = new MenuSalida(sistema);
        menu.setVisible(true);
    }//GEN-LAST:event_itmSalidasActionPerformed

    private void itmServiciosAdicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmServiciosAdicionalesActionPerformed
        MenuServicioAdicional menu = new MenuServicioAdicional(sistema);
        menu.setVisible(true);
    }//GEN-LAST:event_itmServiciosAdicionalesActionPerformed

    private void itmReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmReportesActionPerformed
        MenuReporte menu = new MenuReporte(sistema);
        menu.setVisible(true);
    }//GEN-LAST:event_itmReportesActionPerformed

    private void itmRecuperacionDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRecuperacionDeDatosActionPerformed
        recuperarDatos();
    }//GEN-LAST:event_itmRecuperacionDeDatosActionPerformed

    private void itmMinijuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMinijuegoActionPerformed
        VentanaMinijuego menu = new VentanaMinijuego();
        menu.setVisible(true);
    }//GEN-LAST:event_itmMinijuegoActionPerformed

    private void itmInformacionDeAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmInformacionDeAutoresActionPerformed
        MenuInformacionDeLosAutores menu = new MenuInformacionDeLosAutores();
        menu.setVisible(true);

    }//GEN-LAST:event_itmInformacionDeAutoresActionPerformed

    private void aplicarTema() {

        Color fondo = sistema.isModoOscuro() ? Color.DARK_GRAY : Color.WHITE;
        Color texto = sistema.isModoOscuro() ? Color.WHITE : Color.BLACK;

        getContentPane().setBackground(fondo);
        btnClaroOscuro.setBackground(fondo);
        btnClaroOscuro.setForeground(texto);
        btnClaroOscuro.setBorder(javax.swing.BorderFactory.createLineBorder(texto));

        // Estilizar barra de menú
        menuBar.setBackground(fondo);
        // NO cambiar el foreground globalmente para evitar afectar los JMenu si no se puede
        // menuBar.setForeground(texto); ← ESTA LÍNEA SE COMENTA

        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            javax.swing.JMenu menu = menuBar.getMenu(i);
            if (menu != null) {
                menu.setOpaque(false); // ← Evitamos forzar fondo
                // NO cambiamos fondo ni texto para JMenu (títulos de menú)
                // menu.setBackground(fondo); ← NO
                // menu.setForeground(texto); ← NO

                for (int j = 0; j < menu.getItemCount(); j++) {
                    javax.swing.JMenuItem item = menu.getItem(j);
                    if (item != null) {
                        item.setOpaque(true);
                        item.setBackground(fondo);
                        item.setForeground(texto);
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuParking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaroOscuro;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu helpMenu1;
    private javax.swing.JMenuItem itmEntradas;
    private javax.swing.JMenuItem itmGestionDeClientes;
    private javax.swing.JMenuItem itmGestionDeContratos;
    private javax.swing.JMenuItem itmGestionDeEmpleados;
    private javax.swing.JMenuItem itmGestionDeVehiculos;
    private javax.swing.JMenuItem itmGrabacionDeDatos;
    private javax.swing.JMenuItem itmInformacionDeAutores;
    private javax.swing.JMenuItem itmMinijuego;
    private javax.swing.JMenuItem itmRecuperacionDeDatos;
    private javax.swing.JMenuItem itmReportes;
    private javax.swing.JMenuItem itmSalidas;
    private javax.swing.JMenuItem itmSalir;
    private javax.swing.JMenuItem itmServiciosAdicionales;
    private javax.swing.JMenu menGestion;
    private javax.swing.JMenu menMovimientos;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    public void setBounds(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void grabarDatos() {
        ArchivoGrabacion grabador = new ArchivoGrabacion(NOMBRE_ARCHIVO_DATOS);
        grabador.grabarSistema(sistema); // Grabar la instancia actual de tu sistema
        grabador.cerrar(); // Siempre cerrar el archivo
    }

    private void recuperarDatos() {
        ArchivoLectura lector = new ArchivoLectura(NOMBRE_ARCHIVO_DATOS);
        Sistema sistemaRecuperado = lector.leerSistema();
        lector.cerrar(); // Siempre cerrar el archivo

        if (sistemaRecuperado != null) {
            // Si se recuperó un sistema, lo sustituimos por el actual
            this.sistema = sistemaRecuperado;
            // Opcional: si las ventanas secundarias ya están abiertas,
            // puede que necesites actualizarles la referencia al nuevo sistema.
            // Esto es un punto a considerar en aplicaciones más complejas.
            // Por ahora, asumimos que se abrirán nuevas ventanas o que
            // los cambios se reflejarán al cerrar y reabrir las subventanas.
        } else {
            // Si no se recuperó (porque no existía el archivo o el usuario canceló),
            // el sistema actual permanece como está, o se reinicia si lo deseas.
            // Según tu requisito: "Si no hay datos previos, se reinicia el sistema."
            // La lógica de reiniciar si no hay datos ya está en el constructor de MenuParking
            // y aquí si el usuario cancela, no se hace nada, lo cual es correcto.
            JOptionPane.showMessageDialog(this, "No se recuperaron datos. El sistema actual permanece inalterado.", "Recuperación Cancelada/Fallida", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
