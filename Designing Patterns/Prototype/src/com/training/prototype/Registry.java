package com.training.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<PhoneType, Phone> phones= new HashMap<>();

    public Registry() {
       this.initialize();
    }

    public Phone getPhone(PhoneType phoneType){
        Phone phone=null;
        try {
             phone=(Phone)phones.get(phoneType).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return phone;
    }

    private void initialize() {

        AppleiPhone ipPhone= new AppleiPhone();
        ipPhone.setFacetimeStatus("yes");
        ipPhone.setRam("4GB");
        ipPhone.setIOS_version("13");
        ipPhone.setBatteryLife("6000");
        ipPhone.setVersion("11pro max");

        Samsung samsung= new Samsung();
        samsung.setAndroidVersion("Pie");
        samsung.setRam("6GB");
        samsung.setBatteryLife("6500");
        samsung.setVersion("s9");

        phones.put(PhoneType.IPHONE,ipPhone);
        phones.put(PhoneType.SAMSUNG,samsung);
    }
}
