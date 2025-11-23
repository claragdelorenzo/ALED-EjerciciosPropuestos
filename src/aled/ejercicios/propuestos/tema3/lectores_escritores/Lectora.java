package aled.ejercicios.propuestos.tema3.lectores_escritores;

public class Lectora extends Thread {
    private final Monitor monitor;
    private final String nombre;

    public Lectora(Monitor monitor, String nombre) {
        this.monitor = monitor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // Intenta leer del recurso
            monitor.leer(nombre);
        } catch (InterruptedException e) {}
    }
}