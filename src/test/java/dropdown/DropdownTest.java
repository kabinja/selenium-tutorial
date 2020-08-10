package dropdown;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;
import static org.testng.Assert.*;

public class DropdownTest extends BaseTest {
    @Test
    void testSelectOption(){
        final String option = "Option 1";

        final DropdownPage dropdownPage = homePage.clickDropdown();
        dropdownPage.selectFromDropdown(option);
        final List<String> selectedOptions = dropdownPage.getSelectedOptions();

        assertEquals(selectedOptions.size(), 1, "Incorrect number of selection");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
