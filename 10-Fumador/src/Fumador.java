public class Fumador extends Thread {

    private int id;
    private Estanc estanc;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int numFumades;

    public Fumador(int id, Estanc estanc) {
        this.id = id;
        this.estanc = estanc;
    }

    public void compraTabac() throws InterruptedException{
    System.out.println("Fumador " + id + " comprant Tabac");
    tabac = estanc.venTabac();
    }

    public void compraPaper() throws InterruptedException{
        System.out.println("Fumador " + id + " comprant Paper");
        paper = estanc.venPaper();
    }

    public void compraLlumi() throws InterruptedException{
        System.out.println("Fumador " + id + " comprant Llumi");
        llumi = estanc.venLlumi();
    }

    public void fuma() throws InterruptedException{
        if(tabac != null && paper != null && llumi != null){
            System.out.println("Fumador " + id + " fumant");
            Thread.sleep(500 + (int)(Math.random()*500));
            numFumades++;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
            tabac = null;
            paper = null;
            llumi = null;
        }
    }

    public void run(){
        while(numFumades < 3){
            try{
                compraTabac();
                compraPaper();
                compraLlumi();
                fuma();
            }catch(Exception e){}
        }
    }
}
