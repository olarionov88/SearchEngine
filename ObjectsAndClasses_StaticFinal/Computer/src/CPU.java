public class CPU {
    private final int frequency;
    private final int cores;
    private final String manufacturer;
    private final double weight;

    public CPU(int frequency, int cores, String manufacturer, double weight) {
        this.frequency = frequency;
        this.cores = cores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Процессор (" +
                "Частота: " + frequency +
                ", Кол-во ядер: " + cores +
                ", Производитель: '" + manufacturer + '\'' +
                ", Вес: " + weight +
                ')';
    }
}
