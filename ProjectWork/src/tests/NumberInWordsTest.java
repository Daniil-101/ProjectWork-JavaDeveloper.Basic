package tests;

import app.input_output.IOStreamsService;
import app.print.Request;
import app.return_something.CheckUp;
import app.return_something.FormQualifier;
import app.return_something.NumberInWords;
import app.return_something.Separation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberInWordsTest {

    static IOStreamsService ioStreamsService;
    static Separation separation;
    static FormQualifier formQualifier;
    static CheckUp checkUp;
    static NumberInWords numberInWords;

    @BeforeAll
    static void prepareData(){
        ioStreamsService = new IOStreamsService(System.out, System.in);
        separation = new Separation();
        formQualifier = new FormQualifier(separation);
        checkUp = new CheckUp(new Request());
        numberInWords = new NumberInWords(ioStreamsService, separation, checkUp, formQualifier);
    }

//    "квадролион"  thousandExponent = 0
//    "триллион"    thousandExponent = 1
//    "миллиард"    thousandExponent = 2
//    "миллион"     thousandExponent = 3
//    "тысяча"      thousandExponent = 4
//    ""            thousandExponent = 5

    @Test
    void testGetArrayLengthThousandExponent() {
        assertEquals(6, numberInWords.getArrayLengthThousandExponent());
    }

    @Test
    void run1() {
        assertEquals("ПЯТНАДЦАТЬ тысяч ЧЕТЫРЕСТА ВОСЕМЬДЕСЯТ ЧЕТЫРЕ", numberInWords.run(15484));
    }

    @Test
    void run2() {
        assertEquals("", numberInWords.run(0));
    }

    @Test
    void run4() {
        assertEquals("ДЕВЯТЬСОТ ДЕВЯНОСТО ДЕВЯТЬ квадралионов ДЕВЯТЬСОТ ДЕВЯНОСТО ДЕВЯТЬ триллионов " +
                "ДЕВЯТЬСОТ ДЕВЯНОСТО ДЕВЯТЬ миллиардов ДЕВЯТЬСОТ ДЕВЯНОСТО ДЕВЯТЬ миллионов " +
                "ДЕВЯТЬСОТ ДЕВЯНОСТО ДЕВЯТЬ тысяч ДЕВЯТЬСОТ ДЕВЯНОСТО ДЕВЯТЬ",
                numberInWords.run(999999999999999999L));
    }

    @Test
    void run5() {
        assertEquals("ОДНА тысяча",numberInWords.run(1000));
    }

    @Test
    void run6() {
        assertEquals("ДВЕ тысячи",numberInWords.run(2000));
    }
    @Test
    void run7() {
        assertEquals("ПЯТЬ тысяч",numberInWords.run(5000));
    }

    @Test
    void run8() {
        assertEquals("ПЯТНАДЦАТЬ тысяч",numberInWords.run(15000));
    }

    @Test
    void run9() {
        assertEquals("ДВАДЦАТЬ ОДНА тысяча",numberInWords.run(21000));
    }
}