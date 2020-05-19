package com.training.chainofresponsibility;

public class Level1 extends Handler {
    @Override
    public double applyFreeCoins(Game game) {

        game.setFreeCoins(100);
        System.out.println("Level1 free coins calculated");
        if (game.getScore() >= 10000&&game.getScore() < 20000) {
            return game.getFreeCoins();
        } else {
            return successor.applyFreeCoins(game);
        }
    }
}
