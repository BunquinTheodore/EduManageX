// Define the package
package model;

public abstract class Person {
    // Declare the ID of the person
    private String id; 
    // Declare the name of the person
    private String name;

    // Constructor to initialize the person with an ID and a name
    public Person(String id, String name) {
        // Validate the ID to ensure it is numeric with optional dashes
        if (!id.matches("[0-9-]+")) {
            throw new IllegalArgumentException("ID must be numeric with optional dashes");
        }
        // Validate the name to ensure it is not null or empty
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.id = id;
        this.name = name;
    }

    // Getter method to get the ID of the person
    public String getId() {
        return id;
    }

    // Getter method to get the name of the person
    public String getName() {
        return name;
    }

    // Setter method to set the name of the person
    public void setName(String name) {
        // Validate the name to ensure it is not null or empty
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    // Method to display the ID and name of the person in a formatted manner
    public void showID() {
        System.out.println("\n====================================================");
        System.out.println("                IDENTIFICATION CARD ");
        System.out.println("====================================================");
        System.out.println(" Name : " + name);
        System.out.println(" ID : " + id);
        System.out.println("====================================================\n");
    }
}
