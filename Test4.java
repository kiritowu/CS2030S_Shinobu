import cs2030s.fp.*;

public class Test4 {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    Potion[] potionsA = new Potion[] {
      new Potion("Healing", 10),
      new Potion("Healing", 25),
      new Potion("Might", 40),
      new Potion("Healing", 18)
    };
    InfiniteList<Potion> listA = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsA.length)
        .map(i -> potionsA[i]);

    we.expect(
        "Test A: Max strength of 'Healing' potions is 25",
        () -> Task4.getMaxStrength("Healing", listA) == 25,
        true
    );

    Potion[] potionsB = new Potion[] {
      new Potion("Healing", 5),
      new Potion("Might", 20),
      new Potion("Might", 40),
      new Potion("Invisibility", 10)
    };
    InfiniteList<Potion> listB = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsB.length)
        .map(i -> potionsB[i]);

    we.expect(
        "Test B: Max strength of 'Might' potions is 40",
        () -> Task4.getMaxStrength("Might", listB) == 40,
        true
    );

    Potion[] potionsC = new Potion[] {
      new Potion("Healing", 7),
      new Potion("Might", 12),
      new Potion("Focus", 50)
    };
    InfiniteList<Potion> listC = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsC.length)
        .map(i -> potionsC[i]);

    we.expect(
        "Test C: Only one 'Focus' potion -> max = 50",
        () -> Task4.getMaxStrength("Focus", listC) == 50,
        true
    );

    Potion[] potionsD = new Potion[] {
      new Potion("Healing", 10),
      new Potion("Might", 15),
      new Potion("Invisibility", 20)
    };
    InfiniteList<Potion> listD = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsD.length)
        .map(i -> potionsD[i]);

    we.expect(
        "Test D: No 'Focus' potion -> max = 0",
        () -> Task4.getMaxStrength("Focus", listD) == 0,
        true
    );

    Potion[] potionsE = new Potion[] {
      new Potion("Healing", 5),
      new Potion("Healing", 10),
      new Potion("Healing", 15),
      new Potion("Healing", 20)
    };
    InfiniteList<Potion> listE = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsE.length)
        .map(i -> potionsE[i]);

    we.expect(
        "Test E: Sequential Healing potions -> max = 20",
        () -> Task4.getMaxStrength("Healing", listE) == 20,
        true
    );
  }
}
