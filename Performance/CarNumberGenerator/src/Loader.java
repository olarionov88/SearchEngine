import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader
{
    public static PrintWriter writer;
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();

        writer = new PrintWriter("res/numbers.txt");
        final char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        for (int regionCode = 1; regionCode < 100; regionCode++) {
            service.submit(new Generator(regionCode));
        }
        service.shutdown();

        while (!service.isTerminated()) {
        }

        System.out.println("Время выполнения в 4 потока - " + (System.currentTimeMillis() - start) + " ms");

    }
}