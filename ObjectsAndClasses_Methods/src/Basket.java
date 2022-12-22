public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int totalItems = 0;
    private static int totalCost = 0;


    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }
    public static int getTotalItems() {
        return totalItems;
    }

    public static int getTotalCost() {
        return totalCost;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseTotalItems(int totalItems) {
        Basket.totalItems = Basket.totalItems + totalItems;
    }

    public static void increaseTotalCost(int count, int price) {
        Basket.totalCost = Basket.totalCost + count * price;
    }


    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static int allAverageCost() {
        return Basket.totalCost / Basket.totalItems;
    }

    public static int averageCostOfBasket() {
        return Basket.totalCost / Basket.count;
    }

    public void add(String name, int price) {
        add(name, price, 1,0);
    }

    public void add(String name, int price, int count) {
        add(name, price, count,0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. Вес: " + weight + " - " + price;
        increaseTotalItems(1);
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight;
        increaseTotalCost(count, price);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
