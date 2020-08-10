package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class BaseTest {
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        goHome();

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("http://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(result.isSuccess()){
            return;
        }

        final File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());

        final Path targetPath = Paths.get("target","screenshots");
        final File targetFolder = targetPath.toFile();
        targetFolder.mkdirs();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        final String fileName = String.format("%s-%s.png", result.getName(), format.format(date));
        final File destination = new File(targetFolder, fileName);

        screenshot.renameTo(destination);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    private ChromeOptions getChromeOptions(){
        final ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setHeadless(true);

        return options;
    }
}
