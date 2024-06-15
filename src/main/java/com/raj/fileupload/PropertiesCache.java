/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raj.fileupload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author rajmo
 */
public class PropertiesCache {
    
    public static Properties getPropertyObject() throws FileNotFoundException, IOException {
       // FileInputStream fis = new FileInputStream("src\\main\\resources\\properties.properties");
        FileInputStream fis = new FileInputStream("src\\main\\java\\com\\raj\\properties\\properties.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop;
    }
    
   // Properties prop = loadPropertiesFromFile("src\\main\\java\\com\\raj\\properties\\properties.properties");
    
    /*
    private static Properties loadPropertiesFromFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(filePath)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return prop;
    }
    */
     /*  private static boolean isUserCredentialsValid(Properties prop, String username, String password) {
        // Loop through all properties and check for a matching username and password
        for (String key : prop.stringPropertyNames()) {
           // if (prop.getProperty(key + ".username").equals(username) && prop.getProperty(key + ".password").equals(password)) {
           String storedUsername = prop.getProperty(key + ".username");
            System.out.println(storedUsername);
           String storedPassword = prop.getProperty(key + ".password");  
             System.out.println(storedPassword); 
             
           if (storedUsername != null && storedPassword != null && 
                storedUsername.equals(username) && storedPassword.equals(password)) {
            return true; // Match found
        }
           }
      
        return false; // No match found
    }*/
       
      private static boolean isUserCredentialsValid(Properties prop, String username, String password) {
    // Loop through all properties and check for a matching username and password
          System.out.println(prop.stringPropertyNames());
    for (String key : prop.stringPropertyNames()) {
        String storedUsername = prop.getProperty(key + ".username");
        System.out.println("storedUsername--->"+storedUsername);
        String storedPassword = prop.getProperty(key + ".password");  
        System.out.println("storedUsername--->"+storedPassword);
        if (storedUsername != null && storedPassword != null && 
            storedUsername.equals(username) && storedPassword.equals(password)) {
            return true; // Match found
        }
    }
    return false; // No match found
}  
       
    
    
    //public static String getURL() throws IOException  {
        
    //    return getPropertyObject().getProperty("url");
    //}
    
    public static String getUserName() throws IOException {
        return getPropertyObject().getProperty("username");
    }
    
    public static String getPassword() throws IOException{
        return getPropertyObject().getProperty("password");
    }
    
    public static void main(String[] args) throws IOException{
     //   Properties prop = loadPropertiesFromFile("src\\main\\resources\\properties.properties");
        
      /*  if (isUserCredentialsValid(prop, "admin", "admin123")) {
            System.out.println("Username and password are valid.");
        } else {
            System.out.println("Username and password are not valid.");
        }*/
      
      String s = getUserName();
      String p = getPassword();
        System.out.println(s + p);
    }
}
