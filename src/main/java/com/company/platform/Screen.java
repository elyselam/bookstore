package com.company.platform;

import java.util.Scanner;

//this allows us make it doesn't matter how many screens we need
//adding methods requires us to know how many we needs
public interface Screen {
    Screen doScreen(Scanner scanner, Application app);

}
