public class Fil extends Thread {

    private String nom;
    private int limitRepeticions;

    private static Object control = new Object();
    private static boolean tornPepe = true;

    private boolean estricte = false;
    private boolean esPepe;

    public Fil(String nom, int limitRepeticions) {
        this.nom = nom;
        this.limitRepeticions = limitRepeticions;
    }

    public Fil(String nom, int limitRepeticions, boolean esPepe) {
        this.nom = nom;
        this.limitRepeticions = limitRepeticions;
        this.esPepe = esPepe;
        this.estricte = true;
    }

    @Override
    public void run() {

        for (int i = 1; i <= limitRepeticions; i++) {

            for (int j = 0; j < 1000; j++) {
                int num = j * j;
            }

            if (estricte) {
                synchronized (control) {
                    while (tornPepe != esPepe) {
                        try {
                            control.wait();
                        } catch (InterruptedException e) {}
                    }

                    System.out.println(nom + " " + i);

                    tornPepe = !tornPepe;
                    control.notifyAll();
                }
            } else {
                System.out.println(nom + " " + i);
            }
        }

        System.out.println("Acaba thread de " + nom);
    }
}

