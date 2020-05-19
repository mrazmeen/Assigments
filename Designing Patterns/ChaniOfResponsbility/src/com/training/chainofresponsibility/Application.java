package com.training.chainofresponsibility;

public class Application {
    public static void main(String[] args) {
        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();
        Level4 level4 = new Level4();

        Coins coins = new Coins();
        coins.setSuccessor(level1);
        level1.setSuccessor(level2);
        level2.setSuccessor(level3);
        level3.setSuccessor(level4);

        Game game = new Game(15000);
        System.out.println(coins.applyFreeCoins(game));
        Game game1 = new Game(120000);
        System.out.println(coins.applyFreeCoins(game1));
        Game game2 = new Game(100000);
        System.out.println(coins.applyFreeCoins(game2));
        Game game3 = new Game(230000);
        System.out.println(coins.applyFreeCoins(game3));
        Game game4 = new Game(275000);
        System.out.println(coins.applyFreeCoins(game4));
        Game game5 = new Game(520000);
        System.out.println(coins.applyFreeCoins(game5));
    }
}
