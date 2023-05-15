package app.Interfaces;

public interface IOService {
    void outputString(String template, Object... args);

    String getOutputStringFormat(String template, Object... args);

    void outputString(String message);

    void outputStringWithWrap(String message);

    String inputString();

    long inputLong();

    void outputArrayInt(int[] numbers);

    void outputArrayString(String[] str);
}
