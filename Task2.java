import java.util.*;
import cs2030s.fp.*;

public class Task2 {
    public static int countHealingDoses(InfiniteList<Potion> inventory) {
        // List<Potion> arr = inventory.toList();
        // int res = 0;
        // for (int i = 0; i < arr.size(); i++) {
            // if (arr.get(i).isSealed() == false) {
                // if (arr.get(i).getName() == "Healing") {
                    // res += arr.get(i).getDoses();
                // }
            // }
        // }
        // return res;

        return inventory
          .filter(p -> !p.isSealed())
          .filter(p -> p.getName() == "Healing")
          .map(p -> p.getDoses())
          .reduce(0, (a,v) -> a + v);
    }    
}
