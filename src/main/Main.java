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

        ControladorSM controlador = new ControladorSM(Cola, vista);
        vista.setVisible(true);
        vista.setResizable(true);
        vista.setLocationRelativeTo(null);

    }
}
