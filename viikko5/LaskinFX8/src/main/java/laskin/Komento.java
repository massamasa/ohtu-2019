package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    protected TextField tulosKentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tulosKentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        operaatio(arvo);
        int laskunTulos = sovellus.tulos();
        asetaTulos(laskunTulos);
        undo.disableProperty().set(false);
    }

    protected abstract void operaatio(int arvo);

    void peru() {
        int aiempiTulos = sovellus.aiempiTulos();
        
        asetaTulos(aiempiTulos);
        undo.disableProperty().set(true);
    }

    private void asetaTulos(int laskunTulos) {
        syotekentta.setText("");
        tulosKentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }

}
