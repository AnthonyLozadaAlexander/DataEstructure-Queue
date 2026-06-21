package Controlador;

import Modelo.TadCola;
import Vista.FrmSimulador;
import Vista.PanelMemoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorSimulador {

    private TadCola<String> modeloCola;
    private FrmSimulador vistaPrincipal;

    public ControladorSimulador(TadCola<String> modeloCola, FrmSimulador vistaPrincipal){
        this.modeloCola = modeloCola;
        this.vistaPrincipal = vistaPrincipal;

        // boton encolar de la interfaz
        this.vistaPrincipal.getBtnEncolar().addActionListener(e -> ejecutarEncolar()); //{
           /* @Override
            public void actionPerformed(ActionEvent e){
                ejecutarEncolar();
            }
        });*/

        this.vistaPrincipal.getBtnCrear().addActionListener(e -> dibujarReferencias());
    }

    private void dibujarReferencias(){
        vistaPrincipal.getPanelMemoria().setCola(modeloCola);
        vistaPrincipal.getPanelMemoria().repaint();
    }

    private void ejecutarEncolar(){

        String dato = vistaPrincipal.getTxtValorEncolar().getText();
        modeloCola.encolar(dato);
        vistaPrincipal.getPanelMemoria().setCola(modeloCola);
        vistaPrincipal.getPanelMemoria().repaint();
        vistaPrincipal.txtValor("");

    }


}
