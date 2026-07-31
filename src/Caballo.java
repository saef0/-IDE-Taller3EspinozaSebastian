// Libreria random
import java.util.Random;
// Implementar Runnable, cada caballo estara en un hilo diferente
public class Caballo implements Runnable {

    // Atributos del caballo
    private String nombre;
    private int distanciaRecorrida;

    // Crea un random
    private Random random = new Random();

    // Datos de posicion
    private static int posicion = 0;
    private static String[] posiciones = new String[4];

    // Getter
    public static String[] getPosiciones() {
        return posiciones;
    }

    // Constructor
    public Caballo(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    // Sobreescribir run
    @Override
    public void run() {
        // El caballo avanza hasta los 100 metros
        while (distanciaRecorrida < 100) {
            // El avance es aleatorio del 1 al 10 y se suma a la distancia recorrida
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;
            // Si se pasa de los 100 se iguala a 100
            if (distanciaRecorrida > 100) {
                distanciaRecorrida = 100;
            }

            // Imprime el avance y la distancia recorrida
            System.out.println(nombre + " avanzo " + avance + " metros");
            System.out.println("Total de " + nombre + ": " + distanciaRecorrida + " metros");
            System.out.println("-----------------------");

            // Cuando llega a la meta se llama al metodo resultado
            if (distanciaRecorrida >= 100) {
                resultado(nombre);
            }
            // El caballo espera antes de avanzar
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("El hilo de " + nombre + " fue interrumpido.");
            }
        }
    }

    // Solo puede entrar un hilo a la vez, recibe el nombre del caballo
    private static synchronized void resultado(String nombre) {
        // Imprime las posiciones de los caballos dependiendo del valor de posicion
        if(posicion == 0) {
            System.out.println(nombre + " ha ganado la carrera");
        } else if (posicion == 1) {
            System.out.println(nombre + " ha quedado en el segundo lugar");
        } else if (posicion == 2) {
            System.out.println(nombre + " ha quedado en el tercer lugar");
        } else if (posicion == 3) {
            System.out.println(nombre + " ha quedado en el cuarto lugar");
        }

        // Agrega el caballo a la lsta en orden de llegada y luego suma 1 a la posicion
        posiciones[posicion] = nombre;
        posicion++;
    }
}