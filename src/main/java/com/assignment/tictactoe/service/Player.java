package com.assignment.tictactoe.service;

public abstract class Player {

    public BoardImpl board;

    public Player(BoardImpl board) {
        this.board = board;
    }

    public abstract void move();
}
