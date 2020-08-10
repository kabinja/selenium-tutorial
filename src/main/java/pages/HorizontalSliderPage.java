package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private final WebDriver driver;

    private final By sliderContainer = By.className("sliderContainer");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void moveSliderBy(int count){
        for(int i = 0; i < count; ++i){
            getSlider().sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getRange(){
        return driver.findElement(sliderContainer).findElement(By.id("range")).getText();
    }

    private WebElement getSlider(){
        return driver.findElement(sliderContainer).findElement(By.tagName("input"));
    }
}
