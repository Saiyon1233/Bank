package coe528.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Bank extends Application {
    
    Manager m = new Manager();
    Customer c = new Customer();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("The Bank");
        FlowPane root = new FlowPane();
        Label username = new Label("Username: ");
        Label password = new Label("Password: ");
        Label role = new Label("Role: ");
        TextField usernameText = new TextField();
        TextField passwordText = new TextField();
        TextField roleText = new TextField();
        Button loginButton = new Button("Login");
        root.getChildren().add(username);
        root.getChildren().add(usernameText);
        root.getChildren().add(password);
        root.getChildren().add(passwordText);
        root.getChildren().add(role);
        root.getChildren().add(roleText);
        root.getChildren().add(loginButton);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(m.login(usernameText.getText(), passwordText.getText(), roleText.getText()))
                {
                    manager(primaryStage);
                }
                else if(c.login(usernameText.getText(), passwordText.getText(), roleText.getText()))
                {
                    customer(primaryStage);
                }
                else
                {
                    System.out.println("Error! Wrong username or password or role");
                }
            }
        });
    }
    
    public void manager(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Button addCustomer = new Button("Add Customer");
        Button deleteCustomer = new Button("Delete Customer");
        Button logout = new Button("Log Out");
        root.getChildren().add(addCustomer);
        root.getChildren().add(deleteCustomer);
        root.getChildren().add(logout);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        addCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                addCustomer(primaryStage);
            }
        });
        deleteCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                deleteCustomer(primaryStage);
            }
        });
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                logout(primaryStage);
            }
        });
    }
    
    public void customer(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Button depositMoney = new Button("Deposit Money");
        Button withdrawMoney = new Button("Withdraw Money");
        Button getBalance = new Button("Get Balance");
        Button onlinePurchase = new Button("Do Online Purchase");
        Button logout = new Button("Log Out");
        root.getChildren().add(depositMoney);
        root.getChildren().add(withdrawMoney);
        root.getChildren().add(getBalance);
        root.getChildren().add(onlinePurchase);
        root.getChildren().add(logout);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        depositMoney.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                depositMoney(primaryStage);
            }
        });
        withdrawMoney.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                withdrawMoney(primaryStage);
            }
        });
        getBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                getBalance(primaryStage);
            }
        });
        onlinePurchase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                onlinePurchase(primaryStage);
            }
        });
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                logout(primaryStage);
            }
        });
    }
    
    public void addCustomer(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Label username = new Label("Username: ");
        Label password = new Label("Password: ");
        TextField usernameText = new TextField();
        TextField passwordText = new TextField();
        Button button1 = new Button("Add Customer");
        root.getChildren().add(username);
        root.getChildren().add(usernameText);
        root.getChildren().add(password);
        root.getChildren().add(passwordText);
        root.getChildren().add(button1);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Customer x = new Customer();
                x.username = usernameText.getText();
                x.password = passwordText.getText();
                m.addCustomer(x);
                manager(primaryStage);
            }
        });
    }
    
    public void deleteCustomer(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Label username = new Label("Username: ");
        Label password = new Label("Password: ");
        TextField usernameText = new TextField();
        TextField passwordText = new TextField();
        Button button1 = new Button("Delete Customer");
        root.getChildren().add(username);
        root.getChildren().add(usernameText);
        root.getChildren().add(password);
        root.getChildren().add(passwordText);
        root.getChildren().add(button1);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Customer x = new Customer();
                x.username = usernameText.getText();
                x.password = passwordText.getText();
                m.deleteCustomer(x);
                manager(primaryStage);
            }
        });
    }
    
    public void depositMoney(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Label amount = new Label("Amount: ");
        TextField amountText = new TextField();
        Button button1 = new Button("Deposit Money");
        root.getChildren().add(amount);
        root.getChildren().add(amountText);
        root.getChildren().add(button1);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                c.depositMoney(Integer.parseInt(amountText.getText()));
                customer(primaryStage);
            }
        });
    }
    
    public void withdrawMoney(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Label amount = new Label("Amount: ");
        TextField amountText = new TextField();
        Button button1 = new Button("Withdraw Money");
        root.getChildren().add(amount);
        root.getChildren().add(amountText);
        root.getChildren().add(button1);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                c.withdrawMoney(Integer.parseInt(amountText.getText()));
                customer(primaryStage);
            }
        });
    }
    
    public void getBalance(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Label amount = new Label("$" + c.getBalance() + ".00");
        Button back = new Button("Back");
        root.getChildren().add(amount);
        root.getChildren().add(back);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                customer(primaryStage);
            }
        });
    }
    
    public void onlinePurchase(Stage primaryStage)
    {
        FlowPane root = new FlowPane();
        Label amount = new Label("Amount: ");
        TextField amountText = new TextField();
        Button button1 = new Button("Purchase");
        root.getChildren().add(amount);
        root.getChildren().add(amountText);
        root.getChildren().add(button1);
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                c.onlinePurchase(Integer.parseInt(amountText.getText()));
                customer(primaryStage);
            }
        });
    }
    
    public void logout(Stage primaryStage)
    {
        start(primaryStage);
    }
    
    
}