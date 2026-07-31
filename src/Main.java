public class Main {
    public static void main(String[] args) {
        Caballo caballo1 = new Caballo("Tormenta China");
        Caballo caballo2 = new Caballo("Tiro Al Blanco");
        Caballo caballo3 = new Caballo("Spirit");
        Caballo caballo4 = new Caballo("Epona");

        Thread hilo1 = new Thread(caballo1);
        Thread hilo2 = new Thread(caballo2);
        Thread hilo3 = new Thread(caballo3);
        Thread hilo4 = new Thread(caballo4);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------");
        System.out.println("| Posiciones finales");
        String[] posiciones = Caballo.getPosiciones();
        for (int i = 0; i < posiciones.length; i++) {
            System.out.println("| " + (i + 1) + "° lugar: " + posiciones[i]);
        }
        System.out.println("--------------------------");
        System.out.println("| La carrera ha terminado");
    }
}