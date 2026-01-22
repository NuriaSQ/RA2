import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error de valor");
            return;
        }
        System.out.println("Passant a potència " + p);
        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }

        Scanner sc = new Scanner(System.in);
        int p = -1;

        while (p != 0) {
            p = sc.nextInt();
            passaAPotencia(p);
        }

        sc.close();
    }

    public static void main(String[] args) {
        Coet c = new Coet();
        c.arranca();
    }
}
