import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.File;
import java.net.URL;

class urinalsTest {

    @Test
    @DisplayName("====== Test Case 1. To see if string has elements other than integers =======")
    void checkString() {
        urinals check = new urinals();
        assertEquals(-1, check.countUrinals("Heet"));
    }

    @Test
    @DisplayName("====== Test Case 2. To check file existence =======")
    void fileNotFound()  {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL fileURL = classLoader.getResource("urinal.dat");
        assert fileURL != null;
        File file = new File(fileURL.getFile());
        assertTrue(file.exists());
    }
    @Test
    @DisplayName("====== Test Case 3. To check for a non empty file =======")
    void emptyFile()  {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("urinal.dat").getFile());
        assertTrue(file.length() != 0);
    }

    @Test
    @DisplayName("====== Test Case 4.  =======")
    void checkGoodString() {
        int check = urinals.countUrinals("01010");
        assertEquals(0, check);
    }

    @Test
    @DisplayName("====== Test case 5. Checks if any two 1s are together =======")
    void checkBadString() {
        int check = urinals.countUrinals("0101100");
        assertEquals(-1, check);
    }

    @Test
    @DisplayName("====== Test Case 6. Tests if length of string >20 =======")
    void checkStringLength() {
        int check = urinals.countUrinals("010101010101010101010101010101");
        assertEquals(-1, check);
    }

    @Test
    @DisplayName("====== Test Case 7 =======")
    void countUrinals1()
    {
        int count = urinals.countUrinals("10001");
        assertEquals(1, count);

    }
    @Test
    @DisplayName("====== Test Case 8 =======")
    void countUrinals2()
    {
        int count = urinals.countUrinals("00000");
        assertEquals(3, count);
    }

}