import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Address moscow = new Address("Россия", "Москва");
        Address kazan = new Address("Россия", "Казань");
        Address spb = new Address("Россия", "Санкт-Петербург");
        Address berlin = new Address("Германия", "Берлин");
        Address paris = new Address("Франция", "Париж");
        Address tokio = new Address("Япония", "Токио");
        DeliveryService deliveryService = new DeliveryService();
       try{
        deliveryService.addAddress(tokio, 50);
        deliveryService.addAddress(paris, 26);
        deliveryService.addAddress(berlin, 54);
        deliveryService.addAddress(spb, 32);
        deliveryService.addAddress(kazan, 84);
        deliveryService.addAddress(moscow, 24);
       } catch (Exception e ){
        System.out.print(e + "Ошибка в загрузке в мапу");
       }
       Scanner scanner = new Scanner(System.in);
       while (true) {
        System.out.println("Введите страну или end: ");
        String country = scanner.next();
        if (country.equals("end")){
            break;
        }
        System.out.println("Введите город: ");
        String city = scanner.next();
        System.out.println("Введите вес (кг): ");
        int weight = scanner.nextInt();
        deliveryService.processOrder(country, city, weight);
       }
       scanner.close();
    }
}
