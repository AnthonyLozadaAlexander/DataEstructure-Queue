package AlgoritmosCola;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

/**
 * Clase de utilidades que contiene algoritmos genéricos de ordenamiento y búsqueda
 * sobre la estructura de datos {@link Cola}.
 * <p>
 * Proporciona métodos estáticos recursivos para el ordenamiento QuickSort (ascendente y descendente),
 * la búsqueda recursiva de elementos y la localización del último elemento sin destruir la cola.
 * </p>
 *
 * @author Grupo-02
 * @version 1.0
 * @see Cola
 * @see TadCola
 * @see ColaVacia
 */

public class Algoritmos {

    /**
     * Punto de entrada público para ordenar los elementos de una cola de forma ascendente
     * utilizando el algoritmo QuickSort adaptado para colas.
     *
     * @param <T>      tipo de los elementos contenidos en la cola; debe implementar {@link Comparable}
     * @param original la cola cuyos elementos se ordenarán de menor a mayor (se modifica en el lugar)
     * @throws ColaVacia si la cola se encuentra vacía o si ocurre un error al desencolar elementos
     */

    public static <T> void QuickSortAscendente(Cola<T> original) throws ColaVacia{
        ordenarQuickSortAscendente(original);
    }

    /**
     * Implementación recursiva interna del algoritmo QuickSort para ordenamiento ascendente.
     * Selecciona el primer elemento como pivote, particiona los elementos restantes en dos
     * subcolas (menores y mayores o iguales al pivote), las ordena recursivamente y las reconcatena.
     *
     * @param <T>      tipo de los elementos; debe implementar {@link Comparable}
     * @param original la cola a ordenar en la llamada recursiva actual
     * @throws ColaVacia si ocurre un error al desencolar durante la partición o reconcatenación
     */

    private static <T> void ordenarQuickSortAscendente(Cola<T> original) throws ColaVacia {
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
     * Punto de entrada público para ordenar los elementos de una cola de forma descendente
     * utilizando el algoritmo QuickSort adaptado para colas.
     *
     * @param <T>      tipo de los elementos contenidos en la cola; debe implementar {@link Comparable}
     * @param original la cola cuyos elementos se ordenarán de mayor a menor (se modifica en el lugar)
     * @throws ColaVacia si la cola se encuentra vacía o si ocurre un error al desencolar elementos
     */

    public static <T> void QuickSortDescendente(Cola<T> original) throws ColaVacia{
        ordenarQuickSortDescendente(original);
    }

    /**
     * Implementación recursiva interna del algoritmo QuickSort para ordenamiento descendente.
     * Selecciona el primer elemento como pivote, particiona los elementos restantes en dos
     * subcolas (mayores y menores o iguales al pivote), las ordena recursivamente y las reconcatena.
     *
     * @param <T>      tipo de los elementos; debe implementar {@link Comparable}
     * @param original la cola a ordenar en la llamada recursiva actual
     * @throws ColaVacia si ocurre un error al desencolar durante el proceso
     */
    private static <T> void ordenarQuickSortDescendente(Cola<T> original) throws ColaVacia {
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
     * Busca recursivamente la existencia de un elemento dentro de la cola sin destruir su estructura.
     * Extrae los elementos uno a uno comparándolos con el buscado y los vuelve a encolar
     * en el retorno de la pila recursiva para restaurar el estado original de la cola.
     *
     * @param <T>      tipo de los elementos contenidos en la cola
     * @param cola     la cola en la que se realizará la búsqueda
     * @param elemento el objeto a buscar dentro de la cola
     * @return {@code true} si el elemento fue encontrado; {@code false} en caso contrario
     * @throws ColaVacia si ocurre un error inesperado al operar con la cola
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
     * Obtiene de forma recursiva el último elemento (ubicado al final) de la cola sin destruirla.
     * Extrae elementos sucesivamente hasta llegar al final para identificar el último dato,
     * reencolando los elementos en el retorno de las llamadas recursivas para mantener el orden.
     *
     * @param <T>  tipo de los elementos de la cola
     * @param cola la cola de la que se desea obtener el último elemento
     * @return el elemento situado al final de la cola, o {@code null} si la cola está vacía
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
