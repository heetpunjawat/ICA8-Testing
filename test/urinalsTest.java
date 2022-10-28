import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class urinalsTest {

    @Test
    void checkString() {
        urinals check = new urinals();
        assertTrue(check.goodString("Heet"));
    }
}