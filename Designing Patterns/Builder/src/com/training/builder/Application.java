package com.training.builder;

public class Application {

    public static void main(String[] args) {
        AppleIphone.Builder builder= new AppleIphone.Builder("Green");

        AppleIphone appleIphone= builder.warranty("3 years").earPod("with earpods").wirelessCharge("with wireless charge").Build();
        System.out.println(appleIphone);
    }

}
