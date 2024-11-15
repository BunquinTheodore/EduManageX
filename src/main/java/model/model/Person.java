package model;

public abstract class Person {
    private String id; 
    private String name;

    public Person(String id, String name) {
        if (!id.matches("[0-9-]+")) {
            throw new IllegalArgumentException("  ID must be numeric with optional dashes");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("  Name cannot be null or empty");
        }
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("  Name cannot be null or empty");
        }
        this.name = name;
    }

    public void showID() {
        System.out.println("\n====================================================");
        System.out.println("                IDENTIFICATION CARD ");
        System.out.println("====================================================");
        System.out.println(" Name : " + name);
        System.out.println(" ID : " + id);
        System.out.println("====================================================\n");
    }
}
