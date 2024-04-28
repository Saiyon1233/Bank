package coe528.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmala
 */
public class BankAccount {
    
    int balance;
    
    public BankAccount(int balance)
    {
        this.balance = balance;
    }
    
    public void onlinePurchase(int amount)
    {
        balance = balance - amount;
    }
    
}
