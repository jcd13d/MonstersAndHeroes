import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HaMGame extends Game {
    public final static int MAX_HEROES = 5;
    public final static int MIN_HEROES = 1;
    private final static Map<String, int[]> moveMapping;
    static {
        moveMapping = new HashMap<>();
        moveMapping.put("w", new int[]{-1, 0});
        moveMapping.put("a", new int[]{0, -1});
        moveMapping.put("s", new int[]{1, 0});
        moveMapping.put("d", new int[]{0, 1});
    }
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

        boolean turnStatus;
    }

    private void gameLogic() {
        String turnInput;

        gameSetup();

        // do player turns (each move) until
        do {
            System.out.println(board);
            System.out.println(turnInputPrompt());
            turnInput = utils.getStringInput("Please enter your next move.",
                    new StringInListChecker(Arrays.asList("w", "a", "s", "d", "q", "i")));
            if (!playerTurn(turnInput)) {
                System.out.println("Invalid Move!");
            }
        } while (!turnInput.equalsIgnoreCase("q")); // TODO or lose condition?
    }

    private boolean playerTurn(String turnInput) {
        // one turn worth of logic
        if (turnInput.equalsIgnoreCase("q")) {
            return true;
        } else if (turnInput.equalsIgnoreCase("i")) {
            for (Hero hero : heroes) {
                hero.infoMenu();
            }
            return true;
        }
        return board.moveHeroes(destinationHelper(moveMapping.get(turnInput)));
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

    private int[] destinationHelper(int[] move) {
        int[] dest = new int[2];
        int[] curPos = board.getCurPlayerPos();
        dest[0] = curPos[0] + move[0];
        dest[1] = curPos[1] + move[1];
        return dest;
    }

    private String numPlayersPrompt() {
        return String.format("How many heroes would you like to play with? (integer between %s and %s)", MIN_HEROES, MAX_HEROES);
    }

    private String heroSelectionPrompt(int playerNum) {
        return String.format("Please select player number %s form the menu. Choose from characters 0 through %s.",
                playerNum, heroFactory.getNumHeroes());
    }

    private String turnInputPrompt() {
        String str = "";
        str = str + "w: Move Up\n";
        str = str + "a: Move Left\n";
        str = str + "s: Move Down\n";
        str = str + "d: Move Right\n";
        str = str + "q: Quit\n";
        str = str + "i: Show Information\n";
        return str;
    }

    public static void main(String[] args) {
        Game game = new HaMGame();
        game.playGame();
    }

}
