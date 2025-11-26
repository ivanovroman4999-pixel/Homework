import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
PasswordChecker checker = new PasswordChecker();

        System.out.println("--- НАСТРОЙКА ЧЕКЕРА ---");

// Блок try-catch для обработки недопустимых настроек (IllegalArgumentException)
        try {
                // 1. Установка минимальной длины
                System.out.print("Введите минимальную длину пароля: ");
int minLen = scanner.nextInt();
            checker.setMinLength(minLen);

// 2. Установка максимального повторения символов
            System.out.print("Введите максимальное количество повторения символов подряд: ");
int maxReps = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после nextInt
            checker.setMaxRepeats(maxReps);

        } catch (IllegalArgumentException e) {
        // Перехват исключения, если пользователь ввел недопустимые значения
        System.out.println("\n[ОШИБКА НАСТРОЙКИ]: " + e.getMessage());
        System.out.println("Программа завершена.");
            return;
                    } catch (InputMismatchException e) {
        // Перехват, если пользователь ввел не число
        System.out.println("\n[ОШИБКА ВВОДА]: Введено неверное значение (ожидалось число).");
            System.out.println("Программа завершена.");
            return;
                    }

                    System.out.println("\n--- Настройки установлены. Чекер готов к работе. ---");
        System.out.println("Введите 'end' для завершения.");

// Бесконечный цикл проверки
        while (true) {
                System.out.print("Введите пароль: ");
// Используем nextLine() для корректного считывания всей строки
String password = scanner.nextLine();

            if (password.equalsIgnoreCase("end")) {
        break;
        }

        try {
boolean result = checker.verify(password);
                System.out.println(result ? "Пароль надёжен (true)" : "Пароль НЕ надёжен (false)");
            } catch (IllegalStateException e) {
        // Перехват, если verify был вызван в недопустимом состоянии
        System.out.println("[СИСТЕМНАЯ ОШИБКА]: " + e.getMessage());
        break;
        }
        }

        System.out.println("Работа программы завершена.");
        scanner.close();
    }
            }