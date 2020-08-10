package navigation;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NavigationTest extends BaseTest {
    @Test
    void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        assertTrue(getPageUrl().endsWith("/dynamic_loading/1"));

        getWindowManager().goBack();
        getWindowManager().refreshPage();
        assertTrue(getPageUrl().endsWith("/dynamic_loading"));

        getWindowManager().goForward();
        assertTrue(getPageUrl().endsWith("/dynamic_loading/1"));

        final String googleUrl = "https://www.google.com/";
        getWindowManager().goTo(googleUrl);
        assertEquals(getPageUrl(), googleUrl);
    }

    @Test
    void testSwitchTab(){
        final String tabName = "New Window";
        homePage.clickMultipleWindow().clickHere();
        getWindowManager().switchToTab(tabName);

        assertEquals(getPageTitle(), tabName);
    }
}
