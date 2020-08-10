package frames;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.TinyMcePage;

import static org.testng.Assert.*;

public class FrameTest extends BaseTest {
    @Test
    void testWysiwyg(){
        final TinyMcePage editorPage = homePage.clickWYSIWYGEditor();
        final String text1 = "hello ";
        final String text2 = "world";

        editorPage.clearTextArea();
        editorPage.setTextArea(text1);
        editorPage.decreaseIndentation();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1 + text2);
    }
}
