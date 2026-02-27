import java.util.List;
import java.util.Random;

public class Estanc {

    private List<Tabac> tabacs;
    private List<Llumi> llumins;
    private List<Paper> papers;

    public void nouSubministrament(){
        int maxNum = 3;
        int minNum = 1;
        Random random = new Random();
        int resultat = random.nextInt(maxNum - minNum + 1);

        switch(resultat){
            case 1: 
                addTabac();
                break;

            case 2: 
                addLlumi();
                break;
            case 3:
                addPaper();
                break;
        }
    }

    public void addTabac(){
        Tabac tabac = new Tabac();
        tabacs.add(tabac);
    }

    public void addLlumi(){
        Llumi llumi = new Llumi();
        llumins.add(llumi);
    }

    public void addPaper(){
        Paper paper = new Paper();
        papers.add(paper);
    }

    public List<Tabac> venTabac(){
        tabacs.remove(tabacs.size() - 1);
        return tabacs;
    }

    public List<Paper> venPaper(){
        papers.remove(papers.size() - 1);
        return papers;
    }

    public List<Llumi> venLlumi(){
        llumins.remove(llumins.size() - 1);
        return llumins;
    }

    public void tancarEstanc(){
        
    }

    public void run(){
        
    }
}
