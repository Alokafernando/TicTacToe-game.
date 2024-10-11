package com.assignment.tictactoe.service;

public interface Board {
   // BoardImpl
   void initializeBoard();
   int[]  findNextAvailableSpot();
   boolean isLegalMove(int row, int col);
   void updateMove(int row, int col, Piece piece);
    Piece checkWinner();
   void printBoard();
}
