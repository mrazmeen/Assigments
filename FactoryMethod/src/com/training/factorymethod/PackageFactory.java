package com.training.factorymethod;

public class PackageFactory {
    public static Package createPackage(PackageType packageType){
        switch (packageType){
            case LEVEL1:
                return new level_One_Package();
            case SETTLED:
                return new SettledPackage();
            case WELL_SETTLED:
                return new WellSetteledPackage();
            case KING:
                return new KingPackage();
            default:
                return null;
        }
    }
}
