package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KiviPaperiSakset {

    private static final TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String toisenSiirto() {
        String siirto = tekoaly.annaSiirto();
        System.out.println(siirto);
        return siirto;
    }
}
