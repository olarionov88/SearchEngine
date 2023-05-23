import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Generator implements Runnable {

    public int regionCode;
    public PrintWriter writer;
    public StringBuilder builder;

    final char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    public Generator(int regionCode) throws FileNotFoundException {
        writer = new PrintWriter("res/numbers" + regionCode + ".txt");
        builder = new StringBuilder();
        this.regionCode = regionCode;
    }
    @Override
    public void run() {
        String regionCodeStr = String.valueOf(padNumber(regionCode, 2));
        for (int number = 1; number < 1000; number++) {
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        builder.append(firstLetter);
                        builder.append(padNumber(number, 3));
                        builder.append(secondLetter);
                        builder.append(thirdLetter);
                        //builder.append(padNumber(regionCode, 2));
                        builder.append(regionCodeStr);
                        builder.append("\n");

                    }
                }
            }
        }
        writer.write(builder.toString());
        writer.flush();
        writer.close();

    }

    private static StringBuilder padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        StringBuilder padNumbers = new StringBuilder();
        padNumbers.append("0".repeat(Math.max(0, padSize)));
        padNumbers.append(numberStr);
        return padNumbers;
    }
}