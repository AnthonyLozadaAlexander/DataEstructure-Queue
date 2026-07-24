package Controlador;

import tadCola.Cola;
import tadCola.ColaVacia;
import AlgoritmosCola.Algoritmos;
import tadCola.TadCola;
import Vista.FrmSimulador;

/**
 * Controlador principal de la aplicación siguiendo el patrón Arquitectónico Model-View-Controller (MVC).
 * <p>
 * Se encarga de capturar las acciones del usuario desde la vista {@link FrmSimulador},
 * invocar las operaciones sobre el modelo {@link TadCola} y los algoritmos de {@link Algoritmos},
 * y actualizar la interfaz gráfica correspondiente.
 * </p>
 *
 * @author Grupo-02
 * @version 1.0
 * @see TadCola
 * @see FrmSimulador
 * @see Algoritmos
 */

public class ControladorSM {

    /** Referencia a la cola de cadenas que se gestiona en la aplicación. */
    private TadCola<String> cola;
    /** Referencia a la vista principal de la aplicación. */
    private FrmSimulador vistaPrincipal;

    /**
     * Crea el controlador, inyectando el modelo y la vista, y registra los
     * {@code ActionListener} de todos los botones de la interfaz gráfica.
     *
     * @param cola          la cola de Strings que actúa como referencia de datos
     * @param vistaPrincipal la ventana principal de la aplicación
     */

    public ControladorSM(TadCola<String> cola, FrmSimulador vistaPrincipal){
        this.cola = cola;
        this.vistaPrincipal = vistaPrincipal;

        // boton encolar
        this.vistaPrincipal.getBtnEncolar().addActionListener(e -> Encolar());

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

        // boton ver Primero
        this.vistaPrincipal.getBtnVerPrimero().addActionListener(e -> verPrimero());

        // boton ver Ultimo
        this.vistaPrincipal.getBtnVerUltimo().addActionListener(e -> verUltimo());

    }

    /**
     * Retorna el número de elementos de la cola como cadena de texto.
     * Si la cola está vacía retorna {@code "0"}.
     *
     * @return número de elementos como {@code String}
     */
    private String Elementos(){
        String info = "";
        if(cola.numElemCola() > 0){
            info = String.valueOf(cola.numElemCola());
        }else{
            info = "0";
        }
        return info;
    }

    /**
     * Invierte el orden de los elementos de la cola y actualiza la vista.
     * Realiza la inversión, refresca el panel gráfico y las etiquetas de información,
     * y luego vuelve a invertir para dejar la cola en su estado original visualmente.
     * Si la cola está vacía, muestra las etiquetas en estado nulo.
     */
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

    /**
     * Vacía completamente la cola y actualiza la vista para reflejar el estado vacío.
     * Registra la acción en el historial y actualiza la etiqueta de tamaño.
     */
    private void vaciarCola(){
        cola.eliminarCola();
        vistaPrincipal.getPanelMemoria().setCola(cola); // manda la cola, con el primero quitado
        vistaPrincipal.getPanelMemoria().repaint(); // manda a redibujar
        this.vistaPrincipal.setTxtHistorial("Cola Vaciada");
        this.vistaPrincipal.setLblTamanio(Elementos());
        etiquetasN();
    }

    /**
     * Elimina el primer elemento de la cola sin retornar su valor y actualiza la vista.
     * Refresca el panel gráfico, el historial, el tamaño y la etiqueta del frente.
     * Si la cola está vacía, muestra las etiquetas en estado nulo.
     */
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

    /**
     * Extrae y muestra el primer elemento de la cola, actualizando la vista completa.
     * El dato extraído se registra en el historial. Si la cola está vacía,
     * muestra las etiquetas en estado nulo.
     */
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

    /**
     * Inicializa la visualización de la cola en el panel gráfico.
     * Si la cola ya tiene elementos, notifica al usuario que ya fue creada
     * y no realiza ninguna acción adicional.
     */
    private void crearCola(){
        if(cola.numElemCola() > 0){
            this.vistaPrincipal.setTxtHistorial("\nError \u25BC \nLa Cola Ya Fue Creada");
        }else {
            vistaPrincipal.getPanelMemoria().setCola(cola);
            vistaPrincipal.getPanelMemoria().repaint();
            vistaPrincipal.setTxtHistorial("Cola Creada Con Exito");
        }

        try{
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
            this.vistaPrincipal.setLblTamanio(Elementos());
        } catch (ColaVacia e) {
            etiquetasN();
        }
    }

