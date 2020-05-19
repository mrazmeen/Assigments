package com.training.chainofresponsibility;

public class Level2 extends Handler{
    @Override
    public double applyFreeCoins(Game game) {
        game.setFreeCoins(1000);
        System.out.println("Level2 free coins calculated");
        if(game.getScore()>=100000&&game.getScore()<=150000){
            return game.getFreeCoins();
        }
        else{
            return successor.applyFreeCoins(game);
        }
    }
}
