package edu.estatuas.romansgohome.test;

import edu.estatuas.romansgohome.RomanNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumberTests {

    @ParameterizedTest
    @CsvSource({
            "274,  CCLXXIV",
            "287,  CCLXXXVII",
            "295,  CCXCV",
            "429,  CDXXIX",
            "330,  CCCXXX",
            "783,  DCCLXXXIII",
            "121,  CXXI",
            "552,  DLII",
            "386,  CCCLXXXVI",
            "909,  CMIX",
    })
    void testSimpleRomanNumber(int numero, String romano){
        RomanNumber romanNumber = new RomanNumber(romano);
        assertEquals(numero, romanNumber.toDecimal());
    }
}
