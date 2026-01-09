public class PrincipalEstricte {

    public static void main(String[] args) {

        Fil pepe = new Fil("Pepe", 10, true);
        Fil juan = new Fil("Juan", 10, false);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}
