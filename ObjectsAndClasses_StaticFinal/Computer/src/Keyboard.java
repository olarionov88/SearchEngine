public class Keyboard {
    private final KeyboardType type;
    private final boolean backlight;
    private final double weight;

    public Keyboard(KeyboardType type, boolean backlight, double weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Клавиатура (" +
                "Тип: " + type +
                ", Подсветка:" + (backlight == true ? "Да" : "Нет") +
                ", Вес: " + weight +
                ')';
    }
}
