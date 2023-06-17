package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;


public class Test {

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }
    
    public static boolean is_Valid_Password(String password) {

        if (password.length() < 6) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    public static void Signup(Scanner input,List<Person> userList){
       
        System.out.println("******************************************************* SIGN UP ***************************************************");
        System.out.println("Do you want to sign up as :");
        System.out.println("[1] STAFF  ");
        System.out.println("[2] CUSTOMER  ");
        System.out.print("please choose :  ");

        int choose ;
        String email;
        String password;
        choose = input.nextInt();
        switch(choose){
           case 1 :
           do{
               System.out.print("Enter your email : ");
                email = input.next();
           }while(isValid(email)==false);
           do{
               System.out.print("Enter your password : ");
               password = input.next();
           }while(is_Valid_Password(password)==false);
           Staff s = new Staff(email, password);
           s.signup(s, userList);
           break; 
           case 2 : 
           System.out.print("Enter your name : ");
           String name = input.next();
           do{
               System.out.print("Enter your email : ");
               email = input.next();
           }while(isValid(email)==false);
           System.out.print("Enter your password :");
           String cpassword = input.next();
           Customer c = new Customer(email, cpassword, name);
           c.signup(c, userList);
           break;
           default : System.out.println("invalid choice");
           break;
        }
   }

   public static int Login(Scanner input,List<Person> userList){
    System.out.println("******************************************************* LOGIN *******************************************************");
    System.out.print("Enter you email please : ");
    String email = input.next();
    System.out.print("Enter your password : ");
    String password = input.next();
    for (int i = 0; i<userList.size();i++) {
        if (userList.get(i).getEmail().equals(email) && userList.get(i).getPassword().equals(password) ){
            
            if (userList.get(i) instanceof Customer){
                ((Customer)userList.get(i)).login();
                return i;
            }else{

                ((Staff)userList.get(i)).login();
                return i;
            }
        }
    }
    return -1;
}
    
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            Menu m = null;
            List<Person> userList = new ArrayList<>();
            List<Order> currentOrders = new ArrayList<>();
            boolean loggedIn = false;
            int choose;
            int loggedAccountIndex = -1;

            System.out.println(" ");
            System.out.println("********************************************************************************************************************");
            System.out.println("*                                    WELCOME TO RESTAURANT MANAGEMENT APPLICATION                                  *");
            System.out.println("*                                                                                                                  *");
            System.out.println("********************************************************************************************************************");
            
            while(true){

                while(loggedIn == false){
                    System.out.println("[1] SIGN UP  ");
                    System.out.print("[2] LOGIN  ");
                    System.out.println(" ");
                    System.out.print("Please choose : ");
                    choose = input.nextInt();
                        switch(choose){
                            case 1: Signup(input, userList);
                            case 2 : loggedAccountIndex = Login(input, userList);
                                 if (loggedAccountIndex != -1) {
                                    loggedIn = true;
                                 }else{
                                    System.out.println("user not found");
                                 }
                            break;
                            default : System.out.println("invalid choice"); break;
                        }
                    }
        
                    if(loggedIn){
                        Person user = userList.get(loggedAccountIndex);
        
                        if (user instanceof Staff){
                            System.out.println("╔══════════════════════════════════════════════╗");
                            System.out.println("║                Staff Home Page               ║");
                            System.out.println("╠══════════════════════════════════════════════╣");
                            System.out.println("║ 1. Create Menu                               ║");
                            System.out.println("║ 2. Add Item to the Current Menu              ║");
                            System.out.println("║ 3. Modify an Item of the Current Menu        ║");
                            System.out.println("║ 4. Replace an Item of the Current Menu       ║");
                            System.out.println("║ 5. Remove an Item from the Current Menu      ║");
                            System.out.println("║ 6. Display the Menu                          ║");
                            System.out.println("║ 7. Serve Order                               ║");
                            System.out.println("║ 8. Logout                                    ║");
                            System.out.println("╚══════════════════════════════════════════════╝");
                            System.out.print("Enter your choice: ");
                            int staffChoice = input.nextInt();
                            switch(staffChoice){
                                case 1: m = ((Staff)user).create_menu(input);
                                break;
                                case 2: ((Staff)user).add_item(m,input);
                                break;
                                case 3: ((Staff)user).ModifyMenuItem(m, input);
                                break;
                                case 4: ((Staff)user).replaceMenuItem(m, input);
                                break;
                                case 5: ((Staff)user).removeMenuItem(m, input);
                                break;
                                case 6: ((Staff)user).displayMenu(m);
                                break;
                                case 7: ((Staff)user).served(currentOrders, input);
                                break;
                                case 8: loggedIn = false;
                                break;
                                default: System.out.println("invalid choice !");
                                break;
                            }
                        }

                        if (user instanceof Customer){
                               System.out.println("╔══════════════════════════════════════════════╗");
                               System.out.println("║           Customer Home Page                 ║");
                               System.out.println("╠══════════════════════════════════════════════╣");
                               System.out.println("║ 1. Place Order                               ║");
                               System.out.println("║ 2. Cancel Order                              ║");
                               System.out.println("║ 3. Check Your Order                          ║");
                               System.out.println("║ 4. Modify Your Order                         ║");
                               System.out.println("║ 5. Logout                                    ║");
                               System.out.println("╚══════════════════════════════════════════════╝");
                               System.out.print("Enter your choice: ");
                                int customerChoice = input.nextInt();
                                switch(customerChoice){
                                    case 1: 
                                    int exit;
                                    List<Item> items = new ArrayList<>();
                                    do {
                                    System.out.println("to place your order choose the index of your food or drink");
                                    m.display();
                                    int indx = input.nextInt();
                                    Item item = m.getMenuItem().get(indx);
                                    items.add(item);
                                    System.out.println("choose 0 if your done selecting items for your order(anything else to continue)");
                                    exit = input.nextInt();
                                    }while(exit != 0);
                                    Order order = new Order(items, (Customer)user);
                                    currentOrders.add(order);
                                    for(Order ord : currentOrders){
                                        if (ord.getCustomer().getName() == ((Customer)user).getName()){
                                            System.out.println(ord.toString());
                                        }
                                    }
                                    break;
                                    case 2:
                                    ((Customer)user).cancel_order(currentOrders);
                                    break;
                                    case 3: 
                                    if (currentOrders.isEmpty()){
                                        System.out.println("no order to display");
                                    }else{
                                       for (int i=0;i<currentOrders.size();i++){
                                        if (currentOrders.get(i).getCustomer().getName() == ((Customer)user).getName()){
                                            System.out.println(currentOrders.get(i).toString());
                                        }else{
                                            System.out.println("no order to display");
                                        }
                                    }
                                    }
                                    break;
                                    case 4 : if (currentOrders.isEmpty()){
                                        System.out.println("no order to modify");
                                    }else{
                                        for(Order ord : currentOrders){
                                        if (ord.getCustomer().getName() == ((Customer)user).getName()){
                                            ord.modify_order(currentOrders, ((Customer)user), m, input);
                                        }else{
                                            System.out.println("no order to modify");
                                        }
                                    }
                                    }   
                                    break;
                                    case 5: loggedIn = false;
                                    break;

                                    default: 
                                    break;
                                }
                            }

                 System.out.println("----------------------------------------------------------------------");
           
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
