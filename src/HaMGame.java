import java.util.HashMap;

public class HaMGame extends Game {

    public HaMGame() {
        setName("Heroes and Monsters");
        utils = new Utils();
    }

    public void playGame() {
        // do game logic while the player does not quit

    }

    private void gameLogic() {
        // setup game, num players etc
        int num_players = utils.getIntInput(numPlayersPrompt(), new RangeChecker());

        // while still playing, other criteria? go through turns
    }

    private void playTurn() {
        // one turn worth of logic
    }

    private String numPlayersPrompt() {
        return "How many heroes would you like to play with?";
    }

    public static void main(String[] args) {
        Game game = new HaMGame();
        game.playGame();
    }

}
