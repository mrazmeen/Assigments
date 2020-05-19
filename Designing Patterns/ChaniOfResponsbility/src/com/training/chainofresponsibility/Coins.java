package com.training.chainofresponsibility;

public class Coins extends  Handler {
    @Override
    public double applyFreeCoins(Game game) {
        return successor.applyFreeCoins(game);

    }
}
