package dominio; // Asegúrate de que este sea el paquete correcto para tus clases de persistencia

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane; // Para mostrar diálogos al usuario

public class ArchivoGrabacion {
    private ObjectOutputStream out;
    private String nombreArchivo;

    /**
     * Constructor para inicializar el stream de escritura de objetos.
     * Intenta preparar el archivo para grabar. Si hay un error, lo notifica al usuario.
     * @param unNombre El nombre del archivo donde se grabarán los datos (ej. "DATOS.ser").
     */
    public ArchivoGrabacion(String unNombre) {
        this.nombreArchivo = unNombre;
        try {
            // FileOutputStream prepara el archivo para escritura de bytes
            FileOutputStream fileOut = new FileOutputStream(unNombre);
            // ObjectOutputStream envuelve a FileOutputStream para escribir objetos Java
            out = new ObjectOutputStream(fileOut);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al preparar el archivo para grabar: " + e.getMessage(), "Error de Grabación", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al preparar el archivo para grabar: " + e.getMessage());
            out = null; // Indica que el stream no se pudo inicializar correctamente
        }
    }

    /**
     * Graba la instancia del objeto Sistema en el archivo.
     * Solicita confirmación al usuario antes de proceder con la grabación.
     * @param sistema La instancia de la clase Sistema que se desea grabar.
     * @return true si la grabación fue exitosa o cancelada por el usuario, false si ocurrió un error.
     */
    public boolean grabarSistema(Sistema sistema) {
        // Pedir confirmación antes de grabar, como se especificó en el requisito
        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea guardar los datos actuales? Se sobrescribirá el archivo DATOS.ser.",
                "Confirmar Grabación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (out != null) { // Asegura que el stream se inicializó correctamente
                    out.writeObject(sistema); // Escribe el objeto Sistema en el archivo
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente en " + nombreArchivo, "Grabación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo inicializar el grabador de archivos. Intente de nuevo.", "Error de Grabación", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al grabar el sistema: " + e.getMessage(), "Error de Grabación", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error al grabar el sistema: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Grabación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return true; // La operación fue "manejada" (cancelada por el usuario)
        }
        return false; // Error durante la grabación
    }

    /**
     * Cierra el stream de escritura del archivo. Es crucial llamarlo después de terminar de grabar.
     */
    public void cerrar() {
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el archivo de grabación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al cerrar el archivo de grabación: " + e.getMessage());
        }
    }
}