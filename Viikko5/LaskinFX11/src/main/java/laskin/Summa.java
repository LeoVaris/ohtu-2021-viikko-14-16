package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    private int before = 0;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka s) {
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
        sovellus.plus(arvo);

        super.yleinen();
    }

    @Override
    public void peru() {
        sovellus.miinus(before);
        super.yleinen();
    }
}
