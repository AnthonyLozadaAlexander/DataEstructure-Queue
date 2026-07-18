package tadCola;

public class NodoCola <T>{
	
	T dato;
	NodoCola<T> siguiente; // puntero
	
	NodoCola (T elemento, NodoCola n){
		dato = elemento;
		siguiente = n;
	}
}
