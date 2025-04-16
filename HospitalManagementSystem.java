import java.util.ArrayList;
import java.util.Scanner;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Patient extends Person {
    private String id;
    private String disease;
    private String contact;

    public Patient(String id, String name, int age, String disease, String contact) {
        super(name, age);
        this.id = id;
        this.disease = disease;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age +
                ", Disease: " + disease + ", Contact: " + contact);
    }
}
class HospitalManager {
    private ArrayList<Patient> patients = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addPatient() {
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();
        if (findPatientById(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age;
        try {
            age = Integer.parseInt(sc.nextLine());
            if (age <= 0) {
                System.out.println("Invalid age entered.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Age must be a number.");
            return;
        }

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        patients.add(new Patient(id, name, age, disease, contact));
        System.out.println("Patient added successfully!");
    }

    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patients) {
                p.displayInfo();
            }
        }
    }

    private Patient findPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        HospitalManager hm = new HospitalManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: hm.addPatient(); break;
                case 2: hm.viewPatients(); break;
                case 3: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}