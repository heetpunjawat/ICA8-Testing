import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.File;
import java.net.URL;

class urinalsTest {

    @Test
    @DisplayName("====== Test Case to see if string has elements other than integers =======")
    void checkString() {
        urinals check = new urinals();
        assertEquals(-1, check.countUrinals("Heet"));
    }

    @Test
    @DisplayName("====== Test Case for File Exists =======")
    void fileNotFound()  {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL fileURL = classLoader.getResource("urinal.dat");
        assert fileURL != null;
        File file = new File(fileURL.getFile());
        assertTrue(file.exists());
    }
    @Test
    @DisplayName("====== Test Case for Non Empty File =======")
    void emptyFile()  {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("urinal.dat").getFile());
        assertTrue(file.length() != 0);
    }

}