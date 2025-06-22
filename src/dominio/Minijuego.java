//Ezra Kai Alvez 297416 & Juan Manuel Martinez 315351

package dominio;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.RenderingHints;
import java.awt.Rectangle; // Importar Rectangle
import java.awt.Font;     // Importar Font
import java.awt.Dimension; // Importar Dimension

public class Minijuego extends JPanel implements Runnable, KeyListener {

    private static final int ANCHO_JUEGO = 800; // Ancho del área de juego
    private static final int ALTO_JUEGO = 600;  // Alto del área de juego
    private static final int VELOCIDAD_JUEGO = 1000 / 60; // ~60 FPS (milisegundos por frame)

    private Pelota pelota;
    private Paleta paletaJugador;
    private Paleta paletaCPU;
    private int puntuacionJugador;
    private int puntuacionCPU;

    private boolean juegoEnCurso;
    private Thread juegoThread;

    public Minijuego() {
        setBackground(Color.BLACK); // Fondo negro para el juego
        setPreferredSize(new Dimension(ANCHO_JUEGO, ALTO_JUEGO)); // Establece el tamaño preferido del panel
        setFocusable(true); // Hace que el panel pueda recibir eventos de teclado
        addKeyListener(this); // Agrega el KeyListener a este panel

        iniciarJuego();
    }

    private void iniciarJuego() {
        // Asegúrate de que las posiciones iniciales estén dentro de los límites
        pelota = new Pelota(ANCHO_JUEGO / 2 - 10, ALTO_JUEGO / 2 - 10, 20, 20); // Posición y tamaño de la pelota
        paletaJugador = new Paleta(20, ALTO_JUEGO / 2 - 50, 20, 100); // Paleta izquierda
        paletaCPU = new Paleta(ANCHO_JUEGO - 40, ALTO_JUEGO / 2 - 50, 20, 100); // Paleta derecha
        puntuacionJugador = 0;
        puntuacionCPU = 0;
        juegoEnCurso = true;

        if (juegoThread == null || !juegoThread.isAlive()) {
            juegoThread = new Thread(this); // Crea un nuevo hilo para el juego
            juegoThread.start(); // Inicia el hilo
        }
    }

    private void actualizarEstadoJuego() {
        if (!juegoEnCurso) return;

        pelota.mover();
        paletaJugador.mover();

        // Lógica simple para la paleta de la CPU (IA muy básica)
        // La CPU sigue el centro de la pelota
        int centroPelotaY = pelota.getY() + pelota.getAlto() / 2;
        int centroPaletaCPUY = paletaCPU.getY() + paletaCPU.getAlto() / 2;
        int velocidadCPU = 3; // Ajusta esta velocidad para la dificultad

        if (centroPelotaY < centroPaletaCPUY) {
            paletaCPU.moverArriba(velocidadCPU);
        } else if (centroPelotaY > centroPaletaCPUY) {
            paletaCPU.moverAbajo(velocidadCPU);
        }

        // Colisiones con bordes superiores/inferiores del área de juego
        if (pelota.getY() <= 0) {
            pelota.setY(0); // Ajusta la posición para que no se salga
            pelota.cambiarDireccionY();
        } else if (pelota.getY() >= ALTO_JUEGO - pelota.getAlto()) {
            pelota.setY(ALTO_JUEGO - pelota.getAlto()); // Ajusta la posición
            pelota.cambiarDireccionY();
        }

        // Colisiones con paletas
        // Si la pelota choca con la paleta del jugador
        if (pelota.getBounds().intersects(paletaJugador.getBounds())) {
            pelota.cambiarDireccionX();
            // Mueve la pelota un poco para evitar que se pegue
            pelota.setX(paletaJugador.getX() + paletaJugador.getAncho());
            // Opcional: Aumentar la velocidad de la pelota ligeramente al golpear
            pelota.incrementarVelocidad();
        }
        // Si la pelota choca con la paleta de la CPU
        if (pelota.getBounds().intersects(paletaCPU.getBounds())) {
            pelota.cambiarDireccionX();
            // Mueve la pelota un poco para evitar que se pegue
            pelota.setX(paletaCPU.getX() - pelota.getAncho());
            // Opcional: Aumentar la velocidad de la pelota ligeramente al golpear
            pelota.incrementarVelocidad();
        }

        // Puntos y reset
        if (pelota.getX() <= 0) { // La pelota se fue por el lado izquierdo (CPU anota)
            puntuacionCPU++;
            resetearPelota();
        } else if (pelota.getX() >= ANCHO_JUEGO - pelota.getAncho()) { // La pelota se fue por el lado derecho (Jugador anota)
            puntuacionJugador++;
            resetearPelota();
        }
    }

