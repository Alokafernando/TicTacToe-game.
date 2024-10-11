package com.assignment.tictactoe.service;

public class Main {
    public static void main(String[] args) {

        BoardImpl board = new BoardImpl();
        Player human = new HumanPlayer(board);
        Player AI = new AIPlayer(board);

        boolean isGameStarted = true;

        while (isGameStarted) {
            board.printBoard();

                System.out.println();
                //Human
                System.out.println("Your turn (X): ");
                human.move();
                System.out.println();
                //AI
                System.out.println("Your turn (O): ");
                AI.move();
                System.out.println();



        }

    }
}
