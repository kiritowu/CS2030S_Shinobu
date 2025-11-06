import cs2030s.fp.*;  

class Test1 {
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();    
    we.expect(
        "unseal(): does not mutate the original sealed potion",
        () -> {
          Potion p = new Potion("Healing", 10);      
          Potion q = p.unseal();                     
          return p.isSealed();                       
        },
        true);

    we.expect(
        "unseal(): returns a different instance when it would change state",
        () -> {
          Potion p = new Potion("Healing", 10);
          Potion q = p.unseal();
          return q == p;                            
        },
        false);

    we.expect(
        "unseal(): the returned instance reflects the change",
        () -> {
          Potion p = new Potion("Healing", 10);
          Potion q = p.unseal();
          return q.isSealed();                     
        },
        false);
    
    we.expect(
        "drink(x): original remains unchanged; returned has reduced doses",
        () -> {
          Potion p = new Potion("Healing", 10);      
          Potion a = p.unseal();
          Potion b = a.drink(5);                     
        
          return p.isSealed() && p.getDoses() == 50 && b.getDoses() == 45;
        },
        true);

    we.expect(
        "drink(x): returns a different instance when doses actually decrease",
        () -> {
          Potion p = new Potion("Healing", 10);
          Potion a = p.unseal();
          Potion b = a.drink(7);
          return b == a;                             
        },
        false);

    we.expect(
        "drink(x > remaining): returned hits 0, original still at 50",
        () -> {
          Potion p = new Potion("Healing", 10);
          Potion a = p.unseal();
          Potion b = a.drink(12345);                 // cap to 0
          return p.getDoses() == 50 && b.getDoses() == 0;
        },
        true);

    
    we.expect(
        "enhance(x): original strength unchanged; returned strength increased",
        () -> {
          Potion p = new Potion("Might", 2);
          Potion q = p.enhance(5);                   // effectful
          return p.getStrength() == 2 && q.getStrength() == 7;
        },
        true);

    we.expect(
        "enhance(x): returns a different instance when it would change state",
        () -> {
          Potion p = new Potion("Might", 2);
          Potion q = p.enhance(1);
          return q == p;
        },
        false);

    
    we.expect(
        "dilute(x): original strength unchanged; returned strength decreased (>=1)",
        () -> {
          Potion p = new Potion("Focus", 8);
          Potion q = p.dilute(3);                    
          return p.getStrength() == 8 && q.getStrength() == 5;
        },
        true);

    we.expect(
        "dilute(x) with floor at 1: when no change needed, it may return itself",
        () -> {
          Potion p = new Potion("Focus", 1);
          Potion q = p.dilute(999);                            
          System.out.println(p.getStrength() == 1);
          System.out.println(q.getStrength() == 1);

          return q == p && q.getStrength() == 1 && p.getStrength() == 1;
        },
        true);

    
    we.expect(
        "Chaining: original remains completely unchanged after multiple \"mutators\"",
        () -> {
          Potion p = new Potion("Elixir", 4);
          Potion a = p.unseal();                     
          Potion b = a.enhance(6);                   
          Potion c = b.drink(10);                    

          boolean originalUnchanged =
              p.isSealed() && p.getStrength() == 4 && p.getDoses() == 50;

          boolean chainReflectsChanges =
              !a.isSealed() && b.getStrength() == 10 && c.getDoses() == 40;
                    
          return originalUnchanged && chainReflectsChanges;
        },
        true);

    we.expect(
        "Chaining: each step that changes state must return a new instance",
        () -> {
          Potion p = new Potion("Elixir", 4);
          Potion a = p.unseal();
          Potion b = a.enhance(6);
          Potion c = b.drink(10);          
          return (a != p) && (b != a) && (c != b);
        },
        true);
  }
}
