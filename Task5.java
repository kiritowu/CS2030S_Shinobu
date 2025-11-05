import java.util.*;
import cs2030s.fp.*;

public class Task5 {
    public static InfiniteList<Potion> splitStrongPotions(InfiniteList<Potion> inventory) {
        List<Potion> arr = inventory.toList();        
        List<Potion> resultArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            Potion currentPotion = arr.get(i);
            String name = currentPotion.getName();
            int strength = currentPotion.getStrength();
            if (strength > 1) {
                if (strength % 2 == 1) {
                    // if it is odd:
                    resultArr.add(new Potion(name, (strength/2)));
                    resultArr.add(new Potion(name, (strength/2) + 1));
                } else {                    
                    resultArr.add(new Potion(name, (strength/2)));
                    resultArr.add(new Potion(name, (strength/2)));
                }
            } else {
                resultArr.add(currentPotion);
            }
        }

        InfiniteList<Potion> res = InfiniteList.iterate(0, x -> x + 1)
                                                .limit(resultArr.size())
                                                .map(idx -> resultArr.get(idx));

        return res;
    }    
}
