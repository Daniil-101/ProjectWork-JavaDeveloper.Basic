package tests;

import app.Interfaces.IOService;
import tests.fake.PriceInWordsFake;
import app.input_output.IOStreamsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.fake.RequestFake;
import tests.spies.IOStreamServiceSpies;
import tests.stub.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceInWordsTest {
    static IOStreamsService ioStreamService;
    static IOStreamServiceSpies ioStreamServiceSpies;
    static RequestFake request;

    @BeforeAll
    static void prepareData() {
        ioStreamService = new IOStreamsService(System.out, System.in);
        ioStreamServiceSpies = new IOStreamServiceSpies();
        request = new RequestFake(ioStreamServiceSpies);
    }

    @Test
    void testRunExitIsWrittenWithSpaces() {
        IOService ioStreamServiceStub = new IOStubExitIsWrittenWithSpaces();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunExitIsWrittenWithoutSpaces() {
        IOService ioStreamServiceStub = new IOStubExitIsWrittenWithoutSpaces();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveZero() {
        IOService ioStreamServiceStub = new IOStubWeGiveZero();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:ноль\n" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveZeroDotZero() {
        IOService ioStreamServiceStub = new IOStubWeGiveZeroDotZero();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:ноль\n" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveText() {
        IOService ioStreamServiceStub = new IOStubWeGiveText();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:" +
                "Некорректный ввод. Попробуйте еще раз.\n" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveTextDotText() {
        IOService ioStreamServiceStub = new IOStubWeGiveTextDotText();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:" +
                "Некорректный ввод. Попробуйте еще раз.\n" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveNumberDotText() {
        IOService ioStreamServiceStub = new IOStubWeGiveNumberDotText();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:" +
                "Некорректный ввод. Попробуйте еще раз.\n" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveTextDotNumber() {
        IOService ioStreamServiceStub = new IOStubWeGiveTextDotNumber();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:" +
                "Некорректный ввод. Попробуйте еще раз.\n" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveNumberChooseRuble() {
        IOService ioStreamServiceStub = new IOStubWeGiveNumberChooseRuble();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:Выберите валюту:\n"+
        "1. Российский рубль\n" +
        "2. Доллар (США)\n" +
        "3. Евро\n" +
        " СТО ТРИДЦАТЬ ПЯТЬ миллионов ЧЕТЫРЕСТА ШЕСТЬДЕСЯТ ВОСЕМЬ тысяч СТО ОДИН рубль 0 копеек" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveNumberCommaNumberChooseRuble() {
        IOService ioStreamServiceStub = new IOStubWeGiveNumberCommaNumberChooseRuble();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:Выберите валюту:\n"+
                "1. Российский рубль\n" +
                "2. Доллар (США)\n" +
                "3. Евро\n" +
                " СТО ТРИДЦАТЬ ПЯТЬ миллионов ЧЕТЫРЕСТА ШЕСТЬДЕСЯТ ВОСЕМЬ тысяч СТО ОДИН рубль 23 копейки" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }

    @Test
    void testRunWeGiveMinusNumberChooseRuble() {
        IOService ioStreamServiceStub = new IOStubWeGiveMinusNumberChooseRuble();
        PriceInWordsFake priceInWordsFake = new PriceInWordsFake(ioStreamServiceStub);
        priceInWordsFake.run();
        assertEquals("Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:Выберите валюту:\n"+
                "1. Российский рубль\n" +
                "2. Доллар (США)\n" +
                "3. Евро\n" +
                "минус СТО ТРИДЦАТЬ ПЯТЬ миллионов ЧЕТЫРЕСТА ШЕСТЬДЕСЯТ ВОСЕМЬ тысяч СТО ОДИН рубль 0 копеек" +
                "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:", priceInWordsFake.resultOfChecking);
    }
}