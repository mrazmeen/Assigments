package com.training.memento;

public class Application {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Assembling assembling = new Assembling();

        assembling.addParts(new CarParts("Body kit"));
        assembling.addParts(new CarParts("Fender"));
        careTaker.save(assembling);
        System.out.println(assembling);

        assembling.addParts(new CarParts("Spoiler"));
        careTaker.save(assembling);
        System.out.println(assembling);

        assembling.addParts(new CarParts("Sticker"));
        careTaker.save(assembling);
        System.out.println(assembling);

        assembling.addParts(new CarParts("Exhaust"));
//        careTaker.save(assembling);
        System.out.println(assembling);

        //Revert
        careTaker.revert(assembling);
        System.out.println(assembling);

        assembling.addParts(new CarParts("Neon light"));
//        careTaker.save(assembling);
        System.out.println(assembling);

        careTaker.revert(assembling);
        System.out.println(assembling);

        careTaker.revert(assembling);
        System.out.println(assembling);

        careTaker.revert(assembling);
        System.out.println(assembling);

        careTaker.revert(assembling);
        System.out.println(assembling);
    }
}
