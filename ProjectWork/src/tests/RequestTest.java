package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.spies.IOStreamServiceSpies;
import tests.fake.RequestFake;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {
    IOStreamServiceSpies ioStreamServiceSpies = new IOStreamServiceSpies();
    RequestFake requestFake;

    @BeforeEach
    void prepareData(){
        requestFake = new RequestFake(ioStreamServiceSpies);
    }

    @Test
    void testGetArrayLengthSelectCurrency() {
        assertEquals(4, requestFake.getArrayLengthSelectCurrency());
    }

    @Test
    void testPrintEnterNumber() {
        requestFake.printEnterNumber();
        assertEquals("Введите число:", requestFake.resultOfChecking);
    }

    @Test
    void testPrintEnterANumberOrExit() {
        requestFake.printEnterANumberOrExit();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", requestFake.resultOfChecking);
    }

    @Test
    void testPrintSelectCurrency() {
        requestFake.printSelectCurrency();
        assertEquals("Выберите валюту:\n" + "1. Российский рубль\n" + "2. Доллар (США)\n" + "3. Евро\n",
                requestFake.resultOfChecking);
    }
}