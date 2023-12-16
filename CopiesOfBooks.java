import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CopiesOfBooks {
    public static void main(String[] args) {
        List<Integer> portalUpdates = Arrays.asList(6, 6, 2, -6, -2, -6,-2,-6);
        System.out.println(maxCopiesOfBooks(portalUpdates));
//        Outputs: [1, 2, 2, 1, 1, 0]
    }

    private static List<Integer> maxCopiesOfBooks(List<Integer> portalUpdates) {
        Map<Integer, Integer> inventory = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> result = new ArrayList<>();

        for (int update : portalUpdates) {
            if (update > 0) {
                // Add book to inventory
                maxHeap.remove(inventory.get(update));
                inventory.put(update, inventory.getOrDefault(update, 0) + 1);
                maxHeap.add(inventory.get(update));
            } else {
                // Remove book from inventory
                int bookId = -update;
                maxHeap.remove(inventory.get(bookId));
                inventory.put(bookId, inventory.get(bookId) - 1);
                if (inventory.get(bookId) >= 0) {
                    maxHeap.add(inventory.get(bookId));
                }
            }
            // Add max count to result
            if (maxHeap.isEmpty()) {
                result.add(0);
            } else {
                result.add(maxHeap.peek());
            }
        }
        return result;
    }
}
