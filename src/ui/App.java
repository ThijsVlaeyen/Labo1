package ui;

import domain.Shop;

public class App {
   public static void main(String[] args) {
      try{
         Shop shop = new Shop();
         shop.addProduct("LOTR", "M");
         shop.addProduct("Fallout 4", "G");
         System.out.println(shop.allProducts());

         System.out.println(shop.rentPrice(1,5));
      }catch (Exception e){
         System.out.println(e);
      }


   }
}