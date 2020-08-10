package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private final WebDriver driver;
    private final By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToParagraph(int index){
        final String script = "window.scrollTo(0, document.body.scrollHeight)";
        final JavascriptExecutor executor = (JavascriptExecutor)driver;

        while (getNumberParagraphs() < index){
            executor.executeScript(script);
        }
    }

    private int getNumberParagraphs(){
        return driver.findElements(textBlocks).size();
    }
}
