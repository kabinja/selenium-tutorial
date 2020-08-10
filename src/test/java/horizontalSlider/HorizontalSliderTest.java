package horizontalSlider;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTest extends BaseTest {
    @Test
    void testMoveTo4(){
        final HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSliderBy(8);

        assertEquals(horizontalSliderPage.getRange(), String.valueOf(4));
    }
}
