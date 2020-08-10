package javascript;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTest extends BaseTest {
    @Test
    void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

    @Test
    void testChangeDropdownAttribute(){
        final String option1 = "Option 1";
        final String option2 = "Option 2";

        final DropdownPage dropdownPage = homePage.clickDropdown();
        dropdownPage.allowDropdownMultipleSelection();
        dropdownPage.selectFromDropdown(option1, option2);
        final List<String> selectedOptions = dropdownPage.getSelectedOptions();

        assertEquals(selectedOptions.size(), 2, "Incorrect number of selection");
        assertTrue(selectedOptions.get(0).contains(option1), "Option 1 not selected");
        assertTrue(selectedOptions.get(1).contains(option2), "Option 1 not selected");
    }
}
