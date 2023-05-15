package tests;

import app.currency.Dollar;
import app.return_something.FormQualifier;
import app.return_something.Separation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {
    static Separation separation;
    static FormQualifier formQualifier;
    static Dollar dollar;

    @BeforeAll
    static void prepareData(){
        separation = new Separation();
        formQualifier = new FormQualifier(separation);
        dollar = new Dollar(separation, formQualifier);
    }

//      dollar   1 !11
//      dollars  5, 6, 7, 8, 9, 10, 11-19
//      dollars  2, 3, 4

//      cents     indexCurrency = 0
//      dollars   indexCurrency = 1


    @Test
    void showCurrency0_1() {
        assertEquals("cents", dollar.showCurrency((byte) 0, 123456798123456798L));
    }

    @Test
    void showCurrency0_2() {
        assertEquals("cent", dollar.showCurrency((byte) 0, 1));
    }

    @Test
    void showCurrency0_3() {
        assertEquals("cents", dollar.showCurrency((byte) 0, 3));
    }

    @Test
    void showCurrency0_4() {
        assertEquals("cents", dollar.showCurrency((byte) 0, 11));
    }

    @Test
    void showCurrency1_1() {
        assertEquals("dollars", dollar.showCurrency((byte) 1, 123456798123456798L));
    }

    @Test
    void showCurrency1_2() {
        assertEquals("dollar", dollar.showCurrency((byte) 1, 1));
    }

    @Test
    void showCurrency1_3() {
        assertEquals("dollars", dollar.showCurrency((byte) 1, 3));
    }

    @Test
    void showCurrency1_4() {
        assertEquals("dollars", dollar.showCurrency((byte) 1, 11));
    }
}