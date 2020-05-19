package com.training.chainofresponsibility;

public class Level4 extends Handler{
    @Override
    public double applyFreeCoins(Game game) {
        game.setFreeCoins(10000);
        System.out.println("Level4 free coins calculated");
        if(game.getScore()>=500000){
            return game.getFreeCoins();
        }
        else{
            return successor.applyFreeCoins(game);
        }
    }
}
