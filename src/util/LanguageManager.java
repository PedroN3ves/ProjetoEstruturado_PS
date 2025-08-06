package util;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LanguageManager
{
    private static ResourceBundle messages;

    public static void initLanguage()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your language / Escolha seu idioma / Elija su idioma:");
        System.out.println("1. English\n2. Português\n3. Español");
        System.out.print("Option: ");
        String option = scanner.nextLine();

        switch (option)
        {
            case "1":
                messages = ResourceBundle.getBundle("messages", new Locale("en"));
                break;
            case "2":
                messages = ResourceBundle.getBundle("messages", new Locale("pt"));
                break;
            case "3":
                messages = ResourceBundle.getBundle("messages", new Locale("es"));
                break;
            default:
                System.out.println("Invalid option. Defaulting to English.");
                messages = ResourceBundle.getBundle("messages", new Locale("en"));
                break;
        }
    }

    public static String getMessage(String key)
    {
        return messages.getString(key);
    }
}
