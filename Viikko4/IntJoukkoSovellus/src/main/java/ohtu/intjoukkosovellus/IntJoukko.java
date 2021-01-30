
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        Arrays.fill(ljono, 0);
        alkioidenLkm = 0;
        kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        Arrays.fill(ljono, 0);
        alkioidenLkm = 0;
        kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti on negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kasvatuskoko on negatiivinen");
        }
        ljono = new int[kapasiteetti];
        Arrays.fill(ljono, 0);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public void lisaa(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return;
        }
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == ljono.length) {
                int[] vanhaJono = ljono;
                kopioiTaulukko(ljono, vanhaJono);
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(vanhaJono, ljono);
            }
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public void poista(int luku) {
        int uusiKohta = 0;

        for (int i = 0; i < alkioidenLkm; ++i) {
            if (luku != ljono[i]) {
                ljono[uusiKohta] = ljono[i];
                uusiKohta++;
            }
        }
        alkioidenLkm = uusiKohta;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0)
            return "{}";
        StringBuilder jono = new StringBuilder("{");
        jono.append(ljono[0]);
        for (int i = 1; i < alkioidenLkm; ++i) {
            jono.append(", ").append(ljono[i]);
        }
        jono.append("}");
        return jono.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(ljono, 0, taulu, 0, taulu.length);
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int value : aTaulu) {
            x.lisaa(value);
        }
        for (int value : bTaulu) {
            x.lisaa(value);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int value : aTaulu) {
            for (int value2 : bTaulu) {
                if (value == value2) {
                    y.lisaa(value);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int value : aTaulu) {
            z.lisaa(value);
        }
        for (int value : bTaulu) {
            z.poista(value);
        }
 
        return z;
    }
        
}
