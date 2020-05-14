package com.training.prototype;

public class Samsung extends Phone {

    private String androidVersion;

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    @Override
    public String toString() {
        return "Samsung{" +
                "androidVersion='" + androidVersion + '\'' +
                '}';
    }
}
