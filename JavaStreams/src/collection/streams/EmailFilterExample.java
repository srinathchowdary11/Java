package collection.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmailFilterExample {

    public static void main(String[] args) {

        List<String> emailList = Arrays.asList(
             "sri@gmail.com",
            "ram@outlook.com",
            "bhavith@yahoo.com",
            "sruti@hotmail.com",
            "suraj@gmail.com",
            "bushan@outlook.com",
            "yekambaram@hotmail.com",
            "paul@outlook.com",
			"manoj@gmail.com",
			"sid@outlook.com"
        );
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email provider :");
        String providerToFind = scanner.nextLine().trim().toLowerCase();
        List<String> foundEmails = emailList.stream()
            .filter(email -> email.toLowerCase().endsWith("@" + providerToFind))
            .collect(Collectors.toList());
        if (foundEmails.isEmpty()) {
            System.out.println("\nNo email addresses found for provider: " + providerToFind);
        } else {
            System.out.println("\n--- Found emails for provider: " + providerToFind + " ---");
            foundEmails.forEach(System.out::println);
        }
        scanner.close();
    }
}
