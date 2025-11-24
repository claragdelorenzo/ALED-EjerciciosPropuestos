package aled.ejercicios.propuestos.tema3.filosofos;

public class Filosofo extends Thread {

	private Mesa mesa;
	private int asiento;

	public Filosofo(Mesa mesa, int asiento) {
		this.mesa = mesa;
		this.asiento = asiento;
	}

	@Override
	public void run() {
		try {
			// Empieza a comer
			mesa.comer(this.asiento);
			// Comiendo...
			Thread.sleep(1000);
			pensandoEnComer();

			// Deja de comer
			mesa.dejarDeComer(this.asiento);
			// Dejando de comer...
			Thread.sleep(1000);

		} catch (InterruptedException e) {
		}
	}
	
	public void pensandoEnComer() {
		
		// Mientras come, el filosofo piensa...
		try {
            System.out.println("Filósofo en el asiento " + (asiento) + " está pensando mientras come.");
            Thread.sleep((int) (Math.random() * 5000));  // Pensando entre 0 y 5 segundos
        } catch (InterruptedException e) {
        }
		
	}
}
