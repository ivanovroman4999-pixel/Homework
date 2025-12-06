import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeliveryService deliveryService = new DeliveryService();
        Address moscow = new Address("Россия", "Москва");
        Address kazan = new Address("Россия", "Казань");
        Address spb = new Address("Россия", "Санкт-Петербург");
        Address berlin = new Address("Германия", "Берлин");
        Address paris = new Address("Франция", "Париж");
        Address tokio = new Address("Япония", "Токио");
        Address novgorod = new Address("Россия", "Нижний Новгород");
        try {
            deliveryService.addOrUpdateDeliveryCost(moscow, 150.0);
            deliveryService.addOrUpdateDeliveryCost(kazan, 200.0);
            deliveryService.addOrUpdateDeliveryCost(spb, 175.0);
            deliveryService.addOrUpdateDeliveryCost(berlin, 500.0);
            deliveryService.addOrUpdateDeliveryCost(paris, 600.0);
            deliveryService.addOrUpdateDeliveryCost(tokio, 1200.0);
            deliveryService.addOrUpdateDeliveryCost(novgorod, 180.0); 
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при настройке цен доставки: " + e.getMessage());
            return;
        }
        System.out.println("Для завершения введите 'end' вместо страны.");
        while (true) {     
            System.out.print("Введите страну (или 'end' для выхода): ");
            String country = scanner.nextLine();
            if (country.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String city = scanner.nextLine();

            double weight = 0.0;
            try {
                System.out.print("Введите вес (кг): ");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Ошибка: Вес должен быть положительным числом.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введено некорректное значение веса (ожидалось число).");
                continue;
            }

            try {
                deliveryService.processOrder(country, city, weight);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка в данных адреса: " + e.getMessage());
            }
        }
        System.out.printf("Итоговая общая сумма всех доставок: %.2f руб.\n", deliveryService.getTotalDeliverySum());
        System.out.println("Всего доставок было оформлено в " + deliveryService.getUniqueCountriesCount() + " уникальных стран.");
        scanner.close();
    }
}