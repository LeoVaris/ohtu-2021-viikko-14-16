package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
    private int before = 0;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka s) {
        super(tuloskentta, syotekentta, nollaa, undo, s);
    }

    @Override
    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception ignored) {
        }
        before = arvo;
        sovellus.miinus(arvo);

        super.yleinen();
    }

    @Override
    public void peru() {
        sovellus.plus(before);
        super.yleinen();
    }
}
