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

}
