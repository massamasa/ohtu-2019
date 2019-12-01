package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
    private int aiempi;
 
    public void plus(int luku) {
        aiempi = tulos;
        tulos += luku;
    }
     
    public void miinus(int luku) {
        aiempi = tulos;
        tulos -= luku;
    }
 
    public void nollaa() {
        aiempi = tulos;
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
    
    public int aiempiTulos(){
        tulos = aiempi;
        return tulos;
    }
}