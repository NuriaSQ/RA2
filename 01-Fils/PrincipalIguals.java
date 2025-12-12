public class PrincipalIguals {

    public static void main(String[] args) {

        Fil juan = new Fil("Juan", 10);
        Fil pepe = new Fil("Pepe", 10);

        juan.setPriority(Thread.MAX_PRIORITY);
        pepe.setPriority(Thread.MAX_PRIORITY);

        juan.start();
        pepe.start();

        System.out.println("Acaba thread main");
    }
}
