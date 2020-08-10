package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private final WebDriver driver;

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropdown(String... options){
        for(String option: options){
            findDropdownElement().selectByVisibleText(option);
        }
    }

    public List<String> getSelectedOptions(){
        return findDropdownElement().getAllSelectedOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void allowDropdownMultipleSelection(){
        final String script = "arguments[0].setAttribute('multiple', '')";
        ((JavascriptExecutor)driver).executeScript(script, findDropdownElement());
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(By.id("dropdown")));
    }
}
