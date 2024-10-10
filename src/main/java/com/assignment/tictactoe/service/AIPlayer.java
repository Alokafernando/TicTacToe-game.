package com.assignment.tictactoe.service;

import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(BoardImpl board) {
        super(board);
    }

    @Override
    public void move() {
        Random random = new Random();
        int row,
        col;

        do{
             row = random.nextInt(3);
            System.out.println("Row:" + row);
             col = random.nextInt(3);
            System.out.println("Col:" + col);

        }while (board.isLegalMove(row, col));{
            board.updateMove(row, col, Piece.O);
        }






    }
}
