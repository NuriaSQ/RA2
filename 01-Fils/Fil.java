public class Fil extends Thread {

    private String nom;
    private int limitRepeticions;

    public Fil(String nom, int limitRepeticions) {
        this.nom = nom;
        this.limitRepeticions = limitRepeticions;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limitRepeticions; i++) {

            for (int j = 0; j < 1000; j++) {
                int num = j * j;
            }

            System.out.println(nom + " " + i);
        }
        System.out.println("Acaba el fil de " + nom);
    }
}


