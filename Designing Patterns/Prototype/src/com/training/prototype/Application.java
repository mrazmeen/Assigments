package com.training.prototype;

public class Application {
    public static void main(String[] args) {
        Registry registry= new Registry();

        AppleiPhone appleiPhone= (AppleiPhone) registry.getPhone(PhoneType.IPHONE);
        System.out.println(appleiPhone);

        appleiPhone.setIOS_version("12");
        System.out.println(appleiPhone);

        AppleiPhone appleiPhone1= (AppleiPhone) registry.getPhone(PhoneType.IPHONE);
        System.out.println(appleiPhone1);


    }
}

