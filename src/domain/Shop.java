package domain;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Shop {

   private SortedSet<Product> products;

   public Shop(){
      products = new TreeSet<>();
   }

   public void addProduct(String name, String type){
      Product product;
      if (type.equalsIgnoreCase("g")){
         product = new Game(products.size()+1, name);
      } else if (type.equalsIgnoreCase("m")){
         product = new Movie(products.size()+1, name);
      } else {
         throw new IllegalArgumentException("Given type is unknown, try again.");
      }

      products.add(product);
   }

   public String allProducts(){
      String out = "\n==================";
      for (Product product : products) {
         out += product;
      }
      return out;
   }

   public String productById(int id){
      if (id <= 0 || id > products.size()){
         throw new IllegalArgumentException("Asked ID is not available");
      }
      String out = "";
      for (Product product : products){
         if (product.getId() == id){
            out = product.toString();
         }
      }
      return out;
   }

   public int rentPrice(int id, int days){
      int out = 0;
      if (id <= 0 || id > products.size()){
         throw new IllegalArgumentException("Asked ID is not available");
      }
      if (days <= 0){
         throw new IllegalArgumentException("Incorrect amount of days");
      }

      for (Product product : products){
         if (product.getId() == id){
            out = product.getPrice(days);
         }
      }

      return out;
   }

}
