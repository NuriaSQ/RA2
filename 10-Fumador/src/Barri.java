public class Barri {

    private Estanc estanc;
    private Fumador[] fumadors = new Fumador[3];

    public Barri(){
        estanc = new Estanc();

        for(int i=0;i<3;i++){
            fumadors[i] = new Fumador(i, estanc);
        }

        estanc.start();

        for(int i=0;i<3;i++){
            fumadors[i].start();
        }

        for(int i=0;i<3;i++){
            try{
                fumadors[i].join();
            }catch(Exception e){}
        }

        estanc.tancarEstanc();
    }

    public static void main(String[] args) {
        new Barri();
    }
}