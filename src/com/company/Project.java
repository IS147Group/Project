import java.util.Arrays;
import java.util.Scanner;
@SuppressWarnings("resource")
public class Project {

    public static void main(String[] args) {
        char board[][] = new char[6][7];
        //fill board with empty spaces and output the board.
        for (char[] row: board){
            Arrays.fill(row, '-');
        }
        System.out.println("CONNECT FOUR\n");
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("_____________\n1 2 3 4 5 6 7");
        System.out.println("   Columns   \n");
        System.out.println("Player 1 is 'X'\nPlayer 2 is 'O'\n");
        System.out.println("First player who gets four in a row (up/down/diagonally) wins.\n");

        Scanner input = new Scanner(System.in);
        boolean win = false;
        char player1Piece = 'X';
        char player2Piece = 'O';
        char currentPiece = player2Piece;
        int column = 0;
        int row = 0;
        int i = 0;

        do
        {
            if (currentPiece == player2Piece){currentPiece = player1Piece;}
            else if (currentPiece == player1Piece){currentPiece = player2Piece;}

            if (currentPiece == player1Piece){
                System.out.println("Player 1: Place your piece in a column.");
            }
            else if (currentPiece == player2Piece){
                System.out.println("Player 2: Place your piece in a column.");
            }
            column = input.nextInt()-1;
            System.out.println("\n");



            while ((column > 6 || column < 0) || (board[0][column] == 'X' || board[0][column] == 'O'))
            {
                System.out.println("Invalid entry. Try again.");

                if (currentPiece == player1Piece){
                    System.out.println("Player 1: Place your piece in a column.");
                }
                else if (currentPiece == player2Piece){
                    System.out.println("Player 2: Place your piece in a column.");
                }
                column = input.nextInt()-1;
                System.out.println("\n");
            }

            for (i = 0; i<=5; i++){
                if (board[i][column] == '-'){
                    row = i;
                }
                else{
                    continue;
                }
            }
            board[row][column] = currentPiece;

            for (i = 0; i < 6; i++){
                for (int j = 0; j < board[i].length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("_____________\n1 2 3 4 5 6 7\n");

            if (winCheck_UpDn(board, row, column, currentPiece) == true){win = true;}
            else if (winCheck_LR(board, row, column, currentPiece) == true){win = true;}
            else if (winCheck_DiagLRDn(board, row, column, currentPiece) == true){win = true;}
            else if (winCheck_DiagLRUp(board, row, column, currentPiece) == true){win = true;}

            if (checkFull(board) == true){win = true;}

        } while (win == false);

        System.out.println("GAME OVER");
        if (checkFull(board) == true){System.out.println("The board is full.\nThe game is a draw.");}
        else if (currentPiece == player1Piece){System.out.println("Player 1 WINS!\nCongratulations!");}
        else if (currentPiece == player2Piece){System.out.println("Player 2 WINS!\nCongratulations!");}
    }

    static boolean checkFull (char _board[][]){
        int k = 0;
        for (int i = 0; i < _board.length; i++){
            for (int j = 0; j < _board[i].length; j++){
                if (_board[i][j] != '-'){
                    k++;
                }
            }
        }
        if (k == 42){return true;}
        else {return false;}
    }

    static boolean winCheck_UpDn(char _board[][], int _row, int _column, char _currentPiece){
        int i = 1;
        int j = _row - 1;
        int k = _row - 2;
        int l = _row - 3;
        int jj = _row + 1;
        int kk = _row + 2;
        int ll = _row + 3;

        if ((l >= 0 & l <= 5)){if ((_board[l][_column]) == _currentPiece){i++;}}
        if ((k >= 0 & k <= 5)){if ((_board[k][_column]) == _currentPiece){i++;}}
        if ((j >= 0 & j <= 5)){if ((_board[j][_column]) == _currentPiece){i++;}}
        if ((jj >= 0 & jj <= 5)){if ((_board[jj][_column]) == _currentPiece){i++;}}
        if ((kk >= 0 & kk <= 5)){if ((_board[kk][_column]) == _currentPiece){i++;}}
        if ((ll >= 0 & ll <= 5)){if ((_board[ll][_column]) == _currentPiece){i++;}}

        if (i >= 4)
            return true;
        else return false;
    }

    static boolean winCheck_LR(char _board[][], int _row, int _column, char _currentPiece){
        int i = 1;
        int m = _column - 1;
        int n = _column - 2;
        int o = _column - 3;
        int mm = _column + 1;
        int nn = _column + 2;
        int oo = _column + 3;

        if (m >= 0 & m <= 6){if ((_board[_row][m]) == _currentPiece){i++;}}
        if (n >= 0 & n <= 6){if ((_board[_row][n]) == _currentPiece){i++;}}
        if (o >= 0 & o <= 6){if ((_board[_row][o]) == _currentPiece){i++;}}
        if (mm >= 0 & mm <= 6){if ((_board[_row][mm]) == _currentPiece){i++;}}
        if (nn >= 0 & nn <= 6){if ((_board[_row][nn]) == _currentPiece){i++;}}
        if (oo >= 0 & oo <= 6){if ((_board[_row][oo]) == _currentPiece){i++;}}

        if (i >= 4)
            return true;
        else return false;
    }

    static boolean winCheck_DiagLRDn(char _board[][], int _row, int _column, char _currentPiece){
        int i = 1;
        int j = _row - 1;
        int k = _row - 2;
        int l = _row - 3;
        int jj = _row + 1;
        int kk = _row + 2;
        int ll = _row + 3;
        int m = _column - 1;
        int n = _column - 2;
        int o = _column - 3;
        int mm = _column + 1;
        int nn = _column + 2;
        int oo = _column + 3;

        if ((l >= 0 & l <= 5) & (o >= 0 & o <= 6)){if ((_board[l][o]) == _currentPiece){i++;}}
        if ((k >= 0 & k <= 5) & (n >= 0 & n <= 6)){if ((_board[k][n]) == _currentPiece){i++;}}
        if ((j >= 0 & j <= 5) & (m >= 0 & m <= 6)){if ((_board[j][m]) == _currentPiece){i++;}}
        if ((jj >= 0 & jj <= 5) & (mm >= 0 & mm <= 6)){if ((_board[jj][mm]) == _currentPiece){i++;}}
        if ((kk >= 0 & kk <= 5) & (nn >= 0 & nn <= 6)){if ((_board[kk][nn]) == _currentPiece){i++;}}
        if ((ll >= 0 & ll <= 5) & (oo >= 0 & oo <= 6)){if ((_board[ll][oo]) == _currentPiece){i++;}}

        if (i >= 4)
            return true;
        else return false;
    }

    static boolean winCheck_DiagLRUp(char _board[][], int _row, int _column, char _currentPiece){
        int i = 1;
        int j = _row - 1;
        int k = _row - 2;
        int l = _row - 3;
        int jj = _row + 1;
        int kk = _row + 2;
        int ll = _row + 3;
        int m = _column - 1;
        int n = _column - 2;
        int o = _column - 3;
        int mm = _column + 1;
        int nn = _column + 2;
        int oo = _column + 3;

        if ((j >= 0 & j <= 5) & (mm >= 0 & mm <= 6)){if ((_board[j][mm]) == _currentPiece){i++;}}
        if ((k >= 0 & k <= 5) & (nn >= 0 & nn <= 6)){if ((_board[k][nn]) == _currentPiece){i++;}}
        if ((l >= 0 & l <= 5) & (oo >= 0 & oo <= 6)){if ((_board[l][oo]) == _currentPiece){i++;}}
        if ((jj >= 0 & jj <= 5) & (m >= 0 & m <= 6)){if ((_board[jj][m]) == _currentPiece){i++;}}
        if ((kk >= 0 & kk <= 5) & (n >= 0 & n <= 6)){if ((_board[kk][n]) == _currentPiece){i++;}}
        if ((ll >= 0 & ll <= 5) & (o >= 0 & o <= 6)){if ((_board[ll][o]) == _currentPiece){i++;}}

        if (i >= 4)
            return true;
        else return false;
    }
}