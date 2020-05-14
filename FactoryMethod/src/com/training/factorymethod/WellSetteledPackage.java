package com.training.factorymethod;

public class WellSetteledPackage extends Package {
    @Override
    protected void createPackage() {
        benifits.add(new Spouse());
        benifits.add(new Propeties());
        benifits.add(new Vehicle());
    }
}
