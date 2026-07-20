package Vista;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

import javax.swing.*;
import java.awt.*;

public class PanelMemoria extends JPanel {

    /** La cola de Strings que se representará gráficamente en este panel. */
    private Cola<String> colaDibujar;

    private boolean remarcarPrimero = false;
    private boolean remarcarUltimo = false;

    /**
     * Establece la cola que debe dibujarse en el panel.
     * Debe llamarse antes de invocar {@code repaint()} para que la visualización sea correcta.
     *
     * @param colaDibujar la cola de Strings a representar gráficamente
     */
    public void setCola(Cola<String> colaDibujar) { // setter para la cola de Dibujos
        this.colaDibujar = colaDibujar;
        this.remarcarPrimero = false;
        this.remarcarUltimo = false;
    }

    public void setRemarcarPrimero(boolean remarcar){
        this.remarcarPrimero = remarcar;
        this.remarcarUltimo = false;
    }

    public void setRemarcarUltimo(boolean remarcar){
        this.remarcarUltimo = remarcar;
        this.remarcarPrimero = false;
    }

    /**
     * Método sobrescrito que dibuja el estado actual de la cola en el panel.
     * Limpia el lienzo, traslada el origen y delega el dibujo a los métodos auxiliares.
     * Si la cola aún no ha sido asignada, no dibuja nada.
     *
     * @param g el contexto gráfico proporcionado por Swing
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // limpiamos la pizarra de dibujo primero
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(0, -70); // mover el punto origen junto con el panel un poco hacia arriba

        if (colaDibujar != null) { // si la cola aun no esta creada
            dibujarReferencias(g2d, colaDibujar);
            dibujarNodos(g2d);
        }

    }

    /**
     * Dibuja las cajas gráficas de las referencias {@code principio} y {@code fin} de la cola.
     * Si la cola está vacía, dibuja una línea diagonal sobre cada caja indicando valor {@code null}.
     *
     * @param g    el contexto gráfico 2D
     * @param cola la cola cuyo estado de vacío se verifica para dibujar las diagonales
     */
    private void dibujarReferencias(Graphics2D g, Cola<String> cola) {
        // int xPunteros = 100;
        int lado = 50;

        // Rectangulos con lados iguales

        // Referencia Fin
        int yFin = 250;
        g.drawString("Fin", 50 + 25, yFin - 10);
        g.drawRect(50 + 10, yFin, lado, lado); // rectangulo fin
        //g.drawLine(50 + 10, yFin + lado, (50 + 10) + lado, yFin); // linea diagonal


        // Referencia Principio
        int yPrincipio = 445;
        g.drawRect(50 + 10, yPrincipio, lado, lado); // rectangulo principio
        //g.drawLine(50, yPrincipio + lado, (50) + lado, yPrincipio); // linea diagonal
        g.drawString("Principio", 55 + 5, yPrincipio + lado + 20); // titulo principio

        if(cola.colaVacia()){
            g.drawLine(50 + 10, yFin + lado, (50 + 10) + lado, yFin); // linea diagonal de fin
            g.drawLine(50 + 10, yPrincipio + lado, (50 + 10) + lado, yPrincipio); // linea diagonal de principio
        }

    }

    /**
     * Redibuja la caja de referencia {@code fin} en la posición horizontal indicada.
     * Se utiliza para actualizar la posición del puntero fin cuando cambia la cola.
     *
     * @param g    el contexto gráfico 2D
     * @param xi   posición horizontal base donde se dibujará la caja fin
     * @param lado tamaño del lado del cuadrado que representa la caja fin
     */

    private void redibujarFin(Graphics2D g, int xi, int lado){

        int yFin = 250;
        g.drawString("Fin", xi + 25, yFin - 10); // titulo fin
        g.drawRect(xi + 10, yFin, lado, lado); // rectangulo fin
        g.drawLine(xi + 10, yFin + lado, (xi+10) + lado, yFin); // linea diagonal

    }

