package src;
public class Futbolista extends Thread {

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }
    }

    public int getNgols() { return ngols; }
    public int getNtirades() { return ntirades; }

    public static void main(String[] args) {

        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbapé"
        };

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        System.out.println("Inici dels xuts -----------------------");

        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(noms[i]);
            jugadors[i].start();
        }

        for (int i = 0; i < NUM_JUGADORS; i++) {
            try { jugadors[i].join(); } catch (InterruptedException e) {}
        }

        System.out.println("Fi dels xuts --------------------------");
        System.out.println("---- Estadistiques ----");

        for (int i = 0; i < NUM_JUGADORS; i++) {
            System.out.printf("%-10s -> %2d gols%n",
                    jugadors[i].getName(),
                    jugadors[i].getNgols());
        }
    }
}
