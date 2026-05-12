package Modelo;

public interface Cola <T> {
	
	void encolar(T dato);
	T desencolar();
	void buscarCola(T dato);
	void mostrarCola();
	void eliminarCola();
	void invertirCola();
	void quitarPrimeroCola();

}
