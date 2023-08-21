package org.amazon.runner;

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
        startServer();
    }

    @AfterClass
    public static void stopAppium() {
        stopServer();
    }
}
