package tests;

import app.return_something.Separation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparationTest {

    Separation separation;

    @BeforeEach
    void prepareData(){
        separation = new Separation();
    }

    @Test
    void getArrayThreeDigitSegment() {
        assertArrayEquals(new int[6], separation.getArrayThreeDigitSegment());
    }

    @Test
    void getTheLastThreeDigits() {
        assertEquals(879, separation.getTheLastThreeDigits(123464864613879L));
    }

    @Test
    void divideANumberIntoAThreeDigitSegment() {
        assertArrayEquals(new int[]{0, 123, 464, 864, 613, 879},
                separation.divideANumberIntoAThreeDigitSegment(123464864613879L));
    }

    @Test
    void firstNumberOfThreeDigitSegment() {
        assertEquals(1,separation.firstNumberOfThreeDigitSegment(123));
    }

    @Test
    void secondNumberOfThreeDigitSegment() {
        assertEquals(2,separation.secondNumberOfThreeDigitSegment(123));
    }

    @Test
    void thirdNumberOfThreeDigitSegment() {
        assertEquals(3,separation.thirdNumberOfThreeDigitSegment(123));
    }

    @Test
    void secondAndThirdNumberOfThreeDigitSegment() {
        assertEquals(23,separation.secondAndThirdNumberOfThreeDigitSegment(123));
    }

    @Test
    void getTwoDecimalPlacesAfterTheDecimalPoint() {
        assertEquals("21", separation.getTwoDecimalPlacesAfterTheDecimalPoint("123546,212354"));
    }

    @Test
    void extractingAnInteger() {
        assertEquals("0", separation.extractingAnInteger(",123"));
    }
}