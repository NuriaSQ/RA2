public class Taula {

    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int num) {

        filosofs = new Filosof[num];
        forquilles = new Forquilla[num];

        for (int i = 0; i < num; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < num; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % num];
            filosofs[i] = new Filosof(i, esquerra, dreta);
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal: fil" + i +
                    " esq:" + filosofs[i].esquerra.getNumero() +
                    " dret:" + filosofs[i].dreta.getNumero());
        }
        System.out.println("-------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }

    public static void main(String[] args) {
        Taula t = new Taula(4);
        t.showTaula();
        t.cridarATaula();
    }
}
