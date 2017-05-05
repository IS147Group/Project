package com.company;


import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Project {


    public static void main(String[] args) {
        char board[][] = new char[6][7];
        //fill board with empty spaces and output the board.
        for (char[] row : board) {
            Arrays.fill(row, '-');
        }
        System.out.println("CONNECT FOUR\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < board[i].length; j++) {
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

        do {
            if (currentPiece == player2Piece) {
                currentPiece = player1Piece;
            } else if (currentPiece == player1Piece) {
                currentPiece = player2Piece;
            }

            if (currentPiece == player1Piece) {
                System.out.println("Player 1: Place your piece in a column.");
            } else if (currentPiece == player2Piece) {
                System.out.println("Player 2: Place your piece in a column.");
            }
            column = input.nextInt() - 1;
            System.out.println("\n");


            while ((column > 6 || column < 0) || (board[0][column] == 'X' || board[0][column] == 'O')) {
                System.out.println("Invalid entry. Try again.");

                if (currentPiece == player1Piece) {
                    System.out.println("Player 1: Place your piece in a column.");
                } else if (currentPiece == player2Piece) {
                    System.out.println("Player 2: Place your piece in a column.");
                }
                column = input.nextInt() - 1;
                System.out.println("\n");
            }

            for (i = 0; i <= 5; i++) {
                if (board[i][column] == '-') {
                    row = i;
                } else {
                    continue;
                }
            }
            board[row][column] = currentPiece;

            for (i = 0; i < 6; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("_____________\n1 2 3 4 5 6 7\n");

            if (winCheck.winCheck_UpDn(board, row, column, currentPiece) == true) {
                win = true;
            } else if (winCheck.winCheck_LR(board, row, column, currentPiece) == true) {
                win = true;
            } else if (winCheck.winCheck_DiagLRDn(board, row, column, currentPiece) == true) {
                win = true;
            } else if (winCheck.winCheck_DiagLRUp(board, row, column, currentPiece) == true) {
                win = true;
            }

            if (winCheck.checkFull(board) == true) {
                win = true;
            }

        } while (win == false);

        System.out.println("GAME OVER");
        if (winCheck.checkFull(board) == true) {
            System.out.println("The board is full.\nThe game is a draw.");
        } else if (currentPiece == player1Piece) {
            System.out.println("Player 1 WINS!\nCongratulations!");
        } else if (currentPiece == player2Piece) {
            System.out.println("Player 2 WINS!\nCongratulations!");
        }
    }


}




