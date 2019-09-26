package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Shop {

   public SortedSet<Product> products;

   public Shop(){
      products = new TreeSet<>(new ComparatorByType());
   }

   public void addProduct(String name, String type){
      Product product;
      if (type.equalsIgnoreCase("g")){
         product = new Game(products.size()+1, name);
      } else if (type.equalsIgnoreCase("m")) {
          product = new Movie(products.size() + 1, name);
      }else if(type.equalsIgnoreCase("cd")){
          product = new CD(products.size()+1,name);
      } else {
         throw new IllegalArgumentException("Given type is unknown, try again.");
      }
      products.add(product);
   }

   private void addProduct(int id,String name,String type){
       Product product;
       if (type.equalsIgnoreCase("g")){
           product = new Game(id, name);
       } else if (type.equalsIgnoreCase("m")) {
           product = new Movie(id, name);
       }else if(type.equalsIgnoreCase("cd") || type.equalsIgnoreCase("c")){
           product = new CD(id,name);
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

   public Product[] getProducts(){
       Product[] newProducts = new Product[0];
       for (Product p:this.products) {
           newProducts = add(newProducts,p);
       }
       return newProducts;
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

   public void productsToTxt() throws FileNotFoundException {
       File shopfile = new File("shop.txt");
       PrintWriter pw = new PrintWriter(shopfile);
       for (Product p:this.products) {
           pw.println(p);
       }
       pw.close();
   }

   public void readProductsFromTxt(String path){
       File productfile = new File(path);
       List<String> products = new ArrayList<>();
       try{
           Scanner fileScanner = new Scanner(productfile);
           fileScanner.useDelimiter("==================");

           while (fileScanner.hasNext()){
               products.add(fileScanner.next());
           }
           for (int i = 0; i <products.size() ; i++) {
               products.set(i,products.get(i).replaceAll("\\r", ""));
           }
           for (int i = 0; i <products.size() ; i++) {
               String[] product = products.get(i).split("\\n|:");
               if (product.length>5) {
                   product = removeEmpty(product);
                   String type = String.valueOf(product[1].charAt(1));
                   int id = Integer.valueOf(product[3].trim());
                   String name = product[5];
                   this.addProduct(id, name, type);
               }
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
   }

    private String[] removeEmpty(String[] product) {
       String[] items = new String[0];
        for (int i = 0; i <product.length ; i++) {
            if (!product[i].equals("")){
                items = add(items,product[i]);
            }
        }
        return items;
    }

    private String[] add(String[] list, String item){
       String[] items = new String[list.length+1];
        for (int i = 0; i < list.length; i++) {
            items[i] = list[i];
        }
        items[items.length-1] = item;
        return items;
    }

    private Product[] add(Product[] list, Product item){
        Product[] items = new Product[list.length+1];
        for (int i = 0; i < list.length; i++) {
            items[i] = list[i];
        }
        items[items.length-1] = item;
        return items;
    }




}
