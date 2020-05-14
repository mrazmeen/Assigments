package com.training.factorymethod;

public class SettledPackage extends Package {
    @Override
    protected void createPackage() {
        benifits.add(new Spouse());
        benifits.add(new Propeties());
    }
}
