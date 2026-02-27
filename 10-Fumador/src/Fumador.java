import java.util.List;

public class Fumador {

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

    public void compraTabac(){
        estanc.venTabac();
    }

    public void compraPaper(){
        estanc.venPaper();
    }

    public void compraLlumi(){
        estanc.venLlumi();
    }

    public void run(){
        
    }

    
    

}
