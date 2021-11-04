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
        do {
            initBoard();
        } while(!canPlayersMove());
    }

    private void initBoard() {
        for (int i=0; i < boardRows; i++) {
            for (int j = 0; j < boardCols; j++) {
                board[i][j] = new BoardCell();
                if ((i == currentPlayerPosition[0]) & (j == currentPlayerPosition[1])) {
                    board[i][j].setPlayerCell(true);
                }
            }
        }
    }

    private boolean canPlayersMove() {
        if (rowInBoard(currentPlayerPosition[0] - 1)) {
            if (!board[currentPlayerPosition[0] - 1][currentPlayerPosition[1]].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
                return true;
            }
            // check cell to right if in board, if this cell is dest, true
        } else if (rowInBoard(currentPlayerPosition[0] + 1)) {
            if (!board[currentPlayerPosition[0] + 1][currentPlayerPosition[1]].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
                return true;
            }
            // check cell below if in board, if this cell is dest, true
        } else if (colInBoard(currentPlayerPosition[1] - 1)) {
            if (!board[currentPlayerPosition[0]][currentPlayerPosition[1] - 1].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
                return true;
            }
            // check cell above if in board, if this cell is dest, true
        } else if (colInBoard(currentPlayerPosition[1] + 1)) {
            if (!board[currentPlayerPosition[0]][currentPlayerPosition[1] + 1].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
                return true;
            }
        }
        return false;
    }

    private boolean rowInBoard(int row) {
        return (row < boardRows) & (row >= 0);
    }

    private boolean colInBoard(int col) {
        return (col < boardCols) & (col >= 0);
    }

    public boolean moveHeroes(int[] destination) {
        boolean cellAdjacent = false;
        // check cell to left if in board, if this cell is dest, true
        if (rowInBoard(currentPlayerPosition[0] - 1)) {
            if (((currentPlayerPosition[0] - 1) == destination[0]) & (currentPlayerPosition[1] == destination[1])) {
                return true;
            }
            // check cell to right if in board, if this cell is dest, true
        } else if (rowInBoard(currentPlayerPosition[0] + 1)) {
            if (((currentPlayerPosition[0] + 1) == destination[0]) & (currentPlayerPosition[1] == destination[1])) {
                return true;
            }
            // check cell below if in board, if this cell is dest, true
        } else if (colInBoard(currentPlayerPosition[1] - 1)) {
            if (((currentPlayerPosition[1] - 1) == destination[1]) & (currentPlayerPosition[0] == destination[0])) {
                return true;
            }
            // check cell above if in board, if this cell is dest, true
        } else if (colInBoard(currentPlayerPosition[1] + 1)) {
            if (((currentPlayerPosition[1] + 1) == destination[1]) & (currentPlayerPosition[0] == destination[0])) {
                return true;
            }
        }

        return false;
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
        str.append(String.format("Heroes at (%s, %s)\n", currentPlayerPosition[0], currentPlayerPosition[0]));

        // print column numbers
        str.append("    ");
        for (int j = 0; j < boardCols; j++) {
            str.append(cBody("" + j));
        }
        str.append("|\n");

        // print body of board
        // for each row
        for (int i=0; i < boardRows; i++) {
            // for each sub row
            for (int k = 0; k <= cellHeight; k++) {
                if (k != 0) {
                    str.append("" + i + "   ");
                } else {
                    str.append("    ");
                }
                // for each column
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

        // print final closing row
        str.append("    ");
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
