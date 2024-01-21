import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    @DisplayName("Lengths are positive")
    void positive_length() {
        assertThrows(RuntimeException.class, () -> {
            Length length = new Length(-1, "mm", 20, "mm");
        });
    }
    @Test
    @DisplayName("Valid Unit")
    void valid_units() {
        assertThrows(RuntimeException.class, () -> {
            Length length = new Length(20, "kkm", 102, "mm");
        });
    }
    @Test
    @DisplayName("Convert from mm to cm")
    void convert1() {
        Length length = new Length(20, "mm", 1, "cm");
        assertEquals(2, length.convert());
    }
    @Test
    @DisplayName("Convert from cm to mm")
    void convert2() {
        Length length = new Length(1, "cm", 20, "mm");
        assertEquals(10, length.convert());
    }
    @Test
    @DisplayName("Convert from km to m")
    void convert3() {
        Length length = new Length(3, "km", 20, "m");
        assertEquals(3000, length.convert());
    }
    @Test
    @DisplayName("Convert from m to km")
    void convert4() {
        Length length = new Length(100, "m", 20, "km");
        assertEquals(0.1, length.convert());
    }
    @Test
    @DisplayName("Compare 100 mm with 1 cm")
    void convert5() {
        Length length = new Length(100, "mm", 1, "cm");
        assertTrue(length.compare());
    }
    @Test
    @DisplayName("Compare 1 m with 1000 cm")
    void convert6() {
        Length length = new Length(1, "m", 1000, "cm");
        assertFalse(length.compare());
    }
}