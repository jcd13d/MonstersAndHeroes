import com.sun.codemodel.internal.JForEach;

import java.util.ArrayList;
import java.util.HashMap;

public class HaMGame extends Game {
    public final static int MAX_HEROES = 5;
    public final static int MIN_HEROES = 1;
    int num_players;
    HeroFactory heroFactory;
    ArrayList<Hero> heroes;
    GameBoard board;

    public HaMGame() {
        setName("Heroes and Monsters");
        utils = new Utils();
        heroes = new ArrayList<>();
        heroFactory = new HeroFactory();
    }

    public void playGame() {
        // do game logic while the player does not quit
        gameLogic();
    }

    private void gameLogic() {

        // while still playing, other criteria? go through turns
    }

    private void playTurn() {
        gameSetup();
        // one turn worth of logic
    }

    private void gameSetup() {
        // setup game, num players etc
        num_players = utils.getIntInput(numPlayersPrompt(), new RangeChecker(MIN_HEROES, MAX_HEROES));
        System.out.println(num_players);

        int heroSelection;
        heroFactory.printPlayerMenu();
        for (int i=0; i < num_players; i++) {
            heroSelection = utils.getIntInput(heroSelectionPrompt(i), new RangeChecker(0, heroFactory.getNumHeroes() - 1));
            heroes.add(heroFactory.getHeroByIndex(heroSelection));
            System.out.printf("Selected: %s\n", heroes.get(i));
        }

        board = new GameBoard(heroes);
    }

    private String numPlayersPrompt() {
        return String.format("How many heroes would you like to play with? (integer between %s and %s)", MIN_HEROES, MAX_HEROES);
    }

    private String heroSelectionPrompt(int playerNum) {
        return String.format("Please select player number %s form the menu. Choose from characters 0 through %s.",
                playerNum, heroFactory.getNumHeroes());
    }

    public static void main(String[] args) {
        Game game = new HaMGame();
        game.playGame();
    }

}
