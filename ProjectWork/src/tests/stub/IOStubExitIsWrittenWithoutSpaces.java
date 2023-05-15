package tests.stub;

import app.Interfaces.IOService;

public class IOStubExitIsWrittenWithoutSpaces implements IOService {
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
        return "exit";
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
