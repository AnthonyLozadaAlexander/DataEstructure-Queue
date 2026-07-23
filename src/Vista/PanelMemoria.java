package Vista;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Componente gráfico personalizado que extiende {@link JPanel} para representar
 * visualmente la estructura de datos Cola y sus referencias (Principio y Fin).
 *
 * @author Grupo-02
 * @version 1.0
 * @see JPanel
 * @see Cola
 */
public class PanelMemoria extends JPanel {

    /**
     * La lista con los datos en formato de texto a representar gráficamente.
     */
    private ArrayList<String> datosGraficos;

    /**
     * Indicador para resaltar visualmente el nodo del principio.
     */
    private boolean remarcarPrimero = false;
    /**
     * Indicador para resaltar visualmente el nodo del final.
     */
    private boolean remarcarUltimo = false;

    /**
     * Establece la cola que debe graficarse en el panel extrayendo sus datos a una lista interna.
     * Debe llamarse antes de invocar {@code repaint()} para actualizar la representación gráfica.
     *
     * @param cola la cola de Strings a representar visualmente
     */
    public void setCola(Cola<String> cola) { // setter para la cola de Graficos
        this.datosGraficos = new ArrayList<>();
        this.remarcarPrimero = false;
        this.remarcarUltimo = false;

        if (cola != null && !cola.colaVacia()) {
            Cola<String> aux = new TadCola<>("Aux");
            try {
                while (!cola.colaVacia()) {
                    String dato = cola.desencolar(); // extraer los datos para los graficos
                    this.datosGraficos.add(dato);
                    aux.encolar(dato);
                }
                while (!aux.colaVacia()) {
                    cola.encolar(aux.desencolar()); // regresar la cola a su estado original
                }
            } catch (ColaVacia e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    /**
     * Define si se debe resaltar visualmente el primer elemento de la cola.
     * Cuando se establece en {@code true}, solo el primer elemento será resaltado.
     *
     * @param remarcar {@code true} para resaltar el primer elemento; {@code false} en caso contrario
     */
    public void setRemarcarPrimero(boolean remarcar) {
        this.remarcarPrimero = remarcar;
        this.remarcarUltimo = false;
    }

    /**
     * Define si se debe resaltar visualmente el último elemento de la cola.
     * Cuando se establece en {@code true}, solo el último elemento será resaltado.
     *
     * @param remarcar {@code true} para resaltar el último elemento; {@code false} en caso contrario
     */
    public void setRemarcarUltimo(boolean remarcar) {
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

        if (datosGraficos == null) { // si la cola aun no esta creada
        } else {  // si la cola fue creada
            dibujarReferencias(g2d);
            dibujarNodos(g2d);
        }
    }

    /**
     * Dibuja las cajas gráficas de las referencias {@code principio} y {@code fin} de la cola.
     * Si la cola está vacía, dibuja una línea diagonal sobre cada caja indicando valor {@code null}.
     *
     * @param g el contexto gráfico 2D proporcionado por Swing
     */
    private void dibujarReferencias(Graphics2D g) {
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

        if (datosGraficos.isEmpty()) { // si la cola esta vacia dibujar las diagonales de null
            g.drawLine(50 + 10, yFin + lado, (50 + 10) + lado, yFin); // linea diagonal de fin
            g.drawLine(50 + 10, yPrincipio + lado, (50 + 10) + lado, yPrincipio); // linea diagonal de principio
        }

    }

    /**
     * Actualiza el tamaño del panel basado en la cantidad de elementos en la cola.
     * Calcula el ancho dinámicamente: ancho base + (número de elementos × ancho por nodo).
     * Luego revalida y repinta el panel para reflejar los cambios.
     */
    public void actualizarTamanioPanel() {
        int total = 0;
        int anchoBase = 245;
        int anchoPorNodo = 100;
        int anchoTotal = 0;

        if (datosGraficos == null) {
            setPreferredSize(new Dimension(800, 700));
            revalidate();
        } else {
            total = datosGraficos.size();
            anchoTotal = anchoBase + (total * anchoPorNodo);
            setPreferredSize(new Dimension(anchoTotal, 700));
            revalidate();
        }
    }


    /**
     * Recorre la lista de datos y dibuja cada elemento como un nodo enlazado en el lienzo.
     * Cada nodo se representa como un rectángulo con su dato interno y su puntero siguiente;
     * los nodos intermedios incluyen un círculo y flecha de enlace, mientras que el último nodo
     * muestra la marca diagonal de {@code null} y la conexión con la referencia {@code Fin}.
     *
     * @param g el contexto gráfico 2D proporcionado por Java Swing
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
        int totalElementos = datosGraficos.size(); // Elementos Actuales De La Cola


        for (i = 0; i < datosGraficos.size(); i++) {
            String dato = datosGraficos.get(i);
            Color colorOriginal = g.getColor(); // Guardar el color original

            int xi = (x + i * (ancho + espacio)); // calcular la posición x1 para el rectángulo actual del nodo siguiente


            //g.fillOval(80, 450 + 15, 10, 10);
            g.drawLine(85, 470, 200, 470); // puntero principio que apunta al primer elemento de la cola
            g.drawLine(xi + 45, y, xi + 45, y + 40); // diagonal para formar la caja de referencia del nodo

            if (remarcarPrimero && i == 0) {
                g.setColor(new Color(255, 243, 176, 150));
                g.fillRect(xi, y, 45, alto); // dibujar caja del nodo
                g.setColor(colorOriginal); // Restaurar el color original

            } else if (remarcarUltimo && i == (totalElementos - 1)) {

                g.setColor(new Color(255, 243, 176, 150));
                g.fillRect(xi, y, 45, alto); // dibujar caja del nodo
                g.drawLine(xi + 45, y, xi + 45, y + 40); // diagonal para formar la caja de referencia del nodo
                g.setColor(colorOriginal); // Restaurar el color original
            }

            g.drawLine(xi + 45, y, xi + 45, y + 40); // diagonal para formar la caja de referencia del nodo
            g.drawRect(xi, y, ancho, alto); // dibujar caja del nodo
            g.setColor(colorOriginal); // Restaurar el color original
            g.drawString(dato, xi + 7, y + 25); // texto del dato en la caja del nodo

            // identificar el penultimo de la cola y asi poder dibujar la flecha siguiente, sin dibujar la flecha en el ultimo elemento
            if (i < (totalElementos - 1)) {
                int xOrigen = xi + ancho; // inicio () -->
                int xLlegada = xOrigen + espacio; // fin ()
                int yCentro = y + (alto / 2); // mitad del rectangulo arista lateral derecho


                // g.drawLine(xCentro, 450, xSalida, yCentro); // flecha que conecta al nodo fin con el puntero fin
                g.fillOval((xOrigen - 12), yCentro - 5, 10, 10);// dibujar circulo que conecta al nodo siguiente
                g.drawLine((xOrigen - 10), yCentro, xLlegada, yCentro); // flecha que conecta al nodo siguiente

                // else para identificar el ultimo elemento de la  cola y dibujar la diagonal de null y conectar las flechas con el nodo fin
            } else {

                g.drawLine(xi + 45, y + 40, xi + 60, y); // linea diagonal de la caja del nodo siguiente para representar el null del ultimo elemento
                g.drawLine(65 + 25, 275, xi + (ancho / 2), 275); // linea horizontal que conecta el puntero fin con el nodo fin
                g.drawLine(xi + (ancho / 2), 275, xi + (ancho / 2), y); // linea vertical que conecta el puntero fin con el nodo fin
            }

        }


    }

}
