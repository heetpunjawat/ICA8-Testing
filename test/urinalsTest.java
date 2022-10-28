import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class urinalsTest {

    @Test
    @DisplayName("====== Test Case to see if string has elements other than integers =======")
    void checkString() {
        urinals check = new urinals();
        assertEquals(-1, check.countUrinals("Het"));
    }

}