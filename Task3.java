import java.util.*;
import cs2030s.fp.*;

public class Task3 {
    public static double getAvgStrength(InfiniteList<Potion> inventory) {
        // List<Potion> arr = inventory.toList();
        // double total = 0.0;
        // for (int i = 0; i < arr.size(); i++) {                  
            // Potion currentPotion = arr.get(i);
            // int currentstrength = currentPotion.getStrength();
            // total += currentstrength;
        // }   
        // return total / arr.size();

        return inventory
          .map(p -> p.getStrength())
          .reduce(0.0, (a,v) -> a + v) / inventory.count();
    }
}
