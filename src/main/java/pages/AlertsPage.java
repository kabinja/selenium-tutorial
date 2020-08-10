package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private final WebDriver driver;

    private final By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private final By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private final By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private final By alertResult = By.id("result");

    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPromptButton(){
        driver.findElement(triggerPromptButton).click();
    }

    public void alertClickToAccept(){
        driver.switchTo().alert().accept();
    }

    public void alertClickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public String alertGetText(){
        return driver.switchTo().alert().getText();
    }

    public void alertSetInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public String getAlertResult(){
        return driver.findElement(alertResult).getText();
    }
}
