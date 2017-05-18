package com.company;
public class winCheck {

    static boolean winCheck_UpDn(char _board[][], int _row, int _column, char _currentPiece) {
        for (int i = 0; i < _board.length - 3; i++) {
            if (_board[i][_column] == _currentPiece) {
                if (_board[i + 1][_column] == _currentPiece) {
                    if (_board[i + 2][_column] == _currentPiece) {
                        if (_board[i + 3][_column] == _currentPiece) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    static boolean winCheck_LR(char _board[][], int _row, int _column, char _currentPiece) {
        for (int i = 0; i < _board[_row].length - 3; i++) {
            if (_board[_row][i] == _currentPiece) {
                if (_board[_row][i + 1] == _currentPiece) {
                    if (_board[_row][i + 2] == _currentPiece) {
                        if (_board[_row][i + 3] == _currentPiece) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    static boolean winCheck_DiagLRDn(char _board[][], int _row, int _column, char _currentPiece) {
        for (int i = 0; i < _board.length - 3; i++) {
            for (int j = 0; j < _board[_row].length - 3; j++) {
                if (_board[i][j] == _currentPiece) {
                    if (_board[i + 1][j + 1] == _currentPiece) {
                        if (_board[i + 2][j + 2] == _currentPiece) {
                            if (_board[i + 3][j + 3] == _currentPiece) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    static boolean winCheck_DiagLRUp(char _board[][], int _row, int _column, char _currentPiece) {
        for (int i = _board.length - 1; i > 2; i--) {
            for (int j = 0; j < _board[_row].length - 3; j++) {
                if (_board[i][j] == _currentPiece) {
                    if (_board[i - 1][j + 1] == _currentPiece) {
                        if (_board[i - 2][j + 2] == _currentPiece) {
                            if (_board[i - 3][j + 3] == _currentPiece) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    static boolean checkFull(char _board[][]) {
        int k = 0;
        for (int i = 0; i < _board.length; i++) {
            for (int j = 0; j < _board[i].length; j++) {
                if (_board[i][j] != '-') {
                    k++;
                }
            }
        }
        if (k == 42) {
            return true;
        } else {
            return false;
        }
    }
}