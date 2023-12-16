import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
* Эффективный дворник Дворник средней школы чрезвычайно эффективен. К концу каждого дня все школьные отходы складываются
* в пластиковые пакеты весом от 1,01 до 3,00 фунтов. Все пластиковые пакеты затем выносятся в мусорные баки на улице.
* Одна поездка описывается как выбор нескольких сумок, которые вместе весят не более 3 фунтов, выбрасывание их в
*  мусорное ведро и возвращение в школу. Зная количество пластиковых пакетов n и вес каждого пакета ,
* определите минимальное количество поездок, которые должен совершить дворник.
* */
public class EffiecientJanitor {
    public static int efficientJanitor(List<Float> weight) {
        int trips = 0;

        if (weight.isEmpty()) {
            return trips;
        }

        Collections.sort(weight);

        int i = 0, j = weight.size() - 1;
        while (i <= j) {
            if (weight.get(i) + weight.get(j) <= 3.0f) {
                // The janitor collects two bags
                i++;
            }
            // The janitor has to make a separate trip for the heavier bag
            j--;
            trips++;
        }

        return trips;
    }

    public static void main(String[] args) {
        List<Float> weights = new ArrayList<>(Arrays.asList(1.0f, 1.1f, 1.4f, 1.8f, 2.4f));
        System.out.println(efficientJanitor(weights));  // Should print: 3
    }
}
