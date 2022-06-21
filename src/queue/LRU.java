package queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LRU {

    private static final String HIT = "HIT";
    private static final String MISS = "MISS";
    private static final Map<String, Integer> HIT_AND_MISS = new HashMap<>();

    static {
        HIT_AND_MISS.put(HIT,0);
        HIT_AND_MISS.put(MISS,0);
    }

    public static void main(String[] args) {

        int []arr = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};

        hitAndMis(arr,4);

        System.out.print("\n\nHit and miss : " + HIT_AND_MISS);
    }

    public static void hitAndMis(int[] arr, int frame) {

        Set<Integer> set = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {

            int x = arr[i];

            if(!set.contains(x)) {
                if(queue.size() == frame) {
                    Integer last = queue.removeLast();
                    set.remove(last);
                }
                HIT_AND_MISS.put(MISS,HIT_AND_MISS.get(MISS) + 1);
            } else {
                int index = 0;
                Iterator<Integer> itr = queue.iterator();
                while(itr.hasNext()) {
                    Integer next = itr.next();
                    if(next.intValue() == x) {
                        break;
                    }
                    index++;
                }
                queue.remove(index);
                HIT_AND_MISS.put(HIT,HIT_AND_MISS.get(HIT) + 1);
            }

            queue.push(x);
            set.add(x);

            System.out.print("\nInput : " + x + "\tHIT : " + HIT_AND_MISS.get(HIT) + "\tMISS : " + HIT_AND_MISS.get(MISS)  + "\tHash : " + set + "\tQueue : " + queue);
        }
    }
}
