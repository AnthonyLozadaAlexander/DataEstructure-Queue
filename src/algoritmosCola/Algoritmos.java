package algoritmosCola;

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

    public static <T> void quickSortAscendente(Cola<T> original) throws ColaVacia {
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
        TadCola<T> menor = new TadCola<>("Menor");
        TadCola<T> mayor = new TadCola<>("Mayor");

        if (original.numElemCola() > 1) {
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

            while (!mayor.colaVacia()) {
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

    public static <T> void quickSortDescendente(Cola<T> original) throws ColaVacia {
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
        TadCola<T> menor = new TadCola<>("Menor");
        TadCola<T> mayor = new TadCola<>("Mayor");

        if (original.numElemCola() > 1) {
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

            while (!menor.colaVacia()) {
                original.encolar(menor.desencolar());
            }

        }
    }


    /**
     * Busca un elemento dentro de la cola de forma recursiva sin destruirla.
     * Delega la búsqueda al método recursivo {@link #buscarR} y restaura
     * el orden original de la cola mediante {@code invertirCola()} al finalizar.
     *
     * @param <T>      tipo de los elementos de la cola
     * @param cola     la cola en la que se realizará la búsqueda
     * @param elemento el elemento a buscar dentro de la cola
     * @return {@code true} si el elemento existe en la cola; {@code false} en caso contrario
     */
    public static <T> boolean buscar(Cola<T> cola, T elemento) {
        boolean encontrado = false;
        if (!cola.colaVacia()) {
            encontrado = buscarR(cola, elemento);
            cola.invertirCola(); // restaurar el orden original de la cola
        }

        return encontrado;

    }

    /**
     * Método recursivo interno que recorre la cola desencolando elementos uno a uno
     * y comparándolos con el elemento buscado. Restaura cada elemento en la cola
     * al retornar de la recursión.
     *
     * @param <T>      tipo de los elementos de la cola
     * @param cola     la cola que se recorre recursivamente
     * @param elemento el elemento a buscar
     * @return {@code true} si el elemento fue encontrado; {@code false} en caso contrario
     */
    private static <T> boolean buscarR(Cola<T> cola, T elemento) {
        boolean encontrado = false;
        try {
            if (cola.colaVacia()) {
                encontrado = false;
            } else {
                T dato = cola.desencolar();
                if (dato.equals(elemento)) { // encontro el elemento
                    encontrado = true;
                } else {
                    encontrado = buscarR(cola, elemento);
                }

                cola.encolar(dato); // restaurar cola
            }

        } catch (ColaVacia e) {
        }

        return encontrado;
    }

    /**
     * Obtiene de forma recursiva el último elemento (ubicado al final) de la cola
     * sin destruirla.
     * Extrae elementos sucesivamente hasta llegar al final para identificar el
     * último dato,
     * reencolando los elementos en el retorno de las llamadas recursivas para
     * mantener el orden.
     *
     * @param <T>  tipo de los elementos de la cola
     * @param cola la cola de la que se desea obtener el último elemento
     * @return el elemento situado al final de la cola, o {@code null} si la cola
     * está vacía
     * @throws ColaVacia si ocurre un error al desencolar elementos
     */

    public static <T> T ultimoElemento(Cola<T> cola) throws ColaVacia {
        T ultimo = null;
        if (!cola.colaVacia()) {
            ultimo = ultimoElementoR(cola);
            cola.invertirCola();
        }

        return ultimo;
    }

    /**
     * Método recursivo interno que recorre la cola desencolando elementos hasta
     * encontrar el último (cuando la cola queda vacía tras desencolar).
     * Restaura cada elemento reencolándolo en el retorno de la recursión
     * para mantener la cola intacta.
     *
     * @param <T>  tipo de los elementos de la cola
     * @param cola la cola que se recorre recursivamente
     * @return el último elemento de la cola
     * @throws ColaVacia si ocurre un error al desencolar elementos
     */
    private static <T> T ultimoElementoR(Cola<T> cola) throws ColaVacia {
        T ultimoElemento = null;
        T guardar = null;

        if (!cola.colaVacia()) {
            guardar = cola.desencolar();
            ultimoElemento = ultimoElementoR(cola);
            if (cola.colaVacia()) {
                ultimoElemento = guardar;
            }
            cola.encolar(guardar); // restaurar cola
        }

        return ultimoElemento;
    }
}
