package domain;

import java.util.Comparator;

public class ComparatorByType implements Comparator<Product> {
   @Override
   public int compare(Product o1, Product o2) {
      if (o1.getClass() == o2.getClass()){
         return Integer.compare(o1.getId(),o2.getId());
         //Doesn't work if 2 products have the same id
      }else{
         if (o1 instanceof Movie){
            return -1;
         }
         if (o2 instanceof Movie){
            return 1;
         }
         if (o1 instanceof Game && o2 instanceof CD){
            return -1;
         }else{
            return 1;
         }
      }
   }
}
