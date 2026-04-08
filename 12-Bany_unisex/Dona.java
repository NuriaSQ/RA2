public class Dona extends Thread {

    private String nom;
    private BanyUnisex lavabo;

    public Dona(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    @Override
    public void run() {
        lavabo.entraDona(nom);

        try {
            Thread.sleep((long) (2000 + Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lavabo.surtDona(nom);
        System.out.println(nom + " ha acabat d'usar el bany");
    }
}