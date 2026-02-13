import java.util.Random;

public class Filosof extends Thread {

    int numero;
    Forquilla esquerra;
    Forquilla dreta;
    private int gana = 0;
    private Random random = new Random();

    public Filosof(int numero, Forquilla esquerra, Forquilla dreta) {
        this.numero = numero;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() {
        try {
            System.out.println("Filòsof: fil" + numero + " pensant");
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void menjar() {
        try {
            System.out.println("Filòsof: fil" + numero + " menja");
            Thread.sleep(1000 + random.nextInt(1000));
            System.out.println("Filòsof: fil" + numero + " ha acabat de menjar");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void agafarForquillaEsquerra() throws InterruptedException {
        synchronized (esquerra) {
            while (esquerra.getPropietari() != Forquilla.LLIURE) {
                esquerra.wait();
            }
            esquerra.setPropietari(numero);
            System.out.println("Filòsof: fil" + numero + " agafa la forquilla esquerra " + esquerra.getNumero());
        }
    }

    private boolean agafarForquillaDreta() {
        synchronized (dreta) {
            if (dreta.getPropietari() == Forquilla.LLIURE) {
                dreta.setPropietari(numero);
                System.out.println("Filòsof: fil" + numero + " agafa la forquilla dreta " + dreta.getNumero());
                return true;
            } else {
                return false;
            }
        }
    }

    private void deixarForquilles() {
        synchronized (esquerra) {
            esquerra.setPropietari(Forquilla.LLIURE);
            esquerra.notifyAll();
        }
        synchronized (dreta) {
            dreta.setPropietari(Forquilla.LLIURE);
            dreta.notifyAll();
        }
        System.out.println("Filòsof: fil" + numero + " deixa les forquilles");
    }

    private void deixarForquillaEsquerra() {
        synchronized (esquerra) {
            esquerra.setPropietari(Forquilla.LLIURE);
            esquerra.notifyAll();
            System.out.println("Filòsof: fil" + numero + " deixa la forquilla esquerra " + esquerra.getNumero());
        }
    }

    private void agafarForquilles() throws InterruptedException {
        boolean teLesDues = false;

        while (!teLesDues) {
            agafarForquillaEsquerra();

            if (agafarForquillaDreta()) {
                teLesDues = true;
            } else {
                deixarForquillaEsquerra();
                gana++;
                System.out.println("Filòsof: fil" + numero + " no pot menjar, gana=" + gana);
                Thread.sleep(500 + random.nextInt(500));
            }
        }
    }

    public void run() {
        while (true) {
            pensar();
            try {
                agafarForquilles();
                menjar();
                deixarForquilles();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
