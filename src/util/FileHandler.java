package util;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FileHandler {
    private String directory;
    private String fileName;
    public static void main(String[] args) throws IOException {
        // Path to resources/info.txt
        Path path = Paths.get("Contacts", "ContactInfo.txt"); // files
        System.out.println(path.toAbsolutePath());

        if (!Files.exists(path.getParent())) {
            Files.createDirectory(path.getParent());
        }
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        List<String> myContacts = new ArrayList<>();
//        myContacts.add("coffee,3");
//        myContacts.add("tea,4");


        // serialization  object -> text / deserialization text -> object

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contacts name here: ");
        String myContactsName = scanner.nextLine();
        System.out.println("Enter contacts number here:");
        String phoneNumber = scanner.nextLine();
        myContacts.add(myContactsName + "," + phoneNumber);

        Files.write(path, myContacts, StandardOpenOption.APPEND);  // write several lines to a file

        List<String> myFriendsNameAndNumber = Files.readAllLines(path); // read all the lines from a file


//        for (String myContacts: myFriendsNameAndNumber) {
//            String[] parts = myContacts.split(",");
//
//            System.out.println("Item: " + parts[0] + ", Quantity: " + parts[1]);
//            //System.out.println(grocery.replace(",", " - "));
//        }
  }
}
