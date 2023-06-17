package Models;

import java.util.List;

public class Customer extends Person {
    private String name;
    private boolean isStaff;

    public Customer(String email, String password, String name) {
        super(email, password);
        this.name = name;
        this.isStaff = false;
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
        System.out.println("signing up completed successfuly !");  
             
    }

    @Override
    public void login() {
                System.out.println("Welcome Customer!");
    }

    public String getName() {
        return name;
    } 

    public boolean isStaff() {
        return this.isStaff;
    }

    public void place_order(Customer c,List<Item> l, List<Order> current){
        Order order =  new Order(l,c);
        current.add(order);
    }
    
    public void cancel_order(List<Order> current){
        for (int i=0;i<current.size();i++){
            if (current.get(i).getCustomer().getName().equals(this.name)){
                current.get(i).toString();
                current.remove(i);
                System.out.println("order canceled successfully");
            }else{
                System.out.println("order not found");
            }
        }
    }


    @Override
    public String toString() {
        return "Customer [name=" + name + ", email=" + getEmail() + "]";
    }
    
    

}
