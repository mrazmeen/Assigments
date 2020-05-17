package com.training.builder;

public class AppleIphone {
    private final String warranty;
    private final String earPod;
    private final String wirelessCharge;
    private final String color;

    public AppleIphone(Builder builder) {
        this.color=builder.color;
        this.earPod=builder.earPod;
        this.wirelessCharge=builder.wirelessCharge;
        this.warranty=builder.warranty;
    }

    static class Builder {
        private String warranty;
        private String earPod;
        private String wirelessCharge;
        private String color;

        public AppleIphone Build(){
            return new AppleIphone(this);
        }

        public Builder(String color) {
            this.color=color;
        }

        public Builder warranty(String warranty) {
            this.warranty = warranty;
            return this;
        }

        public Builder earPod(String earPod) {
            this.earPod = earPod;
            return this;
        }

        public Builder wirelessCharge(String wirelessCharge) {
            this.wirelessCharge = wirelessCharge;
            return this;
        }


    }

    @Override
    public String toString() {
        return "AppleIphone{" +
                "warranty='" + warranty + '\'' +
                ", earPod='" + earPod + '\'' +
                ", wirelessCharge='" + wirelessCharge + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
