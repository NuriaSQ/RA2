public class Administracio {

    private final int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    public Administracio() {
        poblacio_activa = new Treballador[num_poblacio_activa];

        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador(25000f,20,65,"Ciutadà-" + i);
        }
    }

    public void iniciar() {

        for (int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i].start();
        }

        for (int i = 0; i < poblacio_activa.length; i++) {
            try {
                poblacio_activa[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < poblacio_activa.length; i++) {
            Treballador t = poblacio_activa[i];
            System.out.printf("%s -> edat: %d / total: %.2f%n",
                    t.getName(), t.getEdat(), t.getCobrat());
        }
    }

    public static void main(String[] args) {
        Administracio adm = new Administracio();
        adm.iniciar();
    }
}
