package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();


    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get() == null) {  // For cases that do not work from XML
            threadBrowserName.set("chrome");   // default chrome
        }

        if (threadDriver.get() == null) {

            switch (threadBrowserName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                case "safari":
                    threadDriver.set(new SafariDriver());
                default:
                    threadDriver.set(new ChromeDriver()); //there was no driver on the line I was on, I set one
            }

            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        }

        return threadDriver.get();
    }

    public static void quitDriver() {

        //test result screen to wait for a while
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // to switch off the driver
        if (threadDriver.get() != null) { //if there is a driver on this line

            threadDriver.get().quit();

            WebDriver driver = threadDriver.get(); //got the driver on the line
            driver = null;                         // made it null
            threadDriver.set(driver);              //reassigned him back on the line.

        }

    }
}
