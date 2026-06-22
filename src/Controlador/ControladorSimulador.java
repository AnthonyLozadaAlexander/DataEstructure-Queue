package Controlador;

import Modelo.ColaVacia;
import Modelo.Algoritmos;
import Modelo.TadCola;
import Vista.FrmSimulador;

public class ControladorSimulador {

    private TadCola<String> modeloCola;
    private FrmSimulador vistaPrincipal;

    public ControladorSimulador(TadCola<String> modeloCola, FrmSimulador vistaPrincipal){
        this.modeloCola = modeloCola;
        this.vistaPrincipal = vistaPrincipal;

        // boton encolar
        this.vistaPrincipal.getBtnEncolar().addActionListener(e -> dibujarEncolar()); //{
           /* @Override
            public void actionPerformed(ActionEvent e){
                ejecutarEncolar();
            }
        });*/

        // boton crear cola
        this.vistaPrincipal.getBtnCrear().addActionListener(e -> crearCola());

    }

    private String Elementos(){
        return modeloCola.numElemCola() > 0 ? String.valueOf(modeloCola.numElemCola()) : "0";
    }

    private void crearCola(){
        vistaPrincipal.getPanelMemoria().setCola(modeloCola);
        vistaPrincipal.getPanelMemoria().repaint();
        vistaPrincipal.setTxtHistorial("Cola Creada Con Exito");
        try{
            this.vistaPrincipal.setLblFrente(String.valueOf(modeloCola.primero()));
            this.vistaPrincipal.setLblTamanio(Elementos());
        } catch (ColaVacia e) {
            this.vistaPrincipal.setLblFrente("N");
            this.vistaPrincipal.setLblFin("N");
        }
    }

    private void dibujarEncolar(){

        String dato = vistaPrincipal.getTxtValorEncolar().getText();
        modeloCola.encolar(dato);
        vistaPrincipal.getPanelMemoria().setCola(modeloCola);
        vistaPrincipal.getPanelMemoria().repaint();
        vistaPrincipal.setTxtValor("");
        vistaPrincipal.setTxtHistorial("Dato Encolado: " + dato);

        try{
            this.vistaPrincipal.setLblFrente(String.valueOf(modeloCola.primero()));
            this.vistaPrincipal.setLblTamanio(Elementos());
            this.vistaPrincipal.setLblFin(dato);
        } catch (ColaVacia e) {
            this.vistaPrincipal.setLblFrente("N");
            this.vistaPrincipal.setLblFin("N");
        }

    }


}
