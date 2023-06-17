package Models;

import java.util.List;

public abstract class Person {
       
       private String email;
       private String password;
       
    
    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

         
    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public abstract void signup(Person p ,List<Person> persons);
    public abstract void login();

}