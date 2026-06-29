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
        this.vistaPrincipal.getBtnEncolar().addActionListener(e -> dibujarEncolar());
        /*{
            @Override
            public void actionPerformed(ActionEvent e){
                ejecutarEncolar();
            }
        });*/

        // boton crear cola
        this.vistaPrincipal.getBtnCrear().addActionListener(e -> crearCola());

        // boton buscar
        this.vistaPrincipal.getBtnBuscar().addActionListener(e -> buscar());

        // boton desencolar
        this.vistaPrincipal.getBtnDesencolar().addActionListener(e  -> desencolar());

        // boton eliminar primero
        this.vistaPrincipal.getBtnEliminarPrimero().addActionListener(e -> quitarPrimero());

    }

    private String Elementos(){
        return modeloCola.numElemCola() > 0 ? String.valueOf(modeloCola.numElemCola()) : "0";
    }

    private void quitarPrimero(){
        try {
            modeloCola.quitarPrimero();
            vistaPrincipal.getPanelMemoria().setCola(modeloCola); // manda la cola, con el primero quitado
            vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar
            this.vistaPrincipal.setTxtHistorial("Primer Elemento Quitado");
            this.vistaPrincipal.setLblTamanio(Elementos());
            this.vistaPrincipal.setLblFrente(String.valueOf(modeloCola.primero()));
        }catch (ColaVacia e){
            this.vistaPrincipal.setLblFrente("N");
            this.vistaPrincipal.setLblFin("N");
        }
    }

    private void desencolar(){
        try {
            String dato = modeloCola.desencolar();
            vistaPrincipal.getPanelMemoria().setCola(modeloCola);
            vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar la cola
            this.vistaPrincipal.setTxtHistorial("Dato Desencolado: " + dato);
            this.vistaPrincipal.setLblTamanio(Elementos());
            this.vistaPrincipal.setLblFrente(String.valueOf(modeloCola.primero()));
        }catch(ColaVacia e){
            this.vistaPrincipal.setLblFrente("N");
            this.vistaPrincipal.setLblFin("N");
        }
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

    private void buscar(){
        String dato = vistaPrincipal.getTxtBuscar();
        boolean encontrar = modeloCola.buscar(dato);

        if(encontrar){
            vistaPrincipal.setTxtHistorial("Dato Encontrado: " + dato);
        }else{
            vistaPrincipal.setTxtHistorial("Dato No Encontrado");
        }
    }

    private void dibujarEncolar(){

        String dato = vistaPrincipal.getTxtValorEncolar().getText();
        if(dato.equals("") || dato.isEmpty()){
            vistaPrincipal.setTxtHistorial("Error: Debe Ingresar Un Dato");
            return;
        }

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
