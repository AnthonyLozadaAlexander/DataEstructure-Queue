package main;

import Controlador.ControladorSM;
import tadCola.TadCola;
import Vista.FrmSimulador;
import com.formdev.flatlaf.FlatIntelliJLaf;
/**
 * Clase principal de arranque del Simulador Gráfico de Cola.
 * <p>
 * Configura el Look and Feel de FlatLaf, instancia el modelo de datos,
 * la vista principal y el controlador enlazador, y despliega la ventana centrada en pantalla.
 * </p>
 *
 * @author Grupo-02
 * @version 1.0
 * @see com.formdev.flatlaf.FlatIntelliJLaf
 * @see TadCola
 * @see FrmSimulador
 * @see ControladorSM
 */
public class Main {

    /**
     * Punto de entrada de la aplicación.
     * Inicializa el tema visual FlatIntelliJLaf, crea la cola de datos, la vista principal
     * y el controlador que los enlaza; finalmente hace visible la ventana centrada en pantalla.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        TadCola<String> Cola = new TadCola<>("Cola Principal");
        FrmSimulador vista = new FrmSimulador();

        // Controlador
        ControladorSM controlador = new ControladorSM(Cola, vista);

        // Metodos para la vista
        vista.setVisible(true); // ver la vista
        vista.setResizable(true); // que sea minimizable y maximizable
        vista.setLocationRelativeTo(null); // que se centre en el monitor

    }
}
