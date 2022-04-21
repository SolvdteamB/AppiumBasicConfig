package com.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class App {

    public static void main(String[] args) throws MalformedURLException {

        // In selenium, abriamos el chrome y cargabamos la pagina y despues empezabamos
        // a automatizar

        // Aca tenemos que decirle a Appium, que dispositvo vamos a usar, que systema
        // operativo, y cual es la app que vamos a correr.
        // Esto lo hacemos a traves de la clase desirecapabilities

        File appDir = new File("src/main/java/resources");
        File app = new File(appDir, "ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LindoFono");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        // UiAutomator-> Android
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

        // Driver

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, cap);

    }
}
