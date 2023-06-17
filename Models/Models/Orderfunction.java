package Models;

import java.util.List;
import java.util.Scanner;

public interface Orderfunction {
    public void modify_order(List<Order>  l, Customer c,Menu m, Scanner input);
    public void remove_item(List<Order>  l, Customer c, Scanner input);
}
