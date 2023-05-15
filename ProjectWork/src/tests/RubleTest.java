package tests;

import app.currency.Ruble;
import app.return_something.FormQualifier;
import app.return_something.Separation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RubleTest {

    static Separation separation;
    static FormQualifier formQualifier;
    static Ruble ruble;

    public void run(){
        prepareData();
        showCurrency0_1();
        showCurrency0_2();
        showCurrency0_3();
        showCurrency0_4();
        showCurrency1_1();
        showCurrency1_2();
        showCurrency1_3();
        showCurrency1_4();
    }

    @BeforeAll
    static void prepareData(){
        separation = new Separation();
        formQualifier = new FormQualifier(separation);
        ruble = new Ruble(separation, formQualifier);
    }

//      рубль  1 !11
//      рублей 5, 6, 7, 8, 9, 10, 11-19
//      рубля  2, 3, 4

//      копейки     indexCurrency = 0
//      рубли       indexCurrency = 1

    @Test
    void showCurrency0_1() {
        assertEquals("копеек", ruble.showCurrency((byte) 0, 123456798123456798L));
    }

    @Test
    void showCurrency0_2() {
        assertEquals("копейка", ruble.showCurrency((byte) 0, 1));
    }

    @Test
    void showCurrency0_3() {
        assertEquals("копейки", ruble.showCurrency((byte) 0, 3));
    }

    @Test
    void showCurrency0_4() {
        assertEquals("копеек", ruble.showCurrency((byte) 0, 11));
    }

    @Test
    void showCurrency1_1() {
        assertEquals("рублей", ruble.showCurrency((byte) 1, 123456798123456798L));
    }

    @Test
    void showCurrency1_2() {
        assertEquals("рубль", ruble.showCurrency((byte) 1, 1));
    }

    @Test
    void showCurrency1_3() {
        assertEquals("рубля", ruble.showCurrency((byte) 1, 3));
    }

    @Test
    void showCurrency1_4() {
        assertEquals("рублей", ruble.showCurrency((byte) 1, 11));
    }
}