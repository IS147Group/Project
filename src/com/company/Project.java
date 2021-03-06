package com.company;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("resource")

public class Project {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to our IS147 Group Project");
        System.out.println();
        System.out.println("Menu");
        System.out.println("1 - Play Connect Four");
        System.out.println("2 - Quit the program");
        System.out.println();
        System.out.println("Please enter an option: ");

        int userOption = input.nextInt();

        switch (userOption) {

            case 1:

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

                System.out.println("Player 1, enter your name: ");
                Player player1 = new Player(input.next(), 'X');
                System.out.println("Player 2, enter your name: ");
                Player player2 = new Player(input.next(), 'O');

                System.out.println("\n" + player1.getName() + " is " + player1.getPlayerPiece());
                System.out.println(player2.getName() + " is " + player2.getPlayerPiece());
                System.out.println("First player who gets four in a row (up/down/diagonally) wins.\n");

                boolean win = false;
                char currentPiece = player2.getPlayerPiece();
                int column = 0;
                int row = 0;
                int i = 0;
                long start = gameTime.setCurrentTime();

                do {
                    if (currentPiece == player2.getPlayerPiece()) {
                        currentPiece = player1.getPlayerPiece();
                    } else if (currentPiece == player1.getPlayerPiece()) {
                        currentPiece = player2.getPlayerPiece();
                    }

                    if (currentPiece == player1.getPlayerPiece()) {
                        System.out.println(player1.getName() + ": Place your piece in a column.");
                    } else if (currentPiece == player2.getPlayerPiece()) {
                        System.out.println(player2.getName() + ": Place your piece in a column.");
                    }
                    column = input.nextInt() - 1;
                    System.out.println("\n");


                    while ((column > 6 || column < 0) || (board[0][column] == 'X' || board[0][column] == 'O')) {
                        System.out.println("Invalid entry. Try again.");

                        if (currentPiece == player1.getPlayerPiece()) {
                            System.out.println(player1.getName() + ": Place your piece in a column.");
                        } else if (currentPiece == player2.getPlayerPiece()) {
                            System.out.println(player2.getName() + ": Place your piece in a column.");
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
                } else if (currentPiece == player1.getPlayerPiece()) {
                    System.out.println(player1.getName() + " WINS!\nCongratulations!");
                } else if (currentPiece == player2.getPlayerPiece()) {
                    System.out.println(player2.getName() + " WINS!\nCongratulations!");
                }

                long end = gameTime.setCurrentTime();
                gameTime.totalTime(end, start);
                gameTime.getCurrentTime(end);
                break;

            case 2: System.out.println("Thank you for using the program");
                    break;

        }
    }
}