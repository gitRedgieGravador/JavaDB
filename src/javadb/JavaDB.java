/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gravadorre_sd2023
 */
public class JavaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean on = true;
        String id;
        while (on) {
            String option = Menu.main();
            switch (option) {
                case "1":
                    int accid = Sqlcrudaccount.insertAccount();
                    System.out.println(accid);
                    String perinfo = Menu.ask("1. Add Personal Info\n2. Leave\nInput");
                    switch (perinfo) {
                        case "1":
                            Sqlcrudaccount.getAccountAll();
                            break;
                        case "2":
                            id = Menu.askId("IDAccount");
                            Sqlcrudaccount.getAccountByID(id);
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                case "2":
                    boolean unget = true;
                    while (unget) {
                        String get = Menu.ask("1. Retrieve all\n2. Retrieve by id\nInput");
                        switch (get) {
                            case "1":
                                Sqlcrudaccount.getAccountAll();
                                unget = false;
                                break;
                            case "2":
                                id = Menu.askId("IDAccount");
                                Sqlcrudaccount.getAccountByID(id);
                                unget = false;
                                break;
                            default:
                                System.out.println("Invalid");
                                break;
                        }
                    }
                    break;

                case "3":
                    id = Menu.askId("IDAccount");
                    Sqlcrudaccount.deleteAccountByID(id);
                    break;
                case "4":
                    id = Menu.askId("IDAccount");
                    Sqlcrudaccount.updateAccountByID(id);
                    break;
                case "5":
                    Sqlcrudaccount.getAccountAll();
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

}
