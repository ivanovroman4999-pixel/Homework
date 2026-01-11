import java.util.*;
import java.util.stream.Stream;

import static java.util.Locale.filter;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b); // тут происходит ошибка при делении на 0
        calc.println.accept(c);

        OnTaskDoneListener listener = System.out::println;
        Worker worker = new Worker(listener);
        worker.start();

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Collections.sort(intList);
        List<Integer> result = new ArrayList<>();
        for(int i : intList){
            if (i > 0 && i%2 == 0){
                result.add(i);
                System.out.println(i);
            }
        }
    }
}

