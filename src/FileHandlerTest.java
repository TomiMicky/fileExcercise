import util.FileHandler;
import util.Input;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class FileHandlerTest {
    static Input input = new Input();

    public static void main(String[] args) throws IOException {
        FileHandler contactsFile = new FileHandler("contacts", "contacts.txt");
        List<String> myContacts = new ArrayList<>();
        do {
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
                    searchContactsName(contactsFile);
                    break;
                case 4:
                    deleteExistContact(contactsFile);
                    break;
                case 5:
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
            }
        } while (input.yesNo("Would you like to continue? (y/n)"));

        System.out.println("Goodbye, and have a wonderful day!");
    }
    private static void printAllContacts(FileHandler contactsFile) throws IOException {
        List<String> myFriendsNameAndNumber = contactsFile.readAllContents();
        for (String names : myFriendsNameAndNumber) {
            System.out.println(names + "\n");
        }
    }

    private static void addContact(FileHandler contactsFile) throws IOException {
        String phoneNumber;
        List<String> myContacts = new ArrayList();
        String myContactsName = input.getString("Enter contacts name here:");
         phoneNumber = input.getString("Enter contacts number here:");
        myContacts.add(myContactsName + " , " + "(" + phoneNumber.substring(0,3)
                + ")" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6));
        contactsFile.writeToFile(myContacts, true);
    }
    private static void searchContactsName(FileHandler contactFile) throws IOException {
        List<String> myContacts = contactFile.readAllContents();
        String myContactsName = input.getString("Search contact name: ");
        for (String contact : myContacts) {
            if (contact.contains(myContactsName)) {
                System.out.println(contact);
            }
        }
    }
    public static void deleteExistContact(FileHandler contactFile) throws IOException {
        List<String> myContacts = contactFile.readAllContents();
        String deleteMyContactsName = input.getString("Delete contact: ");
        for (String delete : myContacts) {
            if (delete.contains(deleteMyContactsName)) {
                myContacts.remove(myContacts.indexOf(delete));
                break;
            }
        }
        contactFile.writeToFile(myContacts, false);
        }
     }


