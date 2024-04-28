package coe528.project;

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
public class User {
    
    String username;
    String password;
    String role;
    
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public boolean login(String username, String password, String role)
    {
        if(username.equals(this.username) && password.equals(this.password) && role.equals(this.role))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void logout(Stage primaryStage)
    {
        primaryStage.close();
    }
}
