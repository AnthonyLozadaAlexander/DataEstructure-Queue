package main;

import Controlador.ControladorSM;
import Modelo.TadCola;
import Vista.FrmSimulador;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class Main {
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
