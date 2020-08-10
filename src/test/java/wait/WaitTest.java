package wait;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.*;

public class WaitTest extends BaseTest {
    @Test
    void testWaitUntilHiddenWithExplicitWait(){
        final DynamicLoadingExample1Page loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartWithExplicitWait();

        assertEquals(loadingPage.getLoadedText(), "Hello World!");
    }

    @Test
    void testWaitUntilHiddenWithFluentWait(){
        final DynamicLoadingExample1Page loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartWithFluentWait();

        assertEquals(loadingPage.getLoadedText(), "Hello World!");
    }

    @Test
    void testWaitUntilExist(){
        final DynamicLoadingExample2Page loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStartWithFluentWait();

        assertEquals(loadingPage.getLoadedText(), "Hello World!");
    }
}
