package com.assignment.tictactoe.service;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(BoardImpl board) {
        super(board);
    }

    @Override
    public void move() {
        Scanner scanner = new Scanner(System.in);
        int row, column;

        do{
            System.out.print("Row: ");
            row = scanner.nextInt();
            System.out.print("Column: ");
            column = scanner.nextInt();
        }while (board.isLegalMove(row, column));{
            board.updateMove(row, column, Piece.X);
        }

        // while -> can't use -> first initializing second check
    }
}
