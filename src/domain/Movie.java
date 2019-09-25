package domain;

public class Movie extends Product{

   public Movie(int id, String name) {
      super(id, name);
   }

   @Override
   public int getPrice(int days){
      return (days-3)>0? (days-3) * 2:0;
   }

   @Override
   public String toString(){
      return "\nType: Movie" + super.toString();
   }

}
