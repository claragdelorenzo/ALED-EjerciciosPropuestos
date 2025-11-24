package aled.ejercicios.propuestos.tema3.filosofos;

public class Main {

	public static void main(String[] args) {
		Mesa m = new Mesa(5);

		for (int i = 0; i < m.getNumFilosofos(); i++)
			new Filosofo(m, i).start();

	}

}
