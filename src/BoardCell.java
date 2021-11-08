import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BoardCell {
    public static final double P_BLOCKED = .2;
    public static final double P_MARKET = .3;
    public static final double P_AVAILABLE = .5;
    public static final double P_FIGHT = .5;
    private static final int DECIMAL_PLACE_RAND_NUM = 100;
    public static final String BLOCKED = "blocked";
    public static final String AVAILABLE = "available";
    public static final String MARKET = "market";

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
            System.out.println("You are in a market!");
            Market market = new Market();
            market.marketMenus(heroes);
            return true;
        } else if (boardState.equalsIgnoreCase(AVAILABLE)) {
            // TODO players come into board space, probabilistically fight
            double randNum = ThreadLocalRandom.current().nextInt(0, DECIMAL_PLACE_RAND_NUM) / (double) DECIMAL_PLACE_RAND_NUM;
            if (randNum < P_FIGHT) {
                Fight fight = new Fight(heroes);
                fight.fight();
            }
            System.out.println("We are in empty space");
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

    public void removeHeroes() {
        this.heroes = null;
        setPlayerCell(false);
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
