import java.util.Random;

public class Client {
    private String nombre;

    public Client(int id) {
        this.nombre = "Client-" + id;
    }

    public void tallarseElCabell() {
        try {
            double tiempo = 0.9 + new Random().nextDouble() * 0.1;
            Thread.sleep((long)(tiempo * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNombre() {
        return nombre;
    }
}