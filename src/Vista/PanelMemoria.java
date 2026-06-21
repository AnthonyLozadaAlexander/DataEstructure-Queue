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
        int yFin = 80;
        g.drawString("Fin", xPunteros + 15, yFin - 10);
        g.drawRect(xPunteros, yFin, lado, lado); // rectangulo fin
        g.drawLine(xPunteros, yFin + lado, xPunteros + lado, yFin); // linea diagonal

        // Puntero Principio
        int yPrincipio = 450;
        g.drawRect(50, yPrincipio, lado, lado); // rectangulo principio
        g.drawLine(50, yPrincipio + lado, 50 + lado, yPrincipio); // linea diagonal
        g.drawString("Principio", 50 + 5, yPrincipio + lado + 20); // titulo principio
    }

    private void dibujarNodos(Graphics g) {
        int x = 50;
        int y = 350;
        int ancho = 60;
        int alto = 40;
        int espacio = 40;

        Cola<String> colaAux = new TadCola<>("Aux");
        int i = 0;
        int totalElementos = colaDibujar.numElemCola();

        try {
            while (!colaDibujar.colaVacia()) {
                String dato = colaDibujar.desencolar();

                int xi = (x + i * (ancho + espacio)); // calcular la posición x para el rectángulo actual

                g.drawRect(xi, y, ancho, alto);
                g.drawString(dato, xi + 25, y + 25);

                if (i < totalElementos - 1) {
                    int xSalida = xi + ancho;
                    int xLlegada = xSalida + espacio;
                    int yCentro = y + (alto / 2);

                    g.drawLine(xSalida, yCentro, xLlegada, yCentro); // flecha que conecta al nodo siguiente
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
