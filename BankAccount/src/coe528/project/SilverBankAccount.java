/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author jmala
 */
public class SilverBankAccount extends BankAccount{
    
    public SilverBankAccount(int balance) {
        super(balance);
    }
    
    public void onlinePurchase(int amount)
    {
        amount = amount + 20;
        super.onlinePurchase(amount);
    }
    
}
