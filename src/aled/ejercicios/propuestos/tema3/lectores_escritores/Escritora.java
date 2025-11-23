package aled.ejercicios.propuestos.tema3.lectores_escritores;

public class Escritora extends Thread {
    private final Monitor monitor;
    private final String nombre;

    public Escritora(Monitor monitor, String nombre) {
        this.monitor= monitor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // Intenta escribir en el recurso
            monitor.escribir(nombre);
        } catch (InterruptedException e) {}
    }
}