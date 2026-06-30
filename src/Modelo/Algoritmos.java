package Modelo;

public class Algoritmos {

    public static <T> void ejecutarQuickSortAscendente(Cola<T> original) throws ColaVacia{
        ordenarQuickSortAscendente(original);
    }

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

    public static <T> void ejecutarQuickSortDescendente(Cola<T> original) throws ColaVacia{
        ordenarQuickSortDescendente(original);
    }

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

}
