package domain;

public class Game extends Product {

   public Game(int id, String name) {
      super(id, name);
   }

   @Override
   public int getPrice(int days){
      return days*3;
   }

   @Override
   public String toString(){
      return "\nType: Game" + super.toString();
   }

}
