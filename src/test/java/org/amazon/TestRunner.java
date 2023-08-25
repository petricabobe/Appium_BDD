package org.amazon;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static org.amazon.utils.AppiumServer.startServer;
import static org.amazon.utils.AppiumServer.stopServer;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "org.amazon.stepdefinitions",
        plugin = {"pretty"}
)
public class TestRunner {
    @BeforeClass
    public static void startAppium() {
        System.out.println("start appium");
        startServer();
    }

    @AfterClass
    public static void stopAppium() {
        stopServer();
    }
}
