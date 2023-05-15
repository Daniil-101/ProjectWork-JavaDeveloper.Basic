package app.input_output;

import app.Interfaces.IOService;

import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;


public class IOStreamsService implements IOService {
    private final PrintStream out;
    private final Scanner in;

    public IOStreamsService(PrintStream out, InputStream in) {
        this.out = out;
        this.in = new Scanner(in);
    }

    @Override
    public void outputString(String template, Object... args) {
        out.printf(template + "%n", args);
    }

    @Override
    public String getOutputStringFormat(String template, Object... args) {
        return String.format(template, args);
    }

    @Override
    public void outputString(String message) {
        out.print(message);
    }

    @Override
    public void outputStringWithWrap(String message) {
        out.println(message);
    }

    @Override
    public String inputString() {
        return in.nextLine();
    }

    @Override
    public long inputLong() {
        return in.nextLong();
    }

    @Override
    public void outputArrayInt(int[] x) {
        for (int i = 0; i < x.length; i++) {
            out.println(x[i] + " " + i);
        }
    }

    @Override
    public void outputArrayString(String[] text) {
        for (int i = 0; i < text.length; i++) {
            out.println(text[i]);
        }
    }
}