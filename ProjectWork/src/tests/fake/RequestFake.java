package tests.fake;

import app.print.Request;
import tests.spies.IOStreamServiceSpies;

public class RequestFake extends Request {

    public String resultOfChecking = "";
    IOStreamServiceSpies ioStreamServiceSpies;
    private final String[][] arrayContactingTheUser = {
            {"Введите число:", "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:"},
            {"Выберите валюту:", "1. Российский рубль", "2. Доллар (США)", "3. Евро"}};

    public RequestFake(IOStreamServiceSpies ioStreamServiceSpies) {
        super();
        this.ioStreamServiceSpies = ioStreamServiceSpies;
    }


    public byte getArrayLengthSelectCurrency() {
        return (byte) arrayContactingTheUser[1].length;
    }

    public void printEnterNumber() {
        ioStreamServiceSpies.outputString(arrayContactingTheUser[0][0]);
        resultOfChecking += ioStreamServiceSpies.resultOfChecking;
    }

    public void printEnterANumberOrExit() {
        ioStreamServiceSpies.outputString(arrayContactingTheUser[0][1]);
        resultOfChecking += ioStreamServiceSpies.resultOfChecking;
    }

    public void printSelectCurrency() {
        ioStreamServiceSpies.outputArrayString(arrayContactingTheUser[1]);
        resultOfChecking += ioStreamServiceSpies.resultOfChecking;
    }
}
