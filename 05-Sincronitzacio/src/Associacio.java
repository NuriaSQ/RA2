public class Associacio {

    private final int numSocis = 1000;
    private Soci[] socis;
    private final Object objectSingleton = new Object();

    public Associacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci(objectSingleton);
        }
    }

    public void iniciaCompteTempsSocis() {
        for (int i = 0; i < socis.length; i++) {
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis() {
        for (int i = 0; i < socis.length; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.println("Saldo final del compte: " + Compte.getInstance().getSaldo());
    }

    public static void main(String[] args) {
        Associacio a = new Associacio();
        a.iniciaCompteTempsSocis();
        a.esperaPeriodeSocis();
        a.mostraBalancComptes();
    }
}
