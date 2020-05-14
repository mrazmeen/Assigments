package com.training.factorymethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Package {
    protected List<Benifits> benifits= new ArrayList<>();

    public Package() {
        createPackage();
    }

    protected abstract void createPackage();
    @Override
    public String toString(){

        return "Package{"+"Benifits"+benifits+'}';
    }
}
