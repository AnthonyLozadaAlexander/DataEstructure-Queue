package Controlador;

import Modelo.ColaVacia;
import Modelo.Algoritmos;
import Modelo.TadCola;
import Vista.FrmSimulador;

public class ControladorSM {

    private TadCola<String> cola;
    private FrmSimulador vistaPrincipal;

    public ControladorSM(TadCola<String> cola, FrmSimulador vistaPrincipal){
        this.cola = cola;
        this.vistaPrincipal = vistaPrincipal;

        // boton encolar
        this.vistaPrincipal.getBtnEncolar().addActionListener(e -> Encolar());
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

        // boton vaciar cola
        this.vistaPrincipal.getBtnVaciarCola().addActionListener(e -> vaciarCola());

        // boton invertirCola
        this.vistaPrincipal.getBtnInvertirCola().addActionListener(e -> invertirCola());

        // boton Descendente
        this.vistaPrincipal.getBtnDescendente().addActionListener(e -> Descendente());

        // boton Ascendente
        this.vistaPrincipal.getBtnAscendente().addActionListener(e -> Ascendente());

    }

    private String Elementos(){
        return cola.numElemCola() > 0 ? String.valueOf(cola.numElemCola()) : "0";
    }

    private void invertirCola(){
        try {
            cola.invertirCola();
            vistaPrincipal.getPanelMemoria().setCola(cola); // manda la cola, con la cola invertida
            vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar

            this.vistaPrincipal.setTxtHistorial("Cola Invertida");
            this.vistaPrincipal.setLblTamanio(Elementos());
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
            this.vistaPrincipal.setLblFin(Algoritmos.ultimoElementoDeLaCola(cola));

            cola.invertirCola();
            vistaPrincipal.getPanelMemoria().setCola(cola); // manda la cola, con la cola invertida
            vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar

        }catch(ColaVacia e){
            this.etiquetasN();
        }
    }

    private void vaciarCola(){
        cola.eliminarCola();
        vistaPrincipal.getPanelMemoria().setCola(cola); // manda la cola, con el primero quitado
        vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar
        this.vistaPrincipal.setTxtHistorial("Cola Vaciada");
        this.vistaPrincipal.setLblTamanio(Elementos());
    }

    private void quitarPrimero(){
        try {
            cola.quitarPrimero();
            vistaPrincipal.getPanelMemoria().setCola(cola); // manda la cola, con el primero quitado
            vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar
            this.vistaPrincipal.setTxtHistorial("Primer Elemento Quitado");
            this.vistaPrincipal.setLblTamanio(Elementos());
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
        }catch (ColaVacia e){
            etiquetasN();
        }
    }

    private void desencolar(){
        try {
            String dato = cola.desencolar();
            vistaPrincipal.getPanelMemoria().setCola(cola);
            vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar la cola
            this.vistaPrincipal.setTxtHistorial("Dato Desencolado \u25BC"+ "\n" + dato);
            this.vistaPrincipal.setLblTamanio(Elementos());
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
        }catch(ColaVacia e){
            etiquetasN();
        }
    }

    private void crearCola(){
        if(cola.numElemCola() > 0){
            this.vistaPrincipal.setTxtHistorial("\nError \u25BC \nLa Cola Ya Fue Creada");
            return;
        }

        vistaPrincipal.getPanelMemoria().setCola(cola);
        vistaPrincipal.getPanelMemoria().repaint();
        vistaPrincipal.setTxtHistorial("Cola Creada Con Exito");


        try{
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
            this.vistaPrincipal.setLblTamanio(Elementos());
        } catch (ColaVacia e) {
            etiquetasN();
        }
    }

    private void buscar(){
        try {
            String dato = vistaPrincipal.getTxtBuscar();
            boolean encontrar = Algoritmos.buscarR(cola, dato);

            if (encontrar) {
                vistaPrincipal.setTxtHistorial("Dato Encontrado \u25BC" + "\n" + dato);
            } else {
                vistaPrincipal.setTxtHistorial("Dato No Encontrado");
            }
        }catch(ColaVacia e){
            etiquetasN();
        }
    }

    private void Encolar(){

        String dato = vistaPrincipal.getTxtValorEncolar().getText();
        if(dato.equals("") || dato.isEmpty()){
            vistaPrincipal.setTxtHistorial("Error \u25BC \nDebe Ingresar Un Dato");
            return;
        }

        cola.encolar(dato);
        vistaPrincipal.getPanelMemoria().setCola(cola);
        vistaPrincipal.getPanelMemoria().repaint();
        vistaPrincipal.setTxtValor("");
        vistaPrincipal.setTxtHistorial("Dato Encolado \u25BC" + "\n" + dato);

        try{
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
            this.vistaPrincipal.setLblTamanio(Elementos());
            this.vistaPrincipal.setLblFin(dato);
        } catch (ColaVacia e) {
            etiquetasN();
        }

    }

    private void Descendente(){
        try {
            Algoritmos.ordenarQuickSortDescendente(cola);
            this.vistaPrincipal.getPanelMemoria().setCola(cola);
            this.vistaPrincipal.getPanelMemoria().repaint();
            vistaPrincipal.setTxtHistorial("Cola Ordenada Descendentemente");
        }catch(ColaVacia e){
            etiquetasN();
        }
    }

    private void Ascendente(){
        try {
            Algoritmos.ordenarQuickSortAscendente(cola);
            this.vistaPrincipal.getPanelMemoria().setCola(cola);
            this.vistaPrincipal.getPanelMemoria().repaint();
            vistaPrincipal.setTxtHistorial("Cola Ordenada Ascendente");
        }catch(ColaVacia e){
            etiquetasN();
        }
    }

    public void etiquetasN(){
        this.vistaPrincipal.setLblFrente("N");
        this.vistaPrincipal.setLblFin("N");
    }


}
