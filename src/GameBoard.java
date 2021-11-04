import java.util.Arrays;

public class GameBoard {
    private static final int DEFAULT_BOARD_SIZE = 8;
    private int boardRows;
    private int boardCols;
    private BoardCell[][] board;
    private int[] currentPlayerPosition;

    public GameBoard() {
        this(DEFAULT_BOARD_SIZE, DEFAULT_BOARD_SIZE);
    }

    public GameBoard(int boardSize) {
        this(boardSize, boardSize);
    }

    public GameBoard(int boardRows, int boardCols) {
        setBoardCols(boardCols);
        setBoardRows(boardRows);
        board = new BoardCell[boardRows][boardCols];
        currentPlayerPosition = new int[] {0, 0};
        for (int i=0; i < boardRows; i++) {
            for (int j = 0; j < boardCols; j++) {
                board[i][j] = new BoardCell();
                if ((i == currentPlayerPosition[0]) & (j == currentPlayerPosition[1])) {
                    board[i][j].setPlayerCell(true);
                }
            }
        }
    }

    public int getBoardRows() {
        return boardRows;
    }

    public void setBoardRows(int boardRows) {
        this.boardRows = boardRows;
    }

    public int getBoardCols() {
        return boardCols;
    }

    public void setBoardCols(int boardCols) {
        this.boardCols = boardCols;
    }

    private String hBar() {
        return "|-------";
    }

    private String cBody(String fill) {
        return String.format("|   %s   ", fill);
    }

    @Override
    public String toString() {
        int cellHeight = 1;
        StringBuilder str = new StringBuilder();
        for (int i=0; i < boardRows; i++) {
            for (int k = 0; k <= cellHeight; k++) {
                for (int j = 0; j < boardCols; j++) {
                    if (k == 0) {
                        str.append(hBar());
                    } else {
                        str.append(cBody(board[i][j].toString()));
                    }
                }
                str.append("|\n");
            }
        }
        for (int i=0; i < boardRows; i++) {
            str.append(hBar());
        }
        str.append("|\n");
        return str.toString();
    }

    public static void main(String[] args) {
        GameBoard brd = new GameBoard();
        System.out.println(brd);
    }

}
