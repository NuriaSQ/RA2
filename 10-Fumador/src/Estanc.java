import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {

    private List<Tabac> tabacs;
    private List<Llumi> llumins;
    private List<Paper> papers;
    private boolean obert;

    public Estanc() {
        tabacs = new ArrayList<>();
        llumins = new ArrayList<>();
        papers = new ArrayList<>();
        obert = true;
    }

    public void nouSubministrament(){
        Random random = new Random();
        int resultat = random.nextInt(3);

        switch(resultat){
            case 0:
                addTabac();
                break;

            case 1:
                addLlumi();
                break;

            case 2:
                addPaper();
                break;
        }
    }

    public synchronized void addTabac(){
        tabacs.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }

    public synchronized void addLlumi(){
        llumins.add(new Llumi());
        System.out.println("Afegint Llumi");
        notifyAll();
    }

    public synchronized void addPaper(){
        papers.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public synchronized Tabac venTabac() throws InterruptedException{
        while(tabacs.isEmpty()){
            wait();
        }
        return tabacs.remove(0);
    }

    public synchronized Paper venPaper() throws InterruptedException{
        while(papers.isEmpty()){
            wait();
        }
        return papers.remove(0);
    }

    public synchronized Llumi venLlumi() throws InterruptedException{
        while(llumins.isEmpty()){
            wait();
        }
        return llumins.remove(0);
    }

    public void tancarEstanc(){
        obert = false;
        System.out.println("Estanc tancat");
    }

    public void run(){
        System.out.println("Estanc obert");
        Random random = new Random();

        while(obert){
            nouSubministrament();

            try{
                Thread.sleep(500 + random.nextInt(1000));
            }catch(Exception e){}
        }
    }
}