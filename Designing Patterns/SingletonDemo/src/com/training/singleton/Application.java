package com.training.singleton;

public class Application {
    public static void main(String[] args) {

        long start;
        long end;

        start=System.currentTimeMillis();
        CreateKey crk=KeyManager.getCreateKey();
        end=System.currentTimeMillis();
        System.out.println(end-start);

        start=System.currentTimeMillis();
        CreateKey crk1=KeyManager.getCreateKey();
        end=System.currentTimeMillis();
        System.out.println(end-start);


    }
}
