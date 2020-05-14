package com.training.factorymethod;

public class KingPackage extends Package {
    @Override
    protected void createPackage() {
        benifits.add(new Spouse());
        benifits.add(new Propeties());
        benifits.add(new Vehicle());
        benifits.add(new Business());
    }
}