    private void resetearPelota() {
        pelota.setX(ANCHO_JUEGO / 2 - pelota.getAncho() / 2); // Centra la pelota horizontalmente
        pelota.setY(ALTO_JUEGO / 2 - pelota.getAlto() / 2);   // Centra la pelota verticalmente

        // Dirección aleatoria al resetear
        int inicialVelX = (Math.random() < 0.5 ? 1 : -1) * 3; // Velocidad inicial base 3
        int inicialVelY = (Math.random() < 0.5 ? 1 : -1) * 3;
        pelota.setVelocidadX(inicialVelX);
        pelota.setVelocidadY(inicialVelY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Dibuja el fondo
        Graphics2D g2d = (Graphics2D) g;

        // Suavizado de gráficos (opcional, para mejor apariencia)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Dibujar elementos del juego
        pelota.dibujar(g2d);
        paletaJugador.dibujar(g2d);
        paletaCPU.dibujar(g2d);

        // Dibujar línea central (opcional)
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawLine(ANCHO_JUEGO / 2, 0, ANCHO_JUEGO / 2, ALTO_JUEGO);

        // Dibujar puntuación
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Consolas", Font.BOLD, 40)); // Fuente más apropiada para marcador
        // Sombra para el texto (opcional, mejora la visibilidad)
        g2d.setColor(Color.GRAY);
        g2d.drawString(String.valueOf(puntuacionJugador), ANCHO_JUEGO / 4 + 2, 50 + 2);
        g2d.drawString(String.valueOf(puntuacionCPU), 3 * ANCHO_JUEGO / 4 - 20 + 2, 50 + 2);
        g2d.setColor(Color.WHITE);
        g2d.drawString(String.valueOf(puntuacionJugador), ANCHO_JUEGO / 4, 50);
        g2d.drawString(String.valueOf(puntuacionCPU), 3 * ANCHO_JUEGO / 4 - 20, 50);
    }

    @Override
    public void run() {
        while (juegoEnCurso) {
            actualizarEstadoJuego();
            repaint(); // Vuelve a dibujar el panel
            try {
                Thread.sleep(VELOCIDAD_JUEGO); // Controla la velocidad del bucle del juego
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura el estado de interrupción
                juegoEnCurso = false;
                System.err.println("Juego interrumpido: " + e.getMessage());
            }
        }
    }

    // --- Implementación de KeyListener para control de paleta del jugador ---
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            paletaJugador.setDireccion(-5); // Velocidad hacia arriba
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            paletaJugador.setDireccion(5); // Velocidad hacia abajo
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            paletaJugador.setDireccion(0); // Detener paleta al soltar la tecla
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se usa en este juego simple
    }

    // --- Clases internas para Pelota y Paleta ---

    private class Pelota {
        private int x, y, ancho, alto;
        private int velocidadX, velocidadY;
        private final int VELOCIDAD_BASE = 3; // Velocidad mínima de la pelota

        public Pelota(int x, int y, int ancho, int alto) {
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
            this.velocidadX = (Math.random() < 0.5 ? 1 : -1) * VELOCIDAD_BASE; // Inicia con dirección X aleatoria
            this.velocidadY = (Math.random() < 0.5 ? 1 : -1) * VELOCIDAD_BASE; // Inicia con dirección Y aleatoria
        }

        public void mover() {
            x += velocidadX;
            y += velocidadY;
        }

        public void cambiarDireccionX() {
            velocidadX *= -1;
        }

        public void cambiarDireccionY() {
            velocidadY *= -1;
        }

        public void incrementarVelocidad() {
            // Aumenta la velocidad ligeramente en cada golpe, pero con un límite
            int factor = 1;
            if (velocidadX > 0) factor = 1; else factor = -1;
            if (Math.abs(velocidadX) < 10) { // Límite de velocidad
                velocidadX = (Math.abs(velocidadX) + 1) * factor;
            }

            if (velocidadY > 0) factor = 1; else factor = -1;
            if (Math.abs(velocidadY) < 10) { // Límite de velocidad
                velocidadY = (Math.abs(velocidadY) + 1) * factor;
            }
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, ancho, alto);
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public int getAncho() { return ancho; }
        public int getAlto() { return alto; }
        
        // --- Getters y Setters corregidos ---
        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
        public void setVelocidadX(int velocidadX) { this.velocidadX = velocidadX; }
        public void setVelocidadY(int velocidadY) { this.velocidadY = velocidadY; }


        public void dibujar(Graphics2D g) {
            g.setColor(Color.WHITE);
            g.fillOval(x, y, ancho, alto); // Dibuja la pelota como un círculo
        }
    }

    private class Paleta {
        private int x, y, ancho, alto;
        private int direccion; // -1 para arriba, 1 para abajo, 0 para detener

        public Paleta(int x, int y, int ancho, int alto) {
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
            this.direccion = 0;
        }

        public void mover() {
            y += direccion;
            // Limitar movimiento dentro del área de juego
            if (y < 0) y = 0;
            if (y + alto > ALTO_JUEGO) y = ALTO_JUEGO - alto; // Corregido el límite inferior
        }
        
        // --- Movimiento de la CPU con una velocidad dada ---
        public void moverArriba(int velocidad) {
            y -= velocidad;
            if (y < 0) y = 0;
        }

        public void moverAbajo(int velocidad) {
            y += velocidad;
            if (y + alto > ALTO_JUEGO) y = ALTO_JUEGO - alto; // Corregido el límite inferior
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, ancho, alto);
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public int getAncho() { return ancho; }
        public int getAlto() { return alto; }
        
        // --- Setter corregido ---
        public void setDireccion(int direccion) { this.direccion = direccion; }

        public void dibujar(Graphics2D g) {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, ancho, alto); // Dibuja la paleta como un rectángulo
        }
    }
}