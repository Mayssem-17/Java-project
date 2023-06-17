package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Staff extends Person {
    private boolean isStaff ;

    public Staff(String email, String password) {
        super(email, password);
        this.isStaff = true;
    }

    public boolean isStaff() {
        return this.isStaff;
    }

    @Override
    public void signup(Person p, List<Person> persons) {
        if (persons.size() > 0) {
            for (int i  = 0; i<persons.size();i++) {
                if (persons.get(i).getEmail().equals(p.getEmail())){
                    System.out.println("this email is already used");
                }
            }
        } 
        persons.add(p);
        System.out.println("signing up completed successfuly ! welcome aboard"); 
            
    }

    @Override
    public void login() {

        System.out.println("Welcome aboard!");
    }

    public Menu create_menu(Scanner input){

            List<Item> menuItem = new ArrayList<>();
            Menu m = new Menu(menuItem);
            int exit;
            do{
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║                Do you want to add?           ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║ 1. Food                                      ║");
                System.out.println("║ 2. Drink                                     ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("-Please enter your choice :");
                int choise = input.nextInt();
                switch(choise){
                    case 1 :
                    int i = 0; 
                    System.out.println("-Enter the new food name :");
                    String foodName = input.next();
                    System.out.println("-Enter the new food price :");
                    Float foodPrice = input.nextFloat();
                    System.out.println("-Enter the new food ingredients number :");
                    int n = input.nextInt();
                    String[] ingredients = new String[n];
                    do {
                        System.out.println((i+1)+" .ingredient : ");
                        String ing = input.next();
                        ingredients[i]=ing;
                        i++;
                    }while(i<n); 
                    Food food = new Food(foodName, foodPrice, ingredients);
                    m.addToMenu(food);
                    break;
                    case 2 :
                    System.out.println("-Enter the new drink name :");
                    String drinkName = input.next();
                    System.out.println("-Enter the new drink price :");
                    Float drinkPrice = input.nextFloat();
                    System.out.println("-Enter the new drink size :");
                    String drinkSize = input.next();
                    Drink drink = new Drink(drinkName, drinkPrice, drinkSize);
                    m.addToMenu(drink);
                    break;
                    default : System.out.println("invalid choise !");
                }
                System.out.println("(Enter 0 if you wish to exit :(any thing else to continue))");
                exit = input.nextInt();
            }while(exit != 0);
            
            return m;  
    }
    public void add_item(Menu m,Scanner input){
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
                    Float foodPrice = input.nextFloat();
                    System.out.println("enter the new food ingredients number :");
                    int n = input.nextInt();
                    String[] ingredients = new String[n];
                    do {
                        System.out.println((i+1)+" .ingredient : ");
                        String ing = input.next();
                        ingredients[i]=ing;
                        i++;
                    }while(i<n); 
                    Food food = new Food(foodName, foodPrice, ingredients);
                    m.addToMenu(food);
                    break;
                    case 2 :
                    System.out.println("enter the new drink name :");
                    String drinkName = input.next();
                    System.out.println("enter the new drink price :");
                    Float drinkPrice = input.nextFloat();
                    System.out.println("enter the new drink size :");
                    String drinkSize = input.next();
                    Drink drink = new Drink(drinkName, drinkPrice, drinkSize);
                    m.addToMenu(drink);
                    break;
                    default : System.out.println("invalid choise !");
                }
    }

    public void displayMenu(Menu m){
        m.display();
    }

    public void replaceMenuItem(Menu m ,Scanner input){
        m.replaceMenuItem(input);
    }

    public void ModifyMenuItem(Menu m ,Scanner input){
        m.modify_item(input);
    }

    public void removeMenuItem(Menu m, Scanner input){
        m.removeMenuItem(input);
    }
    
    public void served(List<Order> current,Scanner input){
        int index=0;
        if (current.isEmpty()){
            System.out.println("-No order is ready to be served for now .");
        }else{
            for (Order order : current){
                System.out.println(index+order.toStringCurrent());
                index++;
            }
            System.out.println("choose the index of the served order");
            int choise = input.nextInt();
            
            current.remove(choise);
    
            for (Order order : current){
                System.out.println(index+order.toStringCurrent());
                index++;
            }
        }   
    }
}
                
           
    
