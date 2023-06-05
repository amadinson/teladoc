package org.health;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumStringsAsNumberTest {

    private final SumStringsAsNumber sumStringsAsNumber = new SumStringsAsNumber();

    @Test
    void givenStringsAsNumberWhenExecuteThenTheSumIsOk() {
        assertAll(
                () -> assertEquals("123456789012358024579", sumStringsAsNumber.execute("123456789012345678901", "12345678")),
                () -> assertEquals("134", sumStringsAsNumber.execute("123", "11")),
                () -> assertEquals("1000", sumStringsAsNumber.execute("1", "999")),
                () -> assertEquals("123456789012358024589", sumStringsAsNumber.execute(new String[]{"123456789012345678901", "12345678", "10"})),
                () -> assertEquals("134", sumStringsAsNumber.execute(new String[]{"123", "11"})),
                () -> assertThrows(IllegalArgumentException.class, () -> sumStringsAsNumber.execute(new String[]{"A", "80", "5200"})),
                () -> assertThrows(IllegalArgumentException.class, () -> sumStringsAsNumber.execute(new String[]{"109", "err", "5200"})),
                () -> assertThrows(IllegalArgumentException.class, () -> sumStringsAsNumber.execute(new String[]{"109", "210", "aaa"}))
        );
    }
}
