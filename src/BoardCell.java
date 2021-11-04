import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BoardCell {
    public static final double P_BLOCKED = .2;
    public static final double P_MARKET = .3;
    public static final double P_AVAILABLE = .5;
    private static final int DECIMAL_PLACE_RAND_NUM = 100;
    private static final String BLOCKED = "blocked";
    private static final String AVAILABLE = "available";
    private static final String MARKET = "market";

    private String boardState;
    private boolean playerCell;
    private ArrayList<Hero> heroes;

    public BoardCell() {
        double randNum = ThreadLocalRandom.current().nextInt(0, DECIMAL_PLACE_RAND_NUM) / (double) DECIMAL_PLACE_RAND_NUM;
        if (randNum < P_BLOCKED) {
            boardState = BLOCKED;
        } else if (randNum < P_MARKET + P_BLOCKED) {
            boardState = MARKET;
        } else if (randNum < P_AVAILABLE + P_MARKET + P_BLOCKED) {
            boardState = AVAILABLE;
        }
    }

    public boolean movePlayerToCell(ArrayList<Hero> heroes) {
        if (boardState.equalsIgnoreCase(BLOCKED)) {
            return false;
        } else if (boardState.equalsIgnoreCase(MARKET)) {
            // TODO send to market!
            return true;
        } else if (boardState.equalsIgnoreCase(AVAILABLE)) {
            // TODO players come into board space, probabilistically fight
            return true;
        } else {
            // will never get here!
            return false;
        }
    }

    @Override
    public String toString() {
        String str;
        if (boardState.equalsIgnoreCase(AVAILABLE)) {
            str =  " ";
        } else if (boardState.equalsIgnoreCase(MARKET)) {
            str =  "M";
        } else {
            str =  "X";
        }

        if (isPlayerCell()) {
            str = "H";
        }

        return str;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public boolean isPlayerCell() {
        return playerCell;
    }

    public void setPlayerCell(boolean playerCell) {
        this.playerCell = playerCell;
    }

    public String getBoardState() {
        return boardState;
    }

    public void setBoardState(String boardState) {
        this.boardState = boardState;
    }
}
