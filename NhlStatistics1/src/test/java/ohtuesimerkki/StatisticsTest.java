package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void testTeam() {
        List<Player> p = stats.team("PIT");
        assertEquals(1, p.size());
    }

    @Test
    public void testSearch() {
        Player p = stats.search("Kurri");
        assertEquals("Kurri", p.getName());

        p = stats.search("xxx");
        assertEquals(null, p);
    }

    @Test
    public void testTop() {
        List<Player> p = stats.topScorers(1);
        //assertEquals(1, p.size());
    }


}
