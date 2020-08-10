package hover;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.*;

public class HoverTest extends BaseTest {
    @Test
    void testHoverUser1(){
        final HoversPage hoversPage = homePage.clickHovers();
        final HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(0);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Wrong caption title for User 1");
        assertEquals(caption.getLinkText(), "View profile", "Wrong link text in caption for User 1");
        assertTrue(caption.getLink().endsWith("/users/1"), "Wrong link in caption for User 1");
    }
}
