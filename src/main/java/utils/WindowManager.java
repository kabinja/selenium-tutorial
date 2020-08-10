package utils;

import org.openqa.selenium.WebDriver;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class WindowManager {
    private final WebDriver driver;
    private final WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        this.navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void switchToTab(String tabName){
        final String currentWindowHandle = driver.getWindowHandle();
        final Set<String> windowHandles = driver.getWindowHandles();
        boolean found = false;

        for(String windowHandle: windowHandles){
            driver.switchTo().window(windowHandle);

            if(driver.getTitle().equals(tabName)){
                found = true;
                break;
            }
        }

        if(!found){
            driver.switchTo().window(currentWindowHandle);
        }
    }
}
