package com.uia.as2.devices;

public class DeviceFactory {
    public static Device getDevice(String productName) {
        if (productName.equals("cancro")) {
            return new XiaoMi();
        } else if (productName.equals("vbox86p")) {
            return new BaseDevice();
        }
        // TODO: support Nexus 6

        return new BaseDevice();
    }
}
