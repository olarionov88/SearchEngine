public class Dimensions {
    private final int width;
    private final int height;
    private final int length;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Dimensions setWidth(int width) {
        Dimensions copy = new Dimensions(width, height, length);
        return copy;
    }

    public Dimensions setHeight(int height) {
        Dimensions copy = new Dimensions(width, height, length);
        return copy;
    }

    public Dimensions setLength(int length) {
        Dimensions copy = new Dimensions(width, height, length);
        return copy;
    }

    public int getVolume() {
        return width * height * length;
    }

    public String toString() {
        return width + "x" + height + "x" + length + "\n" +
                "Объем: " + getVolume();
    }
}
