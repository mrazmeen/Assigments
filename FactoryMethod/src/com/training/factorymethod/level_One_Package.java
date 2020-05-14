package com.training.factorymethod;

public class level_One_Package extends Package {
    @Override
    protected void createPackage() {
        benifits.add(new Spouse());
    }
}
