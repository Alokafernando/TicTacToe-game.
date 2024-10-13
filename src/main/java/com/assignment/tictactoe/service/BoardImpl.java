package com.assignment.tictactoe.service;

public class BoardImpl implements Board {
    private Piece[][] pieces;

    public BoardImpl() {
        pieces = new Piece[3][3];
        initializeBoard();

    }

    @Override
    public void initializeBoard() {
        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces.length; col++) {
                pieces[row][col] = Piece.EMPTY;
            }
        }
    }

    @Override
    public boolean isLegalMove(int row, int col) {
      return pieces[row][col] == Piece.X || pieces[row][col] == Piece.O;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        pieces[row][col] = piece;
    }

    @Override
    public void printBoard() {
        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces.length; col++) {
                System.out.print(pieces[row][col] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Piece checkWinner() {
        for (int row = 0; row < pieces.length; row++) {
            if(pieces[row][0] == Piece.X){
                if(pieces[row][0] == pieces[row][1] & pieces[row][1] == pieces[row][2]){
                    return Piece.X;
                }
            }else if(pieces[row][0] == Piece.O){
                if(pieces[row][0] == pieces[row][1] & pieces[row][1] == pieces[row][2]){
                    return Piece.O;
                }
            }
        }
        for (int col = 0; col < pieces.length; col++) {
            if(pieces[0][col] == Piece.X){
                if(pieces[0][col] == pieces[1][col] & pieces[1][col] == pieces[2][col]){
                    return Piece.X;
                }
            }else if(pieces[0][col] == Piece.O){
                if(pieces[0][col] == pieces[1][col] & pieces[1][col] == pieces[2][col]){
                    return Piece.O;
                }
            }
        }
        if(pieces[0][0] == Piece.X){
            if (pieces[0][0] == pieces[1][1] & pieces[1][1] == pieces[2][2]) {
                return Piece.X;
            }
        }else if(pieces[0][0] == Piece.O){
            if (pieces[0][0] == pieces[1][1] & pieces[1][1] == pieces[2][2]) {
                return Piece.O;
            }
        }
        if(pieces[0][2] == Piece.X){
            if (pieces[0][2] == pieces[1][1] & pieces[1][1] == pieces[2][0]) {
                return Piece.X;
            }
        } else if (pieces[0][2] == Piece.O) {
            if (pieces[0][2] == pieces[1][1] & pieces[1][1] == pieces[2][0]) {
                return Piece.O;
            }
        }
        return Piece.EMPTY;
    }



    public int[] findNextAvailableSpot() {

        for (int row = 0; row < pieces.length; row++) {
            for (int col = 0; col < pieces.length; col++) {
                if (pieces[row][col] == Piece.EMPTY) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    public boolean findWinner() {
        if(checkWinner() == Piece.X || checkWinner() == Piece.O){
            return true;
        }else{
            return false;
        }

    }

    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (pieces[row][col] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}
