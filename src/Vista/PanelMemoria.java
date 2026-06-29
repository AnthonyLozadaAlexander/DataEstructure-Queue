package Vista;

import Modelo.Cola;
import Modelo.ColaVacia;
import Modelo.TadCola;

import javax.swing.*;
import java.awt.*;

public class PanelMemoria extends JPanel {
    private Cola<String> colaDibujar;

    public void setCola(Cola<String> colaDibujar) {
        this.colaDibujar = colaDibujar;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // limpiamos la pizarra de dibujo primero

        if (colaDibujar == null) { // si la cola aun no esta creada
            return;
        }

        dibujarReferencias(g);
        dibujarNodos(g);

        /*g.drawRect(x, y, ancho, alto); // dibujar rectangulo
        g.drawString("Dato Test", x + 15, y  + 25);*/
    }

    private void dibujarReferencias(Graphics g) {
        int xPunteros = 100;
        int lado = 50;

        // Puntero Fin
        if (colaDibujar.numElemCola() == 0) {
                int yFin = 250;
                g.drawString("Fin", 50 + 25, yFin - 10);
                g.drawRect(50 + 10, yFin, lado, lado); // rectangulo fin
                g.drawLine(50 + 10, yFin + lado, (50 + 10) + lado, yFin); // linea diagonal
        }


        // Puntero Principio
        int yPrincipio = 450;
        g.drawRect(50, yPrincipio, lado, lado); // rectangulo principio
        g.drawLine(50, yPrincipio + lado, 50 + lado, yPrincipio); // linea diagonal
        g.drawString("Principio", 50, yPrincipio + lado + 20); // titulo principio

    }

    private void redibujarFin(Graphics g, int xi, int lado){

        int yFin = 250;
        g.drawString("Fin", xi + 25, yFin - 10); // titulo fin
        g.drawRect(xi + 10, yFin, lado, lado); // rectangulo fin
        g.drawLine(xi + 10, yFin + lado, (xi+10) + lado, yFin); // linea diagonal

    }

    /*private void punteroFin(Graphics g, int xi, int lado){

    }*/

    private void dibujarNodos(Graphics g) {

        // Constantes para las cajas
        int x = 50;
        int y = 350;
        int ancho = 60;
        int alto = 40;
        int espacio = 40;
        int lado = 50;


        Cola<String> colaAux = new TadCola<>("Aux");
        int i = 0;
        int totalElementos = colaDibujar.numElemCola();

            /*int yFin = 250;
            g.drawString("Fin", 50 + 15, yFin - 10); // titulo fin
            g.drawRect(50, yFin, lado, lado); // rectangulo fin
            g.drawLine(50, yFin + lado, 50 + lado, yFin); // linea diagonal*/


        try {
            while (!colaDibujar.colaVacia()) {

                String dato = colaDibujar.desencolar();

                int xi = (x + i * (ancho + espacio)); // calcular la posición x para el rectángulo actual


                g.drawLine(75, 450, 75, 390); // puntero principio que apunta al primer elemento de la cola

                g.drawLine(xi + 45, y, xi + 45, y+40); // linea para la caja de referencia

                g.drawRect(xi, y, ancho, alto); // dibujar caja del nodo
                g.drawString(dato, xi + 8, y + 25);

                // if para dibujar puntero del siguiente nodo
                if (i < (totalElementos - 1)) {
                    int xSalida = xi + ancho; // inicio () -->
                    int xLlegada = xSalida + espacio; // fin ()
                    int yCentro = y + (alto / 2); // mitad del rectangulo arista lateral derecho
                    // int xCentro = xLlegada + (ancho / 2);


                    // g.drawLine(xCentro, 450, xSalida, yCentro); // flecha que conecta al nodo fin con el puntero fin
                    g.drawLine(xSalida, yCentro, xLlegada, yCentro); // flecha que conecta al nodo siguiente
                }else{
                    // repaint();
                    redibujarFin(g, xi, lado); // redibujar el puntero fin en la nueva posición
                    g.drawLine(xi + (ancho / 2),  250 + 50, xi + (ancho / 2), (250 + 50) + 50); // linea vertical que conecta el puntero fin con el nodo fin

                }

                colaAux.encolar(dato); // mandamos el dato a la cola de respaldo
                i++; // avanzamos al siguiente nodo
            }

            while (!colaAux.colaVacia()) {
                colaDibujar.encolar(colaAux.desencolar()); // encolamos datos a la colaOriginal
            }

        } catch (ColaVacia e) {
            System.out.println("Error: " + e.getMessage());
        }



    }

}
