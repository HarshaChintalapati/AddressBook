import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        AddressBook addressBook=new AddressBook();
        Scanner sc=new Scanner(System.in);
        System.out.println("Contact added successfully");
        boolean exit =false;
        while(!exit){
            System.out.println("Choose an option:");
            System.out.println("1.Add a new Contact");
            System.out.println("2. Display all contacts");
            System.out.println("3.Edit a contact");
            System.out.println("4.Delete a contact");
            System.out.println("5. Exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    addContacts(addressBook,sc);
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    editContact(addressBook,sc);
                    break;
                case 4:
                    deleteContact(addressBook,sc);
                    break;
                case 5:
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid ,Please try again");
            }

        }

    }
    public static void addContacts(AddressBook addressBook,Scanner sc){
        boolean addMore=true;
        while(addMore){
            System.out.println("First Name: ");
            String firstName=sc.nextLine();
            System.out.println("Last Name: ");
            String lastName=sc.nextLine();
            System.out.println("Address: ");
            String address=sc.nextLine();
            System.out.println("City: ");
            String city=sc.nextLine();
            System.out.println("State: ");
            String state=sc.nextLine();
            System.out.println("Zip: ");
            String zip=sc.nextLine();
            System.out.println("PhoneNumber: ");
            String phoneNumber=sc.nextLine();
            System.out.println("Email: ");
            String email= sc.nextLine();
            Contact contact=new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
            addressBook.addContact(contact);
            System.out.println("contact added successfully");
            System.out.println("Do you want to add another contact?(yes/no): ");
            String response=sc.nextLine();
            if(!response.equalsIgnoreCase("yes")){
                addMore=false;
            }

        }
    }
    public static void editContact(AddressBook addressBook,Scanner sc){
        System.out.println("enter the first name of the contact to edit");
        String editFirstName=sc.nextLine();
        System.out.println("Enter the last name of the contact to edit");
        String editLastName=sc.nextLine();
        Contact contactToEdit=addressBook.findContactByName(editFirstName,editLastName);
        if(contactToEdit != null) {
            System.out.println("Enter the details you want to edit");
            System.out.print("First Name: ");
            String newFirstName = sc.nextLine();
            System.out.print("Last Name: ");
            String newLastName = sc.nextLine();
            System.out.print("Address: ");
            String newAddress = sc.nextLine();
            System.out.print("City: ");
            String newCity = sc.nextLine();
            System.out.print("State: ");
            String newState = sc.nextLine();
            System.out.print("Zip: ");
            String newZip = sc.nextLine();
            System.out.print("Phone Number: ");
            String newPhoneNumber = sc.nextLine();
            System.out.print("Email: ");
            String newEmail = sc.nextLine();
            Contact updatedContact=new Contact(newFirstName,newLastName,newAddress,newCity,newState,newZip,newPhoneNumber,newEmail);
            addressBook.editContact(editFirstName,editLastName,updatedContact);
        }
        else{
            System.out.println("Contact Not found");
        }
    }
    public static void deleteContact(AddressBook addressBook,Scanner sc) {
        System.out.println("enter the first name of the person to delete");
        String deleteFirstName=sc.nextLine();
        System.out.println("enter the last name of the person to delete");
        String deleteLastName=sc.nextLine();
        if(addressBook.deleteContact(deleteFirstName,deleteLastName)){
            System.out.println("Contact deleted successfully");
        }
        else{
            System.out.println("contact not found");
        }
    }
    }


