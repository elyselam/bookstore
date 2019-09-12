package com.company.app.system;

import com.company.app.screens.WelcomeScreen;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.Scanner;

public class BookstoreApplication extends Application {
    private Screen currentScreen;
    private Scanner scanner;

    public BookstoreApplication() {
        currentScreen = new WelcomeScreen();
        scanner = new Scanner(System.in);

    }

    @Override
    public void run(String[] args) {

        while(currentScreen != null) {
            //invokes doScreen on currentScreen
            //this is the current instance of BookstoreApplication, and it's 'app'
            //object whose parent is Application
            //has to be type Application
            //implicit upcast from BookstoreApplication to Application
            currentScreen = currentScreen.doScreen(scanner, this);
        }
    }

}
