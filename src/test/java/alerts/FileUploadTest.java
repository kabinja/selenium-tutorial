package alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class FileUploadTest extends BaseTest {
    @Test
    void testFileUpload(){
        final FileUploadPage fileUploadPage = homePage.clickFileUpload();

        Path resourcePath = Paths.get("src","test","resources", "kitten.jpg");
        String absolutePath = resourcePath.toFile().getAbsolutePath();
        fileUploadPage.uploadFile(absolutePath);

        assertEquals(fileUploadPage.getUploadedFiles(), "kitten.jpg");
    }
}
