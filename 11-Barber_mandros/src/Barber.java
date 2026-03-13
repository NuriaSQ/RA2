public class Barber extends Thread {
    private String nombre;

    public Barber(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        while (true) {
            Client client = Barberia.getInstance().seguentClient();
            if (client != null) {
                System.out.println("Li toca al client " + client.getNombre());
                System.out.println("Tallant cabell a " + client.getNombre());
                client.tallarseElCabell();
            } else {
                synchronized (Barberia.getInstance().condBarber) {
                    try {
                        if (Barberia.getInstance().salaEspera.isEmpty()) {
                            System.out.println("Ningú en espera");
                        }
                        System.out.println("Barber " + nombre + " dormint");
                        Barberia.getInstance().condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}