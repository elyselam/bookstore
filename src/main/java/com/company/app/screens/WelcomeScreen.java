package com.company.app.screens;

import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScreen implements Screen {


    private Object Application;


//        //this was in BookstoreApplication
//        //app is in Main.java
//        System.out.println("Welcome to " + app.getTitle());
//        System.out.println("1. Login");
//        System.out.println("2. Exit ");
//        //get user input
//        return doInput(scanner);
//
//
//        //process input
//
//        //switch app state
//
//        //render new menu


    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome to " + app.getTitle());
        String menuText = "";
        //print
        menuText = new StringMenuBuilder()
                .addOption("1", "Login") //"1. Login"
                .addOption("2", "Exit") //"2. Exit"
                .build(); //converts everything to String

        System.out.println(menuText);
        Screen screen = null;

        try {
            screen = doInput(scanner); //
        } catch (InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
            screen = new WelcomeScreen();
        } catch (RuntimeException ex) {

        } catch (Exception ex) {

        } finally {
            //will always run
            System.out.println("Finally");
        }

        return screen;
    }

    private Screen doInput(Scanner scanner) {
        //waits for console input
        int i = scanner.nextInt();

        Screen newScreen = null;

        switch (i) {
            case 1:
                //assigned to an instance of LoginScreen
                newScreen = new LoginScreen();
                break;
            case 2:
            //if no cases match, then default runs
            default:
        }
        return newScreen;
    }
}
