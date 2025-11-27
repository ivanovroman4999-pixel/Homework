import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>(); 
        while (true){
            System.out.println();
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            Scanner scanner = new Scanner(System.in);
            try {
            System.out.println("Введите число:");
            int input = scanner.nextInt();
                if (input == 0) {
                break;
                }

                if (input == 1){
                    System.out.println("Введите дело:");
                    String a = scanner.next();
                    list.add(a);
                    System.out.println("Дело добавлено!");
                } 

                if (input == 2 && list != null) {
                    for(int i = 0; i<list.size(); i++){
                        System.out.println(i+1 + ". " + list.get(i)); 
                    }
                }
                if (input == 3 && list != null) {
                    System.out.println("Введите номер: ");
                    int a = scanner.nextInt();
                    list.remove(a-1);
                    System.out.println("Удалено!");   
                }
                if (input == 4) {
                    System.out.println("Введите название дела:");
                    String a = scanner.next();
                    for(int i = 0; i< list.size(); i++){
                        if(list.get(i).equals(a)){
                            list.remove(i);
                            System.out.println("Удалено!");   
                        }
                    }
                }
            } catch(Exception e ){
                System.out.print(e+ " ОШИБКА");
            }
        }
    }
}
