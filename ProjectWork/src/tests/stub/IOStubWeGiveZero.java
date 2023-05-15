package tests.stub;

import app.Interfaces.IOService;

public class IOStubWeGiveZero implements IOService {
    private int count = 0;
    private String str = "";

    @Override
    public void outputString(String template, Object... args) {

    }

    @Override
    public String getOutputStringFormat(String template, Object... args) {
        return null;
    }

    @Override
    public void outputString(String message) {

    }

    @Override
    public void outputStringWithWrap(String message) {

    }

    @Override
    public String inputString() {
        switch (count){
            case (0):
                str = "0";
                count++;
                break;
            case (1):
                str = "exit";
                count++;
                break;
        }
        return str;
    }

    @Override
    public long inputLong() {
        return 0;
    }

    @Override
    public void outputArrayInt(int[] numbers) {

    }

    @Override
    public void outputArrayString(String[] str) {

    }
}
