package com.company;

import com.company.platform.Application;
import com.company.platform.TestClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static String className;
    private static String appTitle;

    public static void main(String[] args) {
//        Book b = new Book();
//        b.setTitle("Book Title");
//        System.out.println(b.getTitle());

        ////polmorphism! TestClass is a Application
        //Application app = new TestClass();


        parseArgs(args);

//        //this for Reflection
//        Application app = init(args[0]);
        Application app = init(className, appTitle);

//        app.setTitle("Amazing Books");

        //we are not concerned about how TestClass runs, just care that it does it
        app.run(args);
    }

    private static String[] loadConfig() {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader("resources/app.properties");
            br = new BufferedReader(fr);
            String[] args = new String[100];
            String line;
            int lineCount = 0;

            while((line = br.readLine()) != null) {
                args[lineCount++] = line;
            }

            return args;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new String[]{};
    }



    private static void parseArgs(String[] args) {
        for (String s : args) {
            String[] tokens = s.split("="); //["key", "value"]
            String key = tokens[0];
            String value = tokens[1];

            if ("rootApp".equals(key)) {
                className = value;

            } else if ("title".equals(key)) {
                appTitle = value;
            }

        }
    }

    ///////REFLECTION

    private static Application init(String className) {
        Object o;
        try {
            Class clazz = Class.forName(className);
            o = clazz.newInstance();
            return (Application)o; //instance type is Application
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Application init(String className, String title) {
        //create instance
        Application a = init(className);

        if (a != null) {
            try {
                //setTitle has to take a string
                Method setTitleMethod = a.getClass().getMethod("setTitle", String.class);
                if(setTitleMethod != null){
                    //referes to method setTitle in the application class
                    //invoke method on an object
                    //same as a.setTitle(appTitle);
                    setTitleMethod.invoke(a, appTitle);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        return a;
    }
}


