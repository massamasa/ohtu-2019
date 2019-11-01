package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void findsPlayer() {
        Player player = stats.search("Gretzky");
        assertEquals("Gretzky", player.getName());
    }

    @Test
    public void returnsNullIfNoSuchPlayer() {
        Player player = stats.search("Luukkainen");
        assertEquals(null, player);
    }
    
    @Test
    public void findsCorrectTeam(){
        List<Player> team = stats.team("DET");
        assertEquals("Yzerman", team.get(0).getName());
    }
    
    @Test
    public void listsAllTopScorersInCorrectOrder(){
        List<Player> topScorers = stats.topScorers(4);
        topScorers.forEach(pl ->System.out.println(pl));
        assertEquals("Gretzky", topScorers.get(0).getName());
        assertEquals("Lemieux", topScorers.get(1).getName());
        assertEquals("Yzerman", topScorers.get(2).getName());
        assertEquals("Kurri", topScorers.get(3).getName());
        assertEquals("Semenko", topScorers.get(4).getName());
    }
    

}
