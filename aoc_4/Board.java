public class Board {

    int[][] board;
    boolean[][] markedBoard;

    public Board() {
        board = new int[5][5];
        markedBoard = new boolean[5][5];
    }

    public void markValue(int value) {
        for (int iY = 0; iY < 5; iY++) {
            for (int iX = 0; iX < 5; iX++) {
                if(board[iY][iX] == value) {
                    markedBoard[iY][iX] = true;
                    return;
                }
            }
        }
    }

    public void setRow(int row, int[] values) {
        board[row] = values;
    }

    public boolean isFinished() {
        for (int iRow = 0; iRow < board.length; iRow++) {
            if(markedBoard[iRow][0] && markedBoard[iRow][1] && markedBoard[iRow][2] && markedBoard[iRow][3] && markedBoard[iRow][4]) {
                return true;
            }
        }
        for(int iColumn = 0; iColumn < board[0].length; iColumn++) {
            if(markedBoard[0][iColumn] && markedBoard[1][iColumn] && markedBoard[2][iColumn] && markedBoard[3][iColumn] && markedBoard[4][iColumn]) {
                return true;
            }
        }
        return false;
    }

    public int getUnmarkedSum() {
        int sum = 0;
        for (int iY = 0; iY < 5; iY++) {
            for (int iX = 0; iX < 5; iX++) {
                if(!markedBoard[iY][iX]) {
                    sum += board[iY][iX];
                }
            }
        }
        return sum;
    }
}
