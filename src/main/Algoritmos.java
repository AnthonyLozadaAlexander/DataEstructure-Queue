package main;

import Modelo.Cola;
import Modelo.ColaVacia;
import Modelo.TadCola;

/**
 * Clase de utilidades con algoritmos genéricos aplicables sobre la estructura {@link Cola}.
 * Proporciona métodos estáticos para ordenamiento (QuickSort ascendente y descendente),
 * búsqueda recursiva y obtención del último elemento.
 *
 * @author Grupo-02
 */

public class Algoritmos {

    /**
     * Punto de entrada para ordenar los elementos de una cola de forma ascendente
     * utilizando el algoritmo QuickSort adaptado para colas.
     *
     * @param <T>      tipo de los elementos de la cola; debe implementar {@link Comparable}
     * @param original la cola cuyos elementos se ordenarán de menor a mayor
     * @throws ColaVacia si ocurre algún problema al operar con la cola
     */

    public static <T> void QuickSortAscendente(Cola<T> original) throws ColaVacia{
        ordenarQuickSortAscendente(original);
    }

    /**
     * Implementación recursiva del algoritmo QuickSort para ordenar una cola de forma ascendente.
     * Selecciona el primer elemento como pivote, distribuye los demás elementos en dos subcolas
     * (menores y mayores al pivote), ordena cada subcola recursivamente y las concatena.
     *
     * @param <T>      tipo de los elementos; debe implementar {@link Comparable}
     * @param original la cola a ordenar (se modifica en el lugar)
     * @throws ColaVacia si ocurre algún problema al desencolar elementos
     */

    public static <T> void ordenarQuickSortAscendente(Cola<T> original) throws ColaVacia {
        T pivot = null;
        TadCola<T> menor =  new TadCola<>("Menor");
        TadCola<T> mayor =  new TadCola<>("Mayor");

        if(original.numElemCola() > 1) {
            pivot = original.desencolar(); // toma el pivote

            while (!(original.colaVacia())) {
                T elementoActual = original.desencolar();

                if (((Comparable<T>) elementoActual).compareTo(pivot) < 0) {
                    menor.encolar(elementoActual);
                } else {
                    mayor.encolar(elementoActual);
                }
            }

            ordenarQuickSortAscendente(menor);
            ordenarQuickSortAscendente(mayor);

            while (!menor.colaVacia()) {
                original.encolar(menor.desencolar());
            }

            original.encolar(pivot);

            while(!mayor.colaVacia()){
                original.encolar(mayor.desencolar());
            }

        }
    }

    /**
     * Punto de entrada para ordenar los elementos de una cola de forma descendente
     * utilizando el algoritmo QuickSort adaptado para colas.
     *
     * @param <T>      tipo de los elementos de la cola; debe implementar {@link Comparable}
     * @param original la cola cuyos elementos se ordenarán de mayor a menor
     * @throws ColaVacia si ocurre algún problema al operar con la cola
     */

    public static <T> void QuickSortDescendente(Cola<T> original) throws ColaVacia{
        ordenarQuickSortDescendente(original);
    }

    /**
     * Implementación recursiva del algoritmo QuickSort para ordenar una cola de forma descendente.
     * Selecciona el primer elemento como pivote, distribuye los demás elementos en dos subcolas
     * (mayores y menores al pivote), ordena cada subcola recursivamente y las concatena.
     *
     * @param <T>      tipo de los elementos; debe implementar {@link Comparable}
     * @param original la cola a ordenar (se modifica en el lugar)
     * @throws ColaVacia si ocurre algún problema al desencolar elementos
     */

    public static <T> void ordenarQuickSortDescendente(Cola<T> original) throws ColaVacia {
        T pivot = null;
        TadCola<T> menor =  new TadCola<>("Menor");
        TadCola<T> mayor =  new TadCola<>("Mayor");

        if(original.numElemCola() > 1) {
            pivot = original.desencolar(); // toma el pivote

            while (!(original.colaVacia())) {
                T elementoActual = original.desencolar();

                if (((Comparable<T>) elementoActual).compareTo(pivot) > 0) {
                    mayor.encolar(elementoActual);
                } else {
                    menor.encolar(elementoActual);
                }
            }

            ordenarQuickSortDescendente(menor);
            ordenarQuickSortDescendente(mayor);

            while (!mayor.colaVacia()) {
                original.encolar(mayor.desencolar());
            }

            original.encolar(pivot);

            while(!menor.colaVacia()){
                original.encolar(menor.desencolar());
            }

        }
    }


    /**
     * Busca recursivamente un elemento dentro de la cola sin destruirla.
     * Extrae los elementos uno a uno comparándolos con el buscado y los reencola
     * al final para restaurar la cola original al terminar la búsqueda.
     *
     * @param <T>      tipo de los elementos de la cola
     * @param cola     la cola donde se realizará la búsqueda
     * @param elemento el elemento a buscar
     * @return {@code true} si el elemento fue encontrado; {@code false} en caso contrario
     * @throws ColaVacia si ocurre un error al operar con la cola
     */

    public static <T> boolean buscarR(Cola<T> cola, T elemento) throws ColaVacia {
        boolean encontrado;
        if(cola.colaVacia()){
            encontrado = false;
        }else{
            T dato = cola.desencolar();
            if(dato.equals(elemento)){ // encontro el elemento
                encontrado = true;
            }else{
                encontrado = buscarR(cola, elemento);
            }

            cola.encolar(dato); // restaurar cola
        }

        return encontrado;
    }

    /**
     * Obtiene el último elemento de la cola de forma recursiva sin destruirla.
     * Extrae elementos sucesivamente hasta llegar al final, identificando el último,
     * y luego los reencola para restaurar el estado original de la cola.
     *
     * @param <T>  tipo de los elementos de la cola
     * @param cola la cola de la que se desea obtener el último elemento
     * @return el último elemento de la cola, o {@code null} si la cola está vacía
     * @throws ColaVacia si ocurre un error al desencolar elementos
     */

    public static <T> T ultimoElementoDeLaCola(Cola<T> cola) throws ColaVacia{
        T ultimoElemento = null;
        T guardar = null;

        if(!cola.colaVacia()) {
            guardar = cola.desencolar();
            ultimoElemento = ultimoElementoDeLaCola(cola);
            if (cola.colaVacia()) {
                ultimoElemento = guardar;

            }
            cola.encolar(guardar); // restaurar cola
        }

        return ultimoElemento;
    }

}