    /**
     * Recorre todos los elementos de la cola y los dibuja como nodos enlazados en el panel.
     * Cada nodo se representa como un rectángulo con su dato; los nodos intermedios incluyen
     * un círculo y una flecha apuntando al siguiente nodo, mientras que el último nodo
     * muestra una diagonal indicando referencia {@code null} y conecta con el puntero fin.
     * La cola se restaura completamente al finalizar el dibujo usando una cola auxiliar.
     *
     * @param g el contexto gráfico 2D
     */
    private void dibujarNodos(Graphics2D g) {

        // Constantes para las cajas
        int x = 200;
        int y = 450;
        int ancho = 60;
        int alto = 40;
        int espacio = 40;
        int lado = 50;


        Cola<String> colaAux = new TadCola<>("Aux");
        int i = 0;
        int j = 0;
        int totalElementos = colaDibujar.numElemCola(); // estado de la colaDibujar

        try {
            while (!colaDibujar.colaVacia()) {

                String dato = colaDibujar.desencolar();
                Color colorOriginal = g.getColor(); // Guardar el color original

                int xi = (x + i * (ancho + espacio)); // calcular la posición x1 para el rectángulo actual del nodo siguiente
                int xj = (x + j * (ancho + espacio)); // calcula la posicion x2 para el rectangulo del nodo referencia Fin

                //g.fillOval(80, 450 + 15, 10, 10);
                g.drawLine(85, 470, 200, 470); // puntero principio que apunta al primer elemento de la cola
                g.drawLine(xi + 45, y, xi + 45, y+40); // diagonal para formar la caja de referencia del nodo

                if(remarcarPrimero && i == 0){
                    g.setColor(new Color(255, 243, 176, 150));
                    g.fillRect(xi, y, 45, alto); // dibujar caja del nodo
                    g.setColor(colorOriginal); // Restaurar el color original

                }else if(remarcarUltimo && i == (totalElementos - 1)){

                    g.setColor(new Color(255, 243, 176, 150));
                    g.fillRect(xi, y, 45, alto); // dibujar caja del nodo
                    g.drawLine(xi + 45, y, xi + 45, y+40); // diagonal para formar la caja de referencia del nodo
                    g.setColor(colorOriginal); // Restaurar el color original
                }

                g.drawLine(xi + 45, y, xi + 45, y+40); // diagonal para formar la caja de referencia del nodo

                g.drawRect(xi, y, ancho, alto); // dibujar caja del nodo
                g.setColor(colorOriginal); // Restaurar el color original
                g.drawString(dato, xi +10, y + 25); // texto del dato en la caja del nodo

                // identificar el penultimo de la cola y asi poder dibujar la flecha siguiente, sin dibujar la flecha en el ultimo elemento
                if (i < (totalElementos - 1)) {
                    int xOrigen = xi + ancho; // inicio () -->
                    int xLlegada = xOrigen + espacio; // fin ()
                    int yCentro = y + (alto / 2); // mitad del rectangulo arista lateral derecho


                    // g.drawLine(xCentro, 450, xSalida, yCentro); // flecha que conecta al nodo fin con el puntero fin
                    g.fillOval((xOrigen - 12), yCentro - 5, 10, 10);// dibujar circulo que conecta al nodo siguiente
                    g.drawLine((xOrigen - 10), yCentro, xLlegada, yCentro); // flecha que conecta al nodo siguiente

                    // else para identificar el ultimo elemento de la  cola y dibujar la diagonal de null y conectar las flechas con el nodo fin
                }else{
                    // repaint();
                    // redibujarFin(g, xi, lado); // redibujar el puntero fin en la nueva posición
                        /*g.drawLine((xi + ancho), y + (alto/2), (xi + ancho) + espacio, y + (alto/2));
                        g.drawLine((xi + ancho) + espacio, y + (alto/ 2), (xi + ancho) + espacio,  y + (alto/ 2) + 30);*/
                        g.drawLine(xi + 45, y + 40, xi + 60, y); // linea diagonal de la caja del nodo siguiente para representar el null del ultimo elemento
                        g.drawLine(65 + 25, 275, xj + (ancho / 2), 275); // linea horizontal que conecta el puntero fin con el nodo fin
                        g.drawLine(xi + (ancho / 2), 225 + 50, xi + (ancho / 2), (250 + 50) + 150); // linea vertical que conecta el puntero fin con el nodo fin
                }

                colaAux.encolar(dato); // mandamos el dato a la cola de respaldo
                i++; // avanzamos al siguiente nodo
                j++; // avanzamos al siguiente nodo para la referencia fin
            }

            while (!colaAux.colaVacia()) {
                colaDibujar.encolar(colaAux.desencolar()); // encolamos datos a la cola
            }

        } catch (ColaVacia e) {
            System.out.println("Error: " + e.getMessage());
        }



    }

}
