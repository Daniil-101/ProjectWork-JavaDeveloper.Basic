package app.print;

import app.input_output.IOStreamsService;

public class Request {
    private IOStreamsService ioStreamsService;
    private final String[][] arrayContactingTheUser = {
            {"Введите число:", "Введите число от 0 до 10^17 или команду 'exit' чтобы выйти:"},
            {"Выберите валюту:", "1. Российский рубль", "2. Доллар (США)", "3. Евро"}
    };

    public Request() {}
    public Request(IOStreamsService ioStreamsService) {
        this.ioStreamsService = ioStreamsService;
    }

    public byte getArrayLengthSelectCurrency() {
        return (byte) arrayContactingTheUser[1].length;
    }

    public void printEnterNumber() {
        ioStreamsService.outputString(arrayContactingTheUser[0][0]);
    }

    public void printEnterANumberOrExit() {
        ioStreamsService.outputString(arrayContactingTheUser[0][1]);
    }

    public void printSelectCurrency() {
        ioStreamsService.outputArrayString(arrayContactingTheUser[1]);
    }
}
