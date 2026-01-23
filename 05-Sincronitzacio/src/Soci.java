import java.util.Random;

public class Soci extends Thread {

    private Compte compte;
    private Object objectSingleton;
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private final int maxAnys = 10;
    private Random rnd;

    public Soci(Object objectSingleton) {
        this.compte = Compte.getInstance();
        this.objectSingleton = objectSingleton;
        this.rnd = new Random();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        int mesos = maxAnys * 12;

        for (int mes = 0; mes < mesos; mes++) {

            synchronized (objectSingleton) {
                if (mes % 2 == 0) compte.ingressar(aportacio);
                else compte.treure(aportacio);
            }

            try {
                Thread.sleep(rnd.nextInt(esperaMax));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
