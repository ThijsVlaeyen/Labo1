package domain;

public abstract class Product implements Comparable<Product>{

   private int id;
   private String name;

   public Product(int id, String name){
      this.id = id;

      if(name.trim().isEmpty()){
         throw new IllegalArgumentException("Given name is empty");
      }
      this.name = name;
   }

   public int getId(){
      return this.id;
   }

   public int getPrice(int days){
      return 0;
   }

   @Override
   public int compareTo(Product s){
      if (s == null) return 1;
      return this.id - s.getId();
   }

   @Override
   public String toString(){
      String out = "";
      out += "\nID: " + this.id;
      out += "\nName: " + this.name;
      out += "\n==================";
      return out;
   }

}
