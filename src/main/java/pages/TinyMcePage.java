package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TinyMcePage {
    private final WebDriver driver;
    private final String editorIframeId = "mce_0_ifr";
    private final By textArea = By.id("tinymce");
    private final By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public TinyMcePage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public void decreaseIndentation(){
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        final String text = driver.findElement(textArea).getText();
        switchToMainArea();

        return text;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
