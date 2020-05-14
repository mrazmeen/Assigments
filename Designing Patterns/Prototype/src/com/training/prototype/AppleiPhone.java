package com.training.prototype;

public class AppleiPhone extends Phone {

    private String facetimeStatus;
    private String IOS_version;

    public String getFacetimeStatus() {
        return facetimeStatus;
    }

    public void setFacetimeStatus(String facetimeStatus) {
        this.facetimeStatus = facetimeStatus;
    }

    public String getIOS_version() {
        return IOS_version;
    }

    public void setIOS_version(String IOS_version) {
        this.IOS_version = IOS_version;
    }

    @Override
    public String toString() {
        return "AppleiPhone{" +
                "facetimeStatus='" + facetimeStatus + '\'' +
                ", IOS_version='" + IOS_version + '\'' +
                '}';
    }
}
