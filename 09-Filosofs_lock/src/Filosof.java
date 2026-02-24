import java.util.Random;

public class Filosof extends Thread {

    private String nom;
    private long iniciGana;
    private long fiGana;
    private long gana;

    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;

    private Random random = new Random();

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
    }

    public void pensar() {
        try {
            iniciGana = System.currentTimeMillis();
            System.out.println(nom + " pensant");
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar();
    }

    public void agafarForquillaDreta() {
        forquillaDreta.agafar();
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
        System.out.println(nom + " té forquilles esq(" + forquillaEsquerra.getNum() + ") dreta(" + forquillaDreta.getNum() + ")");
    }

    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.println(nom + " deixa les forquilles");
    }

    public void menjar() {
        try {
            agafarForquilles();
            fiGana = System.currentTimeMillis();
            calcularGana();
            System.out.println(nom + " menja amb gana " + gana);
            Thread.sleep(1000 + random.nextInt(1000));
            System.out.println(nom + " ha acabat de menjar");
            resetGana();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            deixarForquilles();
        }
    }

    public long calcularGana() {
        gana = (fiGana - iniciGana) / 1000;
        return gana;
    }

    public void resetGana() {
        iniciGana = 0;
        gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }
}