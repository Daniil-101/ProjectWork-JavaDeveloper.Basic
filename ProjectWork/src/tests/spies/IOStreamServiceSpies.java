package tests.spies;

import app.Interfaces.IOService;

import java.util.Scanner;

public class IOStreamServiceSpies implements IOService {
    public String resultOfChecking = "";
    public String aString;
    public long aLong;

    public IOStreamServiceSpies(){};

    public IOStreamServiceSpies(long aLong, String aString) {
        this.aLong = aLong;
        this.aString = aString;
    }

    @Override
    public void outputString(String template, Object... args) {
        resultOfChecking = String.format(template,args);
    }

    @Override
    public String getOutputStringFormat(String template, Object... args) {
        return String.format(template, args);
    }

    @Override
    public void outputString(String message) {
        resultOfChecking = message;
    }

    @Override
    public void outputStringWithWrap(String message) {
        resultOfChecking = message + "\n";
    }

    @Override
    public String inputString() {
        Scanner sc = new Scanner(aString);
        String str = sc.nextLine();
        return str;
    }

    @Override
    public long inputLong() {
        String str = String.valueOf(9223372036854775807L);
        Scanner sc = new Scanner(str);
        long x = sc.nextLong();
        return x;
    }

    @Override
    public void outputArrayInt(int[] numbers) {
        for (int i = 0; i < numbers.length; i++){
            resultOfChecking += numbers[i] + "\n";
        }
    }

    @Override
    public void outputArrayString(String[] str) {
        for (int i = 0; i < str.length; i++){
            resultOfChecking += str[i] + "\n";
        }
    }
}
