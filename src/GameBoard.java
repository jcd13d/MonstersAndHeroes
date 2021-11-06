import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameBoard {
    private static final int DEFAULT_BOARD_SIZE = 8;
    private int boardRows;
    private int boardCols;
    private BoardCell[][] board;
    private int[] curPlayerPos;

    public GameBoard(ArrayList<Hero> heroes) {
        this(DEFAULT_BOARD_SIZE, DEFAULT_BOARD_SIZE, heroes);
    }

    public GameBoard(int boardSize, ArrayList<Hero> heroes) {
        this(boardSize, boardSize, heroes);
    }

    public GameBoard(int boardRows, int boardCols, ArrayList<Hero> heroes) {
        setBoardCols(boardCols);
        setBoardRows(boardRows);
        board = new BoardCell[boardRows][boardCols];
        curPlayerPos = new int[] {0, 0};
        do {
            initBoard();
        } while(!canPlayersMove());
        board[curPlayerPos[0]][curPlayerPos[1]].setHeroes(heroes);
    }

    private void initBoard() {
        for (int i=0; i < boardRows; i++) {
            for (int j = 0; j < boardCols; j++) {
                board[i][j] = new BoardCell();
                if ((i == curPlayerPos[0]) & (j == curPlayerPos[1])) {
                    board[i][j].setPlayerCell(true);
                }
            }
        }
    }

    private boolean canPlayersMove() {
        if (rowInBoard(curPlayerPos[0] - 1)) {
            if (!board[curPlayerPos[0] - 1][curPlayerPos[1]].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
                return true;
            }
            // check cell to right if in board, if this cell is dest, true
        } else if (rowInBoard(curPlayerPos[0] + 1)) {
            if (!board[curPlayerPos[0] + 1][curPlayerPos[1]].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
                return true;
            }
            // check cell below if in board, if this cell is dest, true
        } else if (colInBoard(curPlayerPos[1] - 1)) {
            if (!board[curPlayerPos[0]][curPlayerPos[1] - 1].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
                return true;
            }
            // check cell above if in board, if this cell is dest, true
        } else if (colInBoard(curPlayerPos[1] + 1)) {
            if (!board[curPlayerPos[0]][curPlayerPos[1] + 1].getBoardState().equalsIgnoreCase(BoardCell.BLOCKED)) {
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

    private boolean playerMoveHelper(int[] destination) {
        return board[destination[0]][destination[1]].movePlayerToCell(board[curPlayerPos[0]][curPlayerPos[1]].getHeroes());
    }

    private void removeHerosHelper(int[] destination) {
        board[curPlayerPos[0]][curPlayerPos[1]].removeHeroes();
        board[destination[0]][destination[1]].setPlayerCell(true);
    }

    public boolean moveHeroes(int[] destination) {
        // check cell to left if in board, if this cell is dest, true
        boolean status = false;
        if (rowInBoard(curPlayerPos[0] - 1)) {
            if (((curPlayerPos[0] - 1) == destination[0]) & (curPlayerPos[1] == destination[1])) {
                status = playerMoveHelper(destination);
                if (status) {
                    removeHerosHelper(destination);
                }
                return status;
            }
            // check cell to right if in board, if this cell is dest, true
        } else if (rowInBoard(curPlayerPos[0] + 1)) {
            if (((curPlayerPos[0] + 1) == destination[0]) & (curPlayerPos[1] == destination[1])) {
                status = playerMoveHelper(destination);
                if (status) {
                    removeHerosHelper(destination);
                }
                return status;
            }
            // check cell below if in board, if this cell is dest, true
        } else if (colInBoard(curPlayerPos[1] - 1)) {
            if (((curPlayerPos[1] - 1) == destination[1]) & (curPlayerPos[0] == destination[0])) {
                status = playerMoveHelper(destination);
                if (status) {
                    removeHerosHelper(destination);
                }
                return status;
            }
            // check cell above if in board, if this cell is dest, true
        } else if (colInBoard(curPlayerPos[1] + 1)) {
            if (((curPlayerPos[1] + 1) == destination[1]) & (curPlayerPos[0] == destination[0])) {
                status = playerMoveHelper(destination);
                if (status) {
                    removeHerosHelper(destination);
                }
                return status;
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
        str.append(String.format("Heroes at (%s, %s)\n", curPlayerPos[0], curPlayerPos[0]));

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

}
