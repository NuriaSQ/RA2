public class Filosof implements Runnable {

    private String nom;
    private Forquilla esquerra;
    private Forquilla dreta;
    private int gana = 0;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() {
        try {
            System.out.println("Filòsof: " + nom + " pensant");
            Thread.sleep(1000 + (int)(Math.random() * 1000));
        } catch (InterruptedException e) {}
    }

    private void menjar() {
        try {
            System.out.println("Filòsof: " + nom + " menja");
            Thread.sleep(1000 + (int)(Math.random() * 1000));
        } catch (InterruptedException e) {}
    }

    @Override
    public void run() {
        while (true) {

            pensar();
            gana++;

            boolean teEsq = esquerra.agafar();
            if (teEsq) {
                System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + esquerra.getNumero());

                boolean teDreta = dreta.agafar();
                if (teDreta) {
                    System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + dreta.getNumero());
                    menjar();
                    System.out.println("Filòsof: " + nom + " ha acabat de menjar");
                    esquerra.deixar();
                    dreta.deixar();
                } else {
                    System.out.println("Filòsof: " + nom + " deixa l'esquerra (" + esquerra.getNumero() + ") i espera (dreta ocupada)");
                    esquerra.deixar();
                    System.out.println("Filòsof: " + nom + " gana=" + gana);
                    try {
                        Thread.sleep(500 + (int)(Math.random() * 500));
                    } catch (InterruptedException e) {}
                }

            } else {
                try {
                    Thread.sleep(500 + (int)(Math.random() * 500));
                } catch (InterruptedException e) {}
            }
        }
    }
}
