package aled.ejercicios.propuestos.tema3.filosofos;

public class Mesa {

	private final boolean[] tenedores;
	private final int numFilosofos;

	// Constructor de la mesa (monitor)
	public Mesa(int numFilosofos) {
		this.numFilosofos = numFilosofos;
		tenedores = new boolean[numFilosofos];

		// Al principio todos los tenedores estan liberados
		for (int i = 0; i < numFilosofos; i++)
			tenedores[i] = false;

	}

	public boolean[] getTenedores() {
		return tenedores;
	}

	public int getNumFilosofos() {
		return numFilosofos;
	}

	// Método para simular que un filósofo come (sincronización en los tenedores)
	public synchronized void comer(int asiento) throws InterruptedException {

		while (tenedores[asiento] || tenedores[(asiento + 1) % numFilosofos]) {
			System.out.println("Filósofo en el asiento " + (asiento) + " está esperando a comer.");
			wait();
		}

		// Empieza a comer
		System.out.println("Filósofo en el asiento " + (asiento) + " ha cogido el tenedor izquierdo.");
		tenedores[asiento] = true;
		System.out.println("Filósofo en el asiento  " + (asiento) + " ha cogido el tenedor derecho y está comiendo.");
		tenedores[(asiento + 1) % numFilosofos] = true;

	}

	// Metodo para que un filosofo deje de comer
	public synchronized void dejarDeComer(int asiento) throws InterruptedException {

		// Deja de comer
		System.out.println("Filósofo en el asiento " + (asiento) + " ha dejado el tenedor izquierdo.");
		tenedores[asiento] = false;

		System.out
				.println("Filósofo en el asiento " + (asiento) + " ha dejado el tenedor derecho y ha parado de comer");
		tenedores[(asiento + 1) % numFilosofos] = false;

		notifyAll();
	}

}
