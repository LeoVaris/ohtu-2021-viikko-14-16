package ohtu.kivipaperisakset;

public class KPSPeli {
    private KPSPeli() {

    }

    private KiviPaperiSakset peli;

    public static void pelaa(int type) {
        if (type == 0) {
            new KPSPelaajaVsPelaaja().pelaa();
        } else if (type == 1) {
            new KPSTekoaly().pelaa();
        } else {
            new KPSParempiTekoaly().pelaa();
        }
    }
}
