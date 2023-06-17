package Models;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Item> menuItem;

    
    
    public Menu(List<Item> menuItem) {
        this.menuItem = menuItem;
    }

    
    
    public void display(){
        int i = 0;
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("|                                 MENU                                    |");
        System.out.println("---------------------------------------------------------------------------");
        for (Item item : menuItem) {
            if (item instanceof Food) {
                System.out.println("| " + i + ". " + ((Food) item).toString());
                i++;
            }
            if (item instanceof Drink) {
                System.out.println("| " + i + ". " + ((Drink) item).toString());
                i++;
            }
        }
        
        System.out.println("---------------------------------------------------------------------------");
        
    }

    public void addToMenu(Item item){
            this.menuItem.add(item);
            System.out.println("Current menu :");
            display();
            

    }
    
    public void replaceMenuItem(Scanner input){
            display();
            System.out.println("choose the index of the item you wish to replace");
            int index = input.nextInt();
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║                Do you want to add?           ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 1. Food                                      ║");
        System.out.println("║ 2. Drink                                     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("-Please enter your choice :");
            int choice = input.nextInt();
            switch(choice){
                case 1 :
                int i = 0; 
                System.out.println("enter the new food name :");
                String foodName = input.next();
                System.out.println("enter the new food price :");
                float foodPrice = input.nextFloat();
                System.out.println("enter the new food ingredients number :");
                int n = input.nextInt();
                String[] ingredients = new String[n];
                do {
                    System.out.println("ingredient : ");
                    String ing = input.next();
                    ingredients[i]=ing;
                    System.out.println("tap q to stop adding ingredients :");
                    i++;
                }while(i<n); 
                Food food = new Food(foodName, foodPrice, ingredients);
                this.menuItem.set(index,food);
                break;
                case 2 :
                System.out.println("enter the new drink name :");
                String drinkName = input.next();
                System.out.println("enter the new drink price :");
                float drinkPrice = input.nextFloat();
                System.out.println("enter the new drink size :");
                String drinkSize = input.next();
                Drink drink = new Drink(drinkName, drinkPrice, drinkSize);
                this.menuItem.set(index,drink);
                break;
                default : System.out.println("invalid choise !");
            }
            display();
       
    }

    public void removeMenuItem(Scanner input){
            display();
            System.out.println("choose the index of the item you wish to remove");
            int index = input.nextInt();
            this.menuItem.remove(index);
            System.out.println("The menu list updated : ");
            display();       
    }


    public void modify_item(Scanner input){
        display();
        System.out.println("choose the index of the menu item you wish to modify : ");
        int c = input.nextInt(); 
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("|           Select an option to make changes to the item:                  |");
        System.out.println("|-------------------------------------------------------------------------|");
        System.out.println("| 1. Change the name                                                       |");
        System.out.println("| 2. Change the price                                                      |");
        System.out.println("| 3. Change both the name and price                                         |");
        System.out.println("---------------------------------------------------------------------------");
        
        int choise = input.nextInt();
        switch(choise) {
            case 1 : System.out.println("enter the new name");
            String new_name = input.next();
            menuItem.get(c).setName(new_name);
            break;
            case 2 : System.out.println("enter the new price");
            float new_price = input.nextFloat();
            menuItem.get(c).setPrice(new_price);
            break;
            case 3 : System.out.println("enter the new name");
            String new_n = input.next();
            menuItem.get(c).setName(new_n);
            System.out.println("enter the new price");
            float new_pr = input.nextFloat();
            menuItem.get(c).setPrice(new_pr);
            break;
            default :
            System.out.println("invalid choise");
            break;
        }
        System.out.println("the updated menu : ");
        display();
    }


    public List<Item> getMenuItem() {
        return menuItem;
    }
}
