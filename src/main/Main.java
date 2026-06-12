package main;

import Vista.FrmSimulador;
import com.formdev.flatlaf.FlatLightLaf;



public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        FrmSimulador window = new FrmSimulador();
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
}
