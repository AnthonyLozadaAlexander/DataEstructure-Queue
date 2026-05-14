package Modelo;

public class tadCola <T> implements Cola <T> {

	// Punteros Principio y Fin
	private NodoCola<T> principio;
	private NodoCola<T> fin;
	private String nombre;
	
	public tadCola(String nombre) {
		super();
		this.nombre = "";
		T principio = null;
		T fin = null;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	@Override
	public void encolar(T dato) {
		NodoCola aux;
		aux = new NodoCola(dato, null);
		if(principio == null) { // si el puntero apunta a null, por lo tanto esta vacio y entonces 
			principio = aux;    // el puntero principio apunta a la referencia de aux con el nuevo dato
			fin = aux;
		}else {
			fin.siguiente = aux;
			fin = aux;
		}
		
	}

	@Override
	public T desencolar() {
		
		return null;
	}

	@Override
	public void buscarCola(T dato) {
		
		
	}

	@Override
	public void mostrarCola() {
		
		
	}

	@Override
	public void eliminarCola() {
		
		
	}

	@Override
	public void invertirCola() {
		
		
	}

	@Override
	public void quitarPrimeroCola() {
		
		
	}

}
