package pages;

import org.openqa.selenium.By;
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

    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        return findDropdownElement().getAllSelectedOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(By.id("dropdown")));
    }
}