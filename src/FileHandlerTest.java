import util.FileHandler;
import util.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerTest {
    static Input input = new Input();

    public static void main(String[] args) throws IOException {
        FileHandler contactsFile = new FileHandler("contacts", "contacts.txt");
//        FileHandler logFile = new FileHandler("logs","todays-log.txt");
        List<String> myContacts = new ArrayList<>();

        System.out.println("1. View contacts.\n" + "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" + "4. Delete an existing " +
                "contact.\n" + "5. Exit.\n" + "Enter an option (1, 2, 3, 4 or 5):");
        int option = input.getInt();
        switch (option) {
            case 1:
                printAllContacts(contactsFile);
                break;
            case 2:
                addContact(contactsFile);
                break;
            case 3:
                break;
        }

    }

    public static void printAllContacts(FileHandler contactsFile) throws IOException {

        List<String> myFriendsNameAndNumber = contactsFile.readAllContents(); // read all the lines from a file

        for (String names : myFriendsNameAndNumber) {
            String[] numbers = names.split(",");
            System.out.println(" Name: " + numbers[0] + " | Phone Number: " + numbers[1] + "\n");
        }

    }

    public static void addContact(FileHandler contactsFile) throws IOException {
        List myContacts = new ArrayList();
        String myContactsName = input.getString("Enter contacts name here:");
        String phoneNumber = input.getString("Enter contacts number here:");
        myContacts.add(myContactsName + " , " + phoneNumber);

        contactsFile.writeToFile(myContacts);
    }
//    public static void searchContactsName() throws IOException{
//        List myContacts = new ArrayList();
//        String myContactsName = input.getString("Search contact name: ");
//        String phoneNumber = input.getString("Enter phone numbver here: ");
//        myContacts.set(searchContactsName() + );
//
//    }
}
