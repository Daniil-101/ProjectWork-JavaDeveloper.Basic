package tests;

import app.input_output.IOStreamsService;
import app.print.Request;
import app.return_something.CheckUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckUpTest {
    IOStreamsService ioStreamsService;
    Request request = new Request(ioStreamsService);
    CheckUp check;

    @BeforeEach
    void prepareData(){
        check = new CheckUp(request);
    }

    @Test
    void testMethodDotOrCommaCaseDot() {
        assertTrue(check.dotOrComma("12354.25"));
    }

    @Test
    void testMethodDotOrCommaCaseComma() {
        assertTrue(check.dotOrComma("12354,25"));
    }

    @Test
    void testMinus() {
        assertTrue(check.minus("-12354,25"));
    }

    @Test
    void testNotMinus() {
        assertFalse(check.minus("!12354,25"));
    }

    @Test
    void testNotMinus1() {
        assertFalse(check.minus("123-54,25"));
    }

    @Test
    void testIsANumberInTheRangeCurrencyIndex2() {
        assertTrue(check.isANumberInTheRangeCurrencyIndex((byte) 2));
    }

    @Test
    void testIsANumberInTheRangeCurrencyIndex4() {
        assertFalse(check.isANumberInTheRangeCurrencyIndex((byte) 4));
    }

    @Test
    void testIsANumberInTheRangeCurrencyIndex0() {
        assertFalse(check.isANumberInTheRangeCurrencyIndex((byte) 0));
    }

    @Test
    void testDemoIsANumberInTheRangeCurrencyIndex1() {
        assertTrue(check.demoIsANumberInTheRangeCurrencyIndex((byte) 1));
    }

    @Test
    void testDemoIsANumberInTheRangeCurrencyIndex2() {
        assertFalse(check.demoIsANumberInTheRangeCurrencyIndex((byte) 2));
    }

    @Test
    void testDemoIsANumberInTheRangeCurrencyIndex0() {
        assertFalse(check.demoIsANumberInTheRangeCurrencyIndex((byte) 0));
    }

    @Test
    void testThisZero() {
        assertTrue(check.thisZero("0"));
    }

    @Test
    void testThisIsNotZero() {
        assertFalse(check.thisZero("0012"));
    }

    @Test
    void testThisNumber() {
        assertTrue(check.thisNumber("351"));
    }

    @Test
    void testThisIsNotNumber() {
        assertFalse(check.thisNumber("sva"));
    }

    @Test
    void testGoOut() {
        assertTrue(check.goOut("exit"));
    }

    @Test
    void testIsNotGoOut() {
        assertFalse(check.goOut("sva"));
    }

    @Test
    void testLessThanAThousand() {
        assertTrue(check.lessThanAThousand(999));
    }

    @Test
    void testIsNotLessThanAThousand() {
        assertFalse(check.lessThanAThousand(1000));
    }
}