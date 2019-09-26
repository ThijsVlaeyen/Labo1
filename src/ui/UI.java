package ui;

import domain.*;
import javax.swing.*;

public class UI {

    public void ShowMenu(Shop shop)
    {
        String menu = "1. Add product\n2. Show all products\n3. Show product\n4. Show rental price\n\n0. Quit";
        int choice = -1;
        while(choice != 0)
        {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                AddProduct(shop);
            } else if (choice == 2) {
                ShowAll(shop);
            } else if (choice == 3){
                ShowProduct(shop);
            } else if (choice == 4){
                ShowRentalPrice(shop);
            }
        }
    }

    public void ShowProduct(Shop shop)
    {
        String id = JOptionPane.showInputDialog("Enter the id:");
        int newId = Integer.parseInt(id);
        for (Product product : shop.getProducts())
        {
            if(product.getId() == newId)
            {
                JOptionPane.showMessageDialog(null, "something");
            }
            break;
        }
    }

    public void AddProduct(Shop shop)
    {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String choiceString = JOptionPane.showInputDialog("1. movie\n2. game\n3. cd");
        int choice = Integer.parseInt(choiceString);
        if(choice == 1)
        {
            shop.addProduct(title, "m");
        }
        else if (choice == 2)
        {
            shop.addProduct(title, "g");
        }
        else if (choice == 3)
        {
            shop.addProduct(title, "cd");
        }
    }

    public void ShowAll(Shop shop)
    {
        JList list = new JList(shop.products.toArray());
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(list));
        JOptionPane.showMessageDialog(null, panel);
    }

    public void ShowRentalPrice(Shop shop)
    {

    }
}
