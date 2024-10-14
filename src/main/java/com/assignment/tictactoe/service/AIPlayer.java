package com.assignment.tictactoe.service;

public class AIPlayer extends Player {

    public AIPlayer(BoardImpl board) {
        super(board);
    }

    @Override
    public void move() {
        int bestRow = -1;
        int bestCol = -1;
        int bestScore = Integer.MIN_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.isLegalMove(row, col)) {
                    board.updateMove(row, col, Piece.O);
                    int score = minimax(board, 0, false);
                    board.updateMove(row, col, Piece.EMPTY);

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = row;
                        bestCol = col;
                    }
                }
            }
        }

        if (bestRow != -1 && bestCol != -1) {
            board.updateMove(bestRow, bestCol, Piece.O);
        }
    }

    private int minimax(BoardImpl board, int depth, boolean isMaximizing) {
        Piece winner = board.checkWinner();

        if (winner == Piece.X) {
            return -10 + depth; // X wins
        } else if (winner == Piece.O) {
            return 10 - depth; // O wins
        } else if (board.isBoardFull()) {
            return 0; // Draw
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isLegalMove(row, col)) {
                        board.updateMove(row, col, Piece.O);
                        int score = minimax(board, depth + 1, false);
                        board.updateMove(row, col, Piece.EMPTY);
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isLegalMove(row, col)) {
                        board.updateMove(row, col, Piece.X);
                        int score = minimax(board, depth + 1, true);
                        board.updateMove(row, col, Piece.EMPTY);
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}