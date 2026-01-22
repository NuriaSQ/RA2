public class DormAleatori extends Thread {

    private long instantCreacio;

    public DormAleatori(String nom) {
        this.setName(nom);
        this.instantCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            int interval = (int)(Math.random() * 1000);

            long tempsTotal = System.currentTimeMillis() - instantCreacio;

            System.out.println(
                getName() + "(" + i + ") a dormir " +
                interval + "ms  total " + tempsTotal + "ms"
            );

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main ----------");
    }
}
