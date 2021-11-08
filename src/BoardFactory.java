import java.util.ArrayList;

// factory for creating baord
public class BoardFactory extends HaMFactory{
    public GameBoard getBoard(ArrayList<Hero> heroes) {
        return new GameBoard(heroes);
    }
}
