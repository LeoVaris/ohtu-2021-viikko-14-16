package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {
    private static final Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto() {
        String siirto = tekoaly.annaSiirto();
        System.out.println(siirto);
        return siirto;
    }
}