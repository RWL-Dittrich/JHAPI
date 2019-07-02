import nl.mesoplz.hue.models.HueBridge;
import nl.mesoplz.hue.models.HueLight;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
//            HueBridge bridge = new HueBridge("localhost", "66986704230b2e75868416979af78fe"); //pc emulator hue+
//            HueBridge bridge = new HueBridge("192.168.1.102", "8f36bb73f410a65f044469ea5b645dca", 5); //home diyhue
            HueBridge bridge = new HueBridge("192.168.1.51", "4lHzCIy-2gZKkUKD75tHXWhvWvDEOCxpJP9YILGF", 0); //syntaxis hue

            System.out.println(bridge.getLights());
            //init loop
            for (HueLight light : bridge.getLights()) {
                light.setPower(true);
                light.setBri(40);
                light.setRGB(0, 255, 0);
                light.setTransitionTime(20);
            }

            while (true) {
                for (HueLight light : bridge.getLights()) {
                    light.setBri(100);
                    light.setRGB(255, 0, 0);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (HueLight light : bridge.getLights()) {
                    light.setBri(40, 5);
                    light.setRGB(0, 255, 0);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
