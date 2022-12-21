import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(3,4,5);

        Delivery delivery = new Delivery(
                dimensions,
                10,
                "Chelyabinsk",
                true,
                "F3244FE43",
                false);
        System.out.println("Оригинал:");
        System.out.println(delivery);

        System.out.println(delivery.setDimensions(dimensions.setHeight(7)));
        System.out.println(delivery.setAddress("Ufa"));
        System.out.println(delivery.setWeight(33));

        // Можно еще так: в этом случае объект сохранится (копия с изменнным весом)
        // и можно будет его как-то еще использовать
        Delivery copyWeight = delivery.setWeight(20);
        System.out.println(copyWeight);

        System.out.println("Оригинал не изменился:");
        System.out.println(delivery);

    }
}
