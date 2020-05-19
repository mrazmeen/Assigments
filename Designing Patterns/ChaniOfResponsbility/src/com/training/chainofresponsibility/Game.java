package com.training.chainofresponsibility;

public class Game {


    private double score;
    private double freeCoins;

    protected void setFreeCoins(double freeCoins) {
        this.freeCoins = freeCoins;
    }

    public Game(double score) {
        this.score = score;
    }
    public double getScore() {
        return score;
    }

    public double getFreeCoins() {
        return freeCoins;
    }
}
