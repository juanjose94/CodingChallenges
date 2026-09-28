package org.example.technical_tests.agile_engine;

import java.util.Scanner;

public class Main {

    public static class Mobile {
        private final Boolean touchScreenAvaiable;
        private final Boolean enabled5G;
        private final Integer ram;
        private final Integer cameraPixel;
        private final String brandName;
        private final String deviceName;

        public Mobile(MobileBuilder builder) {
            this.brandName = builder.brandName;
            this.deviceName = builder.deviceName;
            this.touchScreenAvaiable = builder.touchScreenAvaiable;
            this.enabled5G = builder.enabled5G;
            this.ram = builder.ram;
            this.cameraPixel = builder.cameraPixel;
        }

        public Boolean isTouchScreenAvaiable() {
            return touchScreenAvaiable;
        }

        public Boolean isEnabled5G() {
            return enabled5G;
        }

        public Integer getRam() {
            return ram;
        }

        public Integer getCameraPixel() {
            return cameraPixel;
        }

        public String getBrandName() {
            return brandName;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void printDetails() {
            System.out.println("Mobile " + deviceName + " of brand " + brandName
                    + " with following features : touch screen enabled " + touchScreenAvaiable
                    + ", 5G enabled " + enabled5G
                    + ", ram " + ram
                    + ", camera pixel " + cameraPixel);
        }

        public static class MobileBuilder {
            private Boolean touchScreenAvaiable = false;
            private Boolean enabled5G = false;
            private Integer ram = 0;
            private Integer cameraPixel = 0;
            private final String brandName;
            private final String deviceName;

            public MobileBuilder(String brandName, String deviceName) {
                this.brandName = brandName;
                this.deviceName = deviceName;
            }

            public MobileBuilder setTouchScreenAvaiable(Boolean touchScreenAvaiable) {
                this.touchScreenAvaiable = touchScreenAvaiable;
                return this;
            }

            public MobileBuilder setEnabled5G(Boolean enabled5G) {
                this.enabled5G = enabled5G;
                return this;
            }

            public MobileBuilder setRam(Integer ram) {
                this.ram = ram;
                return this;
            }

            public MobileBuilder setCameraPixel(Integer cameraPixel) {
                this.cameraPixel = cameraPixel;
                return this;
            }

            public Mobile build() {
                return new Mobile(this);
            }
        }
    }

    // Input line format: <deviceName> <brandName> <touchScreen> <5G> <ram> <cameraPixel>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] tokens = line.split("\\s+");
            Mobile.MobileBuilder builder = new Mobile.MobileBuilder(tokens[1], tokens[0])
                    .setTouchScreenAvaiable(Boolean.parseBoolean(tokens[2]))
                    .setEnabled5G(Boolean.parseBoolean(tokens[3]))
                    .setRam(Integer.parseInt(tokens[4]))
                    .setCameraPixel(Integer.parseInt(tokens[5]));
            new Mobile(builder).printDetails();
        }
    }
}
