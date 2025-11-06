import java.util.*;
import cs2030s.fp.*;

public class Task4 {
    public static int getMaxStrength(String name, InfiniteList<Potion> inventory) {
        // List<Potion> arr = inventory.toList();
        // int max = 0;
        // for (int i = 0; i < arr.size(); i++) {
            // Potion currentPotion = arr.get(i);
            // String currentName = currentPotion.getName();
            // int currentStrength = currentPotion.getStrength();
            // if (currentName.equals(name) && currentStrength > max) {
                // max = currentStrength;
            // }
        // }
        // return max;

        return inventory
          .filter(p -> p.getName() == name)
          .map(p -> p.getStrength())
          .reduce(0, (a,v) -> Math.max(a,v));
    }    
}
