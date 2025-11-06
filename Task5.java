import java.util.*;
import cs2030s.fp.*;

public class Task5 {
    public static InfiniteList<Potion> splitStrongPotions(InfiniteList<Potion> inventory) {
        // List<Potion> arr = inventory.toList();        
        // List<Potion> resultArr = new ArrayList<>();
        // for (int i = 0; i < arr.size(); i++) {
            // Potion currentPotion = arr.get(i);
            // String name = currentPotion.getName();
            // int strength = currentPotion.getStrength();
            // if (strength > 1) {
                // if (strength % 2 == 1) {
                    // // if it is odd:
                    // resultArr.add(new Potion(name, (strength/2)));
                    // resultArr.add(new Potion(name, (strength/2) + 1));
                // } else {                    
                    // resultArr.add(new Potion(name, (strength/2)));
                    // resultArr.add(new Potion(name, (strength/2)));
                // }
            // } else {
                // resultArr.add(currentPotion);
            // }
        // }
// 
        // InfiniteList<Potion> res = InfiniteList.iterate(0, x -> x + 1)
                                                // .limit(resultArr.size())
                                                // .map(idx -> resultArr.get(idx));
// 
        // return res;
        //
        return inventory
          .flatMap(p -> 
              Maybe.of(p)
                .filter(x -> x.getStrength() > 1)
                .map(x -> 
                  Maybe.of(x)
                    .filter(y -> y.getStrength() % 2 == 1)
                    .map(y -> InfiniteList
                      .iterate(
                        y.dilute((y.getStrength()+1) / 2), u -> u.enhance(1))
                      .limit(2))
                    .orElseGet(
                      () -> InfiniteList.generate(() -> x.dilute(x.getStrength() / 2)).limit(2)
                      )
                )
                .orElseGet(() -> InfiniteList.generate(()->p).limit(1))
          );
    }    
}
