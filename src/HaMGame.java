import java.util.HashMap;

public class HaMGame extends Game {
    public final static int MAX_HEROES = 5;
    public final static int MIN_HEROES = 1;

    public HaMGame() {
        setName("Heroes and Monsters");
        utils = new Utils();
    }

    public void playGame() {
        // do game logic while the player does not quit
        gameLogic();
    }

    private void gameLogic() {
        // setup game, num players etc
        int num_players = utils.getIntInput(numPlayersPrompt(), new RangeChecker(MIN_HEROES, MAX_HEROES));
        System.out.println(num_players);

        // while still playing, other criteria? go through turns
    }

    private void playTurn() {
        // one turn worth of logic
    }

    private String numPlayersPrompt() {
        return String.format("How many heroes would you like to play with? (integer between %s and %s)", MIN_HEROES, MAX_HEROES);
    }

    public static void main(String[] args) {
        Game game = new HaMGame();
        game.playGame();
    }

}
