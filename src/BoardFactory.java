import java.util.ArrayList;

public class BoardFactory extends HaMFactory{
    public GameBoard getBoard(ArrayList<Hero> heroes) {
        return new GameBoard(heroes);
    }
}
