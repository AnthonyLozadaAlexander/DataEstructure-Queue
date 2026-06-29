package main;

import Controlador.ControladorSimulador;
import Modelo.ColaVacia;
import Modelo.TadCola;
import Vista.FrmSimulador;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class Main {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        TadCola<String> modelo = new TadCola<>("Cola Principal");
        FrmSimulador vista = new FrmSimulador();
        ControladorSimulador controlador = new ControladorSimulador(modelo, vista);
        vista.setVisible(true);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);

    }
}
