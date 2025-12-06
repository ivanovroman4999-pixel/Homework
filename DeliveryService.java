import java.util.HashMap;
import java.util.HashSet; 
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class DeliveryService {
    private Map<Address, Double> costPerAddress;
    private double totalDeliverySum = 0.0; 
    private Set<String> uniqueCountriesDelivered; 

    public DeliveryService() {
        this.costPerAddress = new HashMap<>();
        this.uniqueCountriesDelivered = new HashSet<>();
    }
    public void addOrUpdateDeliveryCost(Address address, double costPerKg) {
        if (costPerKg < 0) {
            throw new IllegalArgumentException("Стоимость доставки не может быть отрицательной.");
        }
        costPerAddress.put(address, costPerKg);
        System.out.println("Добавлена/обновлена цена доставки для " + address + ": " + costPerKg + " руб/кг");
    }
    public boolean processOrder(String country, String city, double weight) {
        if (country == null || country.trim().isEmpty() || city == null || city.trim().isEmpty()) {
            System.out.println("Ошибка: Страна или город не могут быть пустыми.");
            return false;
        }

        Address orderAddress = new Address(country, city);
        
        if (costPerAddress.containsKey(orderAddress)) {
            double costPerKg = costPerAddress.get(orderAddress);
            double orderCost = costPerKg * weight;
            totalDeliverySum += orderCost;

            uniqueCountriesDelivered.add(orderAddress.getCountry()); 
            
            System.out.print("Стоимость доставки составит:" + orderCost + " руб.");
            System.out.print("Общая стоимость всех доставок: " + totalDeliverySum + "руб.");
            System.out.println("Доставки выполнены в " + uniqueCountriesDelivered.size() + " уникальных стран."); 
            return true;
        } else {
            System.out.println("Доставки по этому адресу нет (" + orderAddress + ").");
            return false;
        }
    }
    public double getTotalDeliverySum() {
        return totalDeliverySum;
    }
     public int getUniqueCountriesCount() {
        return uniqueCountriesDelivered.size();
    }
    public Map<Address, Double> getCostPerAddress() {
        return costPerAddress;
    }
}
