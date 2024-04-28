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
public class GoldBankAccount extends BankAccount{
    
    public GoldBankAccount(int balance) {
        super(balance);
    }
    
    public void onlinePurchase(int amount)
    {
        amount = amount + 10;
        super.onlinePurchase(amount);
    }
    
}
