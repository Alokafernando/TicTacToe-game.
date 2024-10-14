

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

        do {
            System.out.print("Row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Column (0-2): ");
            column = scanner.nextInt();
            System.out.println();

            if (!board.isLegalMove(row, column)) {
                System.out.println("Invalid move, try again.");
            }
        } while (!board.isLegalMove(row, column));

        board.updateMove(row, column, Piece.X);
    }
}