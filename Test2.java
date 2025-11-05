import cs2030s.fp.InfiniteList;

public class Test2 {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

   
    
   
    Potion a = new Potion("Healing", 100); 
    Potion b = new Potion("Might", 60);    
    Potion c = new Potion("Healing", 40);  
    Potion d = new Potion("Invisibility", 20); 
    Potion e = new Potion("Healing", 100).unseal().drink(25); 
    Potion f = new Potion("Healing", 100).unseal().drink(30); 
    

    Potion[] potionsA = new Potion[] { a, b, c, d, e, f };
    InfiniteList<Potion> listA = InfiniteList.iterate(0, x -> x + 1)
        .limit(potionsA.length)
        .map(i -> potionsA[i]);

    we.expect(
        "Test A: Only unsealed Healing potions are counted (total 45)",
        () -> Task2.countHealingDoses(listA) == 45,
        true
    );

    
    
    
    Potion[] potionsB = new Potion[] {
      new Potion("Healing", 10),
      new Potion("Healing", 20),
      new Potion("Healing", 30)
    };
    InfiniteList<Potion> listB = InfiniteList.iterate(0, x -> x + 1)
        .limit(potionsB.length)
        .map(i -> potionsB[i]);

    we.expect(
        "Test B: All Healing potions sealed → total 0",
        () -> Task2.countHealingDoses(listB) == 0,
        true
    );

    
    
    
    Potion[] potionsC = new Potion[] {
      new Potion("Strength", 10).unseal(),
      new Potion("Invisibility", 50).unseal(),
      new Potion("Mana", 100).unseal()
    };
    InfiniteList<Potion> listC = InfiniteList.iterate(0, x -> x + 1)
        .limit(potionsC.length)
        .map(i -> potionsC[i]);

    we.expect(
        "Test C: Non-Healing potions ignored → total 0",
        () -> Task2.countHealingDoses(listC) == 0,
        true
    );

    
    
    
    Potion[] potionsD = new Potion[] {
      new Potion("Healing", 5).unseal(),      
      new Potion("Healing", 10).unseal(),     
      new Potion("Healing", 20).unseal().drink(10) 
    };
    InfiniteList<Potion> listD = InfiniteList.iterate(0, x -> x + 1)
        .limit(potionsD.length)
        .map(i -> potionsD[i]);

    we.expect(
        "Test D: All Healing potions unsealed → total 140",
        () -> Task2.countHealingDoses(listD) == 140,
        true
    );

    
    
    
    
    InfiniteList<Potion> listE = InfiniteList
        .iterate(1, x -> x + 1)
        .map(i -> {
          if (i <= 4) return new Potion("Healing", i).unseal();
          else return new Potion("Might", i);
        })
        .limit(10); 

    we.expect(
        "Test E: Lazy evaluation works, only first 4 unsealed Healing counted",
        () -> Task2.countHealingDoses(listE) == 4 * 50,
        true
    );
  }
}
