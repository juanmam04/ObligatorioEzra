package dominio;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

// --- Clase ArchivoLectura para Deserialización de Objetos ---
public class ArchivoLectura {
    private ObjectInputStream in;
    private String nombreArchivo;
    private boolean archivoExiste; // Nuevo flag para saber si el archivo existe

    public ArchivoLectura(String unNombre) {
        this.nombreArchivo = unNombre;
        this.archivoExiste = Files.exists(Paths.get(unNombre)); // Verifica si el archivo existe
        
        if (!this.archivoExiste) {
            System.out.println("El archivo " + unNombre + " no existe. No se pueden recuperar datos.");
            in = null; // No hay stream para leer
            return;
        }

        try {
            FileInputStream fileIn = new FileInputStream(unNombre);
            in = new ObjectInputStream(fileIn);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al preparar el archivo para leer: " + e.getMessage(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al preparar el archivo para leer: " + e.getMessage());
            in = null; // En caso de cualquier otro error de IO, asegurar que in sea null
            this.archivoExiste = false; // Actualizar flag si hay un problema al abrir
        }
    }

    // Método para saber si el archivo existe y se pudo abrir
    public boolean existeArchivoParaLeer() {
        return this.archivoExiste && (this.in != null);
    }

    public Sistema leerSistema() {
        Sistema sistemaLeido = null;
        
        if (!existeArchivoParaLeer()) {
            return null; // No hay archivo o hubo un problema al abrirlo
        }

        // Pedir confirmación antes de recuperar
        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea recuperar los datos guardados? Los datos actuales se perderán.",
                "Confirmar Recuperación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Object objetoLeido = in.readObject();
                if (objetoLeido instanceof Sistema) {
                    sistemaLeido = (Sistema) objetoLeido;
                    JOptionPane.showMessageDialog(null, "Datos recuperados exitosamente desde " + nombreArchivo, "Recuperación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El objeto recuperado no es del tipo Sistema esperado.", "Error de Tipo", JOptionPane.WARNING_MESSAGE);
                    System.err.println("Error: El objeto recuperado no es una instancia de Sistema.");
                }
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error: Clase no encontrada al leer el objeto. " + e.getMessage(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
                System.err.println("Clase no encontrada: " + e.getMessage());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el objeto: " + e.getMessage(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
                System.err.println("Error al leer el objeto: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Recuperación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
        return sistemaLeido;
    }

    public void cerrar() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el archivo de lectura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al cerrar el archivo de lectura: " + e.getMessage());
        }
    }
}