package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private final WebDriver driver;
    private final By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable(){
        final WebElement tableElement = driver.findElement(table);
        final String script = "arguments[0].scrollIntoView()";

        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }
}
