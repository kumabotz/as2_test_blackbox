package com.uia.as2.tests.devices;

public class DeviceFactory {
    public static Device getDevice(String productName) {
        if (productName.equals("cancro")) {
            return new XiaoMi();
        } else if (productName.equals("vbox86p")) {
            return new Base();
        }

        return new Base();
    }
}
