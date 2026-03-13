import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    public Queue<Client> salaEspera;
    private int maxCadires;
    public Object condBarber;
    private static Barberia instance;

    public Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        this.salaEspera = new LinkedList<>();
        this.condBarber = new Object();
        instance = this;
    }

    public static Barberia getInstance() {
        return instance;
    }

    public Client seguentClient() {
        synchronized (salaEspera) {
            return salaEspera.poll();
        }
    }

    public void entrarClient(Client client) {
        synchronized (salaEspera) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client);
                System.out.println("Client " + client.getNombre() + " en espera");
                synchronized (condBarber) {
                    condBarber.notify();
                }
            } else {
                System.out.println("No queden cadires, client " + client.getNombre() + " se'n va");
            }
        }
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Barberia barberia = new Barberia(3);
        Barber barber = new Barber("Pepe");
        barber.start();
        barberia.run();
    }
}