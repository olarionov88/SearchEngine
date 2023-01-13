import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws ExceptionSplit, ExceptionPhone, ExceptionEmail{
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if(components.length != 4) {
            throw new ExceptionSplit("Неверный формат ввода");
        }
        if(!components[2].matches("[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+")){
            throw new ExceptionEmail("Неверно введен email");
        }
        if(!components[3].matches("\\+79[0-9]{9}")){
            throw new ExceptionPhone("Неверно введен телефон");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}