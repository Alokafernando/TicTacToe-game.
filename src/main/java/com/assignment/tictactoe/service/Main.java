package com.assignment.tictactoe.service;

public class Main {
    public static void main(String[] args) {

        BoardImpl board = new BoardImpl();
        Player human = new HumanPlayer(board);
        Player AI = new AIPlayer(board);

        boolean isGameStarted = true;

        l1: while (isGameStarted) {
            board.printBoard();

            System.out.println("\nYour turn (X): ");
            human.move();

            if (board.checkWinner() == Piece.X) {
                board.printBoard();
                System.out.println("Congratulations! You won! (X)");
                break l1;
            }

            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("match tie");
                break l1;
            }


            System.out.println("\nAI's turn (O): ");
            AI.move();
            System.out.println();

            if (board.checkWinner() == Piece.O) {
                board.printBoard();
                System.out.println("AI won! (O)");
                break l1;
            }

            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("match tie");
                break l1;
            }
        }
    }
}
