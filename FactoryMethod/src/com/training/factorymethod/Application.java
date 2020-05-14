package com.training.factorymethod;

public class Application {
    public static void main(String[] args) {
        Package aPackage1= PackageFactory.createPackage(PackageType.LEVEL1);
        System.out.println(aPackage1);
        Package aPackage2= PackageFactory.createPackage(PackageType.SETTLED);
        System.out.println(aPackage2);
        Package aPackage3= PackageFactory.createPackage(PackageType.WELL_SETTLED);
        System.out.println(aPackage3);
        Package aPackage4= PackageFactory.createPackage(PackageType.KING);
        System.out.println(aPackage4);
    }
}
