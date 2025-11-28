import java.util.HashMap;
import java.util.Map;

public class DeliveryService {
    Map<Address, Integer> costPerAddress = new HashMap<>();
    int totalDeliverySum = 0;
    public boolean processOrder(String country, String city, int weight) {
        Address orderAddress = new Address(country, city); // Создаем объект Address для заказа
        
        if (costPerAddress.containsKey(orderAddress)) {
            int costPerKg = costPerAddress.get(orderAddress);
            int orderCost = costPerKg * weight;
            totalDeliverySum += orderCost; // Добавляем к общей сумме
            
            System.out.println("Стоимость доставки составит: " + orderCost + " руб");
            System.out.println("Общая стоимость всех доставок: " + totalDeliverySum + " руб.");
            return true;
        } else {
            System.out.println("Доставки по этому адресу нет (" + orderAddress + ").");
            return false;
        }
    }
    public void addAddress(Address address, int costPerKg){
        costPerAddress.put(address, costPerKg);
    }
}
