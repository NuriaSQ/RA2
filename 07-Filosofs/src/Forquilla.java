public class Forquilla {
    private int numero;
    private boolean enUs = false;

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public boolean agafar() {
        if (!enUs) {
            enUs = true;
            return true;
        }
        return false;
    }

    public void deixar() {
        enUs = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEnUs() {
        return enUs;
    }
}
