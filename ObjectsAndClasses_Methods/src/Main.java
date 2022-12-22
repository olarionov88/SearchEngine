public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        //basket.print("Milk");

        Basket basket2 = new Basket();
        basket2.add("Tea", 50);
        basket2.add("Tea1", 10);
        basket.add("Tea12",100);

        System.out.println(basket.getTotalPrice());
        System.out.println(basket2.getTotalPrice());
        System.out.println("Товары во всех корзинах: " + Basket.getTotalItems());
        System.out.println("Стоимость всех товаров в корзинах: " + Basket.getTotalCost());
        System.out.println("Кол-во корзин: " + Basket.getCount());
        System.out.println("Сред цена во всех корзинах: " + Basket.allAverageCost());
        System.out.println("Сред стоимость корзины: " + Basket.averageCostOfBasket());
    }
}
