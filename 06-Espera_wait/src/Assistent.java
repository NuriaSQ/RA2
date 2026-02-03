public class Assistent extends Thread {

    private String nom;
    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment e) {
        this.nom = nom;
        this.esdeveniment = e;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        while (true) {

            double accio = Math.random();

            if (accio < 0.3) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }

            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
    }
}
