package io.github.qpcrummer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static io.github.qpcrummer.guis.ConfigGUI.usernameVar;
import static io.github.qpcrummer.guis.ConfigGUI.passwordVar;

public class Config {
    static String launcher1 = "path";
    static String minecraft1 = "path";
    static Properties prop = new Properties();

    public static void folder() {
        try {
            Files.createDirectory(Paths.get("TaterLauncher"));
        } catch (IOException ignored) {
        }
    }

    public static void loadConfig() {
        try (InputStream input = new FileInputStream("TaterLauncher/config.properties")) {
            Files.createFile(Path.of("config.properties"));
            //get the properties value
            usernameVar = prop.getProperty("Username"); // Get the username from the GUI class
            passwordVar = prop.getProperty("Password"); // Get the password from the GUI class
            launcher1 = prop.getProperty("LauncherPath");
            minecraft1 = prop.getProperty("MineCraftPath");
            prop.load(input);
            System.out.println(prop);
        } catch (IOException ignored) {
        }
        System.out.println("Config was loaded");
    }

    public static void storeConfig() {
        try (OutputStream output = new FileOutputStream("TaterLauncher/config.properties")) {

            //set the properties value
            prop.setProperty("Username", usernameVar); // Get the username from the GUI class
            prop.setProperty("Password", passwordVar); // Get the password from the GUI class
            prop.setProperty("LauncherPath", launcher1);
            prop.setProperty("MineCraftPath", minecraft1);
            // save properties to project root folder
            prop.store(output, null);

            //Text Box Testing
            System.out.println(usernameVar);
            System.out.println(passwordVar);
            //set the properties value
            System.out.println(prop);
        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println("Config was stored");
    }
}
