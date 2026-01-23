public class Compte {
    private float saldo;
    private static Compte instancia;

    private Compte() {
        saldo = 0f;
    }

    public static synchronized Compte getInstance() {
        if (instancia == null) instancia = new Compte();
        return instancia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void ingressar(float quantitat) {
        saldo += quantitat;
    }

    public void treure(float quantitat) {
        saldo -= quantitat;
    }
}
