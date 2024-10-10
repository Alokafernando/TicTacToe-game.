package com.assignment.tictactoe.service;

public class BoardImpl implements Board {
    private Piece[][] board;
    private final int size = 3;

    public BoardImpl() {
        board = new Piece[size][size];
        initializeBoard();

    }

    @Override
    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public int[] findNextAvailableSpot() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == Piece.EMPTY) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    @Override
    public boolean isLegalMove(int row, int col) {
        if (board[row][col] == Piece.X || board[row][col] == Piece.O) {
            return true;
        }else{
            return false;
        }
      //  return board[row][col] == Piece.X || board[row][col] == Piece.O;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    @Override
    public Piece checkWinner() {
            
            for (int row = 0; row < 3; row++) {
                if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != Piece.EMPTY) {
                    return board[row][0];
                }
            }

            for (int col = 0; col < 3; col++) {
                if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != Piece.EMPTY) {
                    return board[0][col];
                }
            }

            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Piece.EMPTY) {
                return board[0][0]; 
            }

            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Piece.EMPTY) {
                return board[0][2];
            }

            if (isBoardFull()) {

            }
            return null;

    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Piece.EMPTY) {
                    return false; // if cell is empty send false
                }
            }
        }
        return true; // if all cell are filled send true
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
