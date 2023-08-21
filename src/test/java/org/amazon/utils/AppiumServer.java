package org.amazon.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.exec.CommandLine;

import java.io.File;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;
import static java.lang.Integer.parseInt;

public class AppiumServer {
    private static AppiumDriverLocalService appiumService;

    static {
        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(parseInt("4723"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(LOG_LEVEL, "info"));
    }
    public static void startServer() {
        appiumService.start();
    }

    public static void stopServer() {
        if(appiumService.isRunning()) appiumService.stop();
    }
}
