public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        for (int i = (int) 'А'; i <= (int) 'я'; i++) {
            System.out.println(i + " - " + (char) i);
        }
        System.out.println((int) 'Ё' + " - Ё");
        System.out.println((int) 'ё' + " - ё");

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

    }
}
