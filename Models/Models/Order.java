package Models;

import java.util.List;
import java.util.Scanner;


public class Order implements Orderfunction {
    private List<Item> selectedItems ;
    private double total_price = 0;
    private Customer customer;

    Scanner o = new Scanner(System.in);

    public Order(List<Item> selectedItems,Customer customer) {
        this.selectedItems = selectedItems;
        this.customer = customer;
        for(Item item : selectedItems){
           this.total_price = this.total_price + item.getPrice(); 
        }
    }

    public List<Item> getSelectedItems() {
        return selectedItems;
    }

    public double getTotal_price() {
        return total_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setSelectedItems(List<Item> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    

    @Override
    public String toString() {
        return "--------------------------Your Order----------------------------\n"+
        "SelectedItems :\n" + selectedItems + "\nTotal_price=" + total_price + "dt\nCustomer=" + customer.getName()
                + "]"+"\n---------------------------------------------------------------";
    }

    public String toStringCurrent() {
        String orderDetails = "---------------------------------------------------------------\n" +
        "|                             ORDER                           |\n" +
        "|-------------------------------------------------------------|\n" +
        "| Selected Items:                                             |\n" +
        selectedItems + "\n" +
        "| Total Price: " + total_price + " dt                           |\n" +
        "| Customer: " + customer.getName() + "                               |\n" +
        "---------------------------------------------------------------";

      return orderDetails;
    }

    public void display_orders()  {
        int i=0;
        for (Item item : selectedItems){
            if (item instanceof Food) {
                System.out.print(i+"."+((Food)item).toString()+"\n");
                i++;
            }
            if (item instanceof Drink){
                System.out.print(i+"."+((Drink)item).toString()+"\n");
                i++;
            }
        }
    }

    public void modify_order(List<Order>  l, Customer c,Menu m, Scanner input) {

        for(Order order : l){
          if(order.getCustomer().getName().equals(c.getName())){
            System.out.println("This your items ordered list :");
            display_orders();
            System.out.println("\nplease enter the index of the item you wish to modify:");
            int index = input.nextInt();
            m.display();
            System.out.println("choose new Item  from the menu: ");
            int n = input.nextInt();
            Item new_Item = m.getMenuItem().get(n);
            order.selectedItems.set(index, new_Item);
            double new_price = 0;
            for (Item item : order.selectedItems){
                  new_price += item.getPrice();
            }
            order.setTotal_price(new_price);
          }else{
            System.out.println("Order not found.");
          }
        }

    }
    public void remove_item(List<Order>  l, Customer c, Scanner input){
        for(Order order : l){
            if(order.getCustomer().getName().equals(c.getName())){
              System.out.println("This your items ordered list :");
              display_orders();
              System.out.println("\nplease enter the index of the item you wish to remove:");
              int index = input.nextInt();
              order.selectedItems.remove(index);
              double new_price = 0;
              for (Item item : order.selectedItems){
                    new_price += item.getPrice();
              }
              order.setTotal_price(new_price);
            }else{
              System.out.println("Order not found.");
            }
          }
  
    }
}
