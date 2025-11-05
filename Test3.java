import cs2030s.fp.InfiniteList;

public class Test3 {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    Potion[] potionsA = new Potion[] {
      new Potion("Healing", 10),
      new Potion("Might", 20),
      new Potion("Focus", 30)
    };
    InfiniteList<Potion> listA = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsA.length)
        .map(i -> potionsA[i]);

    we.expect(
        "Test A: Average of [10,20,30] is 20.0",
        () -> Math.abs(Task3.getAvgStrength(listA) - 20.0) < 1e-9,
        true
    );

    Potion[] potionsB = new Potion[] { new Potion("Healing", 42) };
    InfiniteList<Potion> listB = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsB.length)
        .map(i -> potionsB[i]);

    we.expect(
        "Test B: Single element [42] → average 42.0",
        () -> Math.abs(Task3.getAvgStrength(listB) - 42.0) < 1e-9,
        true
    );

    Potion[] potionsC = new Potion[] {
      new Potion("Healing", 10),
      new Potion("Might", 20),
      new Potion("Focus", 31)
    };
    InfiniteList<Potion> listC = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsC.length)
        .map(i -> potionsC[i]);

    we.expect(
        "Test C: Fractional average (10+20+31)/3 = 20.3333",
        () -> Math.abs(Task3.getAvgStrength(listC) - 20.3333333333) < 1e-9,
        true
    );

    Potion[] potionsD = new Potion[] {
      new Potion("Healing", 9),
      new Potion("Might", 10)
    };
    InfiniteList<Potion> listD = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsD.length)
        .map(i -> potionsD[i]);

    we.expect(
        "Test D: Average (9+10)/2 = 9.5",
        () -> Math.abs(Task3.getAvgStrength(listD) - 9.5) < 1e-9,
        true
    );

    Potion[] potionsE = new Potion[] {
      new Potion("Healing", 7),
      new Potion("Might", 7),
      new Potion("Focus", 7),
      new Potion("Invisibility", 7)
    };
    InfiniteList<Potion> listE = InfiniteList.iterate(0, i -> i + 1)
        .limit(potionsE.length)
        .map(i -> potionsE[i]);

    we.expect(
        "Test E: Average of four 7s is 7.0",
        () -> Math.abs(Task3.getAvgStrength(listE) - 7.0) < 1e-9,
        true
    );
  }
}
