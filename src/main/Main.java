package main;

import Controlador.ControladorSimulador;
import Modelo.ColaVacia;
import Modelo.TadCola;
import Vista.FrmSimulador;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args) {

        FlatLightLaf.setup();
        TadCola<String> modelo = new TadCola<>("Cola Principal");
        FrmSimulador window = new FrmSimulador();

            ControladorSimulador controlador = new ControladorSimulador(modelo, window);
            window.setVisible(true);
            window.setResizable(false);
            window.setLocationRelativeTo(null);

    }
}
