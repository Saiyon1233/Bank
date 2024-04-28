package coe528.project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmala
 */

//Overiew: Manager controls which customers has an account in the Bank.
//They can add or remove them.
//Abstract Function: AF(c) = { c.get(i) | 0 <= i < c.size }
//Rep invariant: c != null && all elements are Customers
public class Manager extends User{
    
    ArrayList <Customer> c;
    
    public Manager() 
    {
        super("admin", "admin");
        this.role = "manager";
        c = new ArrayList<Customer>();
        Customer x = null;
        Scanner s = null;
        int i = 1;
        File file = new File("C:\\Users\\jmala\\OneDrive\\Documents\\NetBeansProjects\\coe318\\project\\BankAccount\\src\\coe528\\project\\customer"+i+".txt");
        while (file.exists())
        {
            x = new Customer();
            c.add(x);
            try
            {
                s = new Scanner(file);
                c.get(i-1).username = s.next();
                c.get(i-1).password = s.next();
                c.get(i-1).b.balance = Integer.parseInt(s.next());
            }catch(Exception e)
            {
                System.out.println("File not found");
            }
            i++;
            file = new File("C:\\Users\\jmala\\OneDrive\\Documents\\NetBeansProjects\\coe318\\project\\BankAccount\\src\\coe528\\project\\customer"+i+".txt");
        }
        if(s != null)
        {
            s.close();
        }
        
    }
    
    //Requires: A customer that has a username and password that is not the same as other customers
    //Modifies: The arraylist that contains the list of customers the manager manages
    //Effects: Adds a customer to the array list
    public void addCustomer(Customer x)
    {
        int i = 0;
        while(i<c.size())
        {
            if(c.get(i).username.equals(x.username))
            {
                System.out.println("Error! Customer already exists");
                break;
            }
            i++;
        }
        if(i == c.size())
        {
            c.add(x);
        }
    }
    
    //Requires: A customer that matches the username and password of a customer in the array list 
    //Modifies: The arraylist that contains the list of customers the manager manages
    //Effects: Deletes a customer from the array list
    public void deleteCustomer(Customer x)
    {
        int i = 0;
        while(i<c.size())
        {
            if(c.get(i).username.equals(x.username) && c.get(i).username.equals(x.username))
            {
                c.remove(i);
                break;
            }
            i++;
        }
        if(i == c.size())
        {
            System.out.println("Customer does not exist!");
        }
    }
    
    @Override
    //Requires: A username, password and role
    //Modifies: None
    //Effects: Returns a boolean that indicates if the username, password and role is valid
    public boolean login(String username, String password, String role)
    {
        boolean login = super.login(username, password, role);
        return login;
    }
    
    @Override
    //Requires: A stage
    //Modifies: None
    //Effects: Closes the application
    public void logout(Stage primaryStage)
    {
        super.logout(primaryStage);
    }
    
    //Requires: None
    //Modifies: None
    //Effects: A string representation of the array list of customers
    public String toString()
    {
        String output = "";
        int i = 0;
        for(i=0;i<c.size();i++)
        {
            output += c.get(i).toString();
        }
        return output;
        
    }
    
    //Requires: None
    //Modifies: None
    //Effects: Returns true if the rep invariant holds for this object otherwise returns false
    public boolean repOk()
    {
        boolean repOK;
        int i = 0;
        if(c != null) {
            repOK = true;
            for(i=0;i<c.size();i++){
                if(!(c.get(i) instanceof Customer)){
                    repOK = false;
                }
            }
        }
        else{
            repOK = false;
        }
        return repOK;
    }
}
