package coe528.project;

import java.io.File;
import java.util.Scanner;
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
public class Customer extends User{

    BankAccount b;
    
    public Customer()
    {
        super(null, null);
        this.role = "customer";
        b = new SilverBankAccount(100);
    }
    
    public void setLevel()
    {
        if(b.balance < 10000)
        {
            b = new SilverBankAccount(b.balance);
        }
        else if((10000 <= b.balance) && (b.balance < 20000))
        {
            b = new GoldBankAccount(b.balance);
        }
        else if(b.balance >= 20000)
        {
            b = new PlatinumBankAccount(b.balance);
        }
    }
    
    public int getBalance()
    {
        return b.balance;
    }
    
    public void depositMoney(int amount)
    {
        b.balance = b.balance + amount;
        this.setLevel();
    }
    
    public void withdrawMoney(int amount)
    {
        if(amount < b.balance)
        {
            b.balance = b.balance - amount;
            this.setLevel();
        }
        else
        {
            System.out.println("Error!");
        }
    }
    
    public void onlinePurchase(int amount)
    {
        if(amount >= 50)
        {
            b.onlinePurchase(amount);
        }
        else
        {
            System.out.println("Error!");
        }
    }
    
    @Override
    public boolean login(String username, String password, String role)
    {
        boolean login = false;
        Scanner s = null;
        int i = 1;
        File file = new File("C:\\Users\\jmala\\OneDrive\\Documents\\NetBeansProjects\\coe318\\project\\BankAccount\\src\\coe528\\project\\customer"+i+".txt");
        while (file.exists())
        {
            try
            {
                s = new Scanner(file);
                this.username = s.next();
                this.password = s.next();
                this.b.balance = Integer.parseInt(s.next());
            }catch(Exception e)
            {
                System.out.println("File not found");
            }
            login = super.login(username, password, role);
            if(login)
            {
                break;
            }
            i++;
            file = new File("C:\\Users\\jmala\\OneDrive\\Documents\\NetBeansProjects\\coe318\\project\\BankAccount\\src\\coe528\\project\\customer"+i+".txt");
        }
        if(s != null)
        {
            s.close();
        }
        return login;
    }
    
    @Override
    public void logout(Stage primaryStage)
    {
        super.logout(primaryStage);
    }
    
}
