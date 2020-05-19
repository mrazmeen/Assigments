package com.training.chainofresponsibility;

public class Level3 extends Handler{
    @Override
    public double applyFreeCoins(Game game) {
        game.setFreeCoins(5000);
        System.out.println("Level3 free coins calculated");
        if(game.getScore()>=200000&&game.getScore()<300000){
            return game.getFreeCoins();
        }
        else{
            return successor.applyFreeCoins(game);
        }
    }
}
