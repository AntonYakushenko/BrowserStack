package config.drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.setup.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver extends TestBase implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", userName);
        desiredCapabilities.setCapability("browserstack.key", mobileKey);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", appURL);

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Java BrowserStack Appium");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "Homework Tests");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