    /**
     * Busca un elemento en la cola usando el valor ingresado en el campo de búsqueda
     * de la vista, e informa el resultado en el historial.
     * Utiliza el algoritmo recursivo {@link Algoritmos#buscarR}.
     */
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

    /**
     * Lee el valor del campo de texto de la vista, valida que no esté vacío,
     * lo encola en la Cola y actualiza la vista: panel gráfico, historial,
     * tamaño, frente y fin de la cola.
     */
    private void Encolar(){

        String dato = vistaPrincipal.getTxtValorEncolar().getText();
        if(dato.equals("") || dato.isEmpty()){
            vistaPrincipal.setTxtHistorial("Error \u25BC \nDebe Ingresar Un Dato");
        }else if(dato.length() > 6) {
            vistaPrincipal.setTxtHistorial("Error \u25BC \nEl Dato No Puede Tener \nMas De 6 Caracteres");
        }else{
            cola.encolar(dato);
            vistaPrincipal.getPanelMemoria().setCola(cola);
            vistaPrincipal.getPanelMemoria().actualizarTamanioPanel();
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
    }

    /**
     * Ordena los elementos de la cola de forma descendente usando QuickSort
     * y actualiza el panel gráfico con el nuevo orden.
     * Registra la acción en el historial.
     */

    private void Descendente(){
        try {
            Algoritmos.QuickSortDescendente(cola);
            this.vistaPrincipal.getPanelMemoria().setCola(cola);
            this.vistaPrincipal.getPanelMemoria().repaint();
            vistaPrincipal.setTxtHistorial("Cola Ordenada Descendentemente");
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
            this.vistaPrincipal.setLblFin(Algoritmos.ultimoElementoDeLaCola(cola));
            Algoritmos.QuickSortDescendente(cola); // para que la cola quede en su orden original
        }catch(ColaVacia e){
            etiquetasN();
        }
    }

    /**
     * Ordena los elementos de la cola de forma ascendente usando QuickSort
     * y actualiza el panel gráfico con el nuevo orden.
     * Registra la acción en el historial.
     */
    private void Ascendente(){
        try {
            Algoritmos.QuickSortAscendente(cola);
            this.vistaPrincipal.getPanelMemoria().setCola(cola);
            this.vistaPrincipal.getPanelMemoria().repaint();
            vistaPrincipal.setTxtHistorial("Cola Ordenada Ascendente");
            this.vistaPrincipal.setLblFrente(String.valueOf(cola.primero()));
            this.vistaPrincipal.setLblFin(Algoritmos.ultimoElementoDeLaCola(cola));
            Algoritmos.QuickSortAscendente(cola); // para que la cola quede en su orden original
        }catch(ColaVacia e){
            etiquetasN();
        }
    }

     /**
      * Restablece las etiquetas de frente y fin de la cola en la vista al valor {@code "N"},
      * indicando que la cola está vacía o que ocurrió un error.
      */
     public void etiquetasN(){
         this.vistaPrincipal.setLblFrente("N");
         this.vistaPrincipal.setLblFin("N");
     }

     /**
      * Resalta visualmente el primer elemento de la cola en el panel gráfico.
      * Si la cola está vacía, muestra un mensaje de error en el historial.
      */
     private void verPrimero(){
         try {
             if (cola.colaVacia()) {
                 vistaPrincipal.setTxtHistorial("Error \u25BC \nLa Cola Esta Vacia");
             } else {
                 vistaPrincipal.setTxtHistorial("Primer Elemento \u25BC \n" + cola.primero());
                 vistaPrincipal.getPanelMemoria().setRemarcarPrimero(true);
                 vistaPrincipal.getPanelMemoria().repaint();
             }
         }catch(ColaVacia e){

         }
     }

     /**
      * Resalta visualmente el último elemento de la cola en el panel gráfico.
      * Si la cola está vacía, muestra un mensaje de error en el historial.
      */
     private void verUltimo() {
         try {
             if (cola.colaVacia()) {
                 vistaPrincipal.setTxtHistorial("Error \u25BC \nLa Cola Esta Vacia");
             } else {
                     vistaPrincipal.setTxtHistorial("Último Elemento \u25BC \n" + Algoritmos.ultimoElementoDeLaCola(cola));
                     vistaPrincipal.getPanelMemoria().setRemarcarUltimo(true);
                     vistaPrincipal.getPanelMemoria().repaint();
             }
         } catch (ColaVacia e) {

         }
     }

 }

