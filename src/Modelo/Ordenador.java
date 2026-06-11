package Modelo;

public class Ordenador<T>{

    public void ejecutarQuickSort(Cola<T> original) throws ColaVacia{
        ordenarQuickSort(original);
    }

    private void ordenarQuickSort(Cola<T> original) throws ColaVacia {
        T pivot = null;
        TadCola<T> menor =  new TadCola<>("Menor");
        TadCola<T> mayor =  new TadCola<>("Mayor");

        if(original.numElemCola() > 1) {
            pivot = original.desencolar();

            while (!(original.colaVacia())) {
                T elementoActual = original.desencolar();

                if (((Comparable<T>) elementoActual).compareTo(pivot) < 0) {
                    menor.encolar(elementoActual);
                } else {
                    mayor.encolar(elementoActual);
                }
            }


            ordenarQuickSort(menor);
            ordenarQuickSort(mayor);

            while (!menor.colaVacia()) {
                original.encolar(menor.desencolar());
            }

            original.encolar(pivot);

            while(!mayor.colaVacia()){
                original.encolar(mayor.desencolar());
            }

        }
    }
}
