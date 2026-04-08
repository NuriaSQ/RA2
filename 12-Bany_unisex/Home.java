public class Home extends Thread {

    private String nom;
    private BanyUnisex lavabo;

    public Home(String nom, BanyUnisex lavabo) {
        this.nom = nom;
        this.lavabo = lavabo;
    }

    @Override
    public void run() {
        lavabo.entraHome(nom);

        try {
            Thread.sleep((long) (1000 + Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lavabo.surtHome(nom);
        System.out.println(nom + " ha acabat d'usar el bany");
    }
}