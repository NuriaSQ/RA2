public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private int id;
    private boolean teOrdre = false;

    public Motor(int id) {
        this.id = id;
    }

    public synchronized void setPotencia(int p) {
        potenciaObjectiu = p;
        teOrdre = true;
        notify();
    }

    public void run() {
        while (true) {

            synchronized (this) {
                if (potenciaActual == potenciaObjectiu) {

                    if (teOrdre) {
                        System.out.println("Motor " + id + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    }

                    if (teOrdre && potenciaObjectiu == 0) return;

                    try { wait(); }
                    catch (Exception e) {}
                }
            }

            while (potenciaActual != potenciaObjectiu) {

                try { Thread.sleep((int)(Math.random() * 300)); }
                catch (Exception e) {}

                if (potenciaActual < potenciaObjectiu) {
                    System.out.println("Motor " + id + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    potenciaActual++;
                } else {
                    System.out.println("Motor " + id + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    potenciaActual--;
                }

                try { Thread.sleep(1000 + (int)(Math.random() * 1000)); }
                catch (Exception e) {}
            }
        }
    }
}
