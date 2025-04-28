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
    public String disease;
    public String contact;
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
        System.out.println("Patient[ID:" + id + ", Name: " + name + ", Age: " + age +", Disease: " + disease + ", Contact: " + contact+"]");
    }
}
class Doctor extends Person
    {
        public String id;
        public String specialization;
        public  String contact;
        public Doctor(String id,String name,int age,String specialization,String contact)
        {
            super(name,age);
            this.id=id;
            this.specialization=specialization;
            this.contact=contact;
        }
        public String getId()
        {
            return id;
        }
        public void displayInfo()
        {
            System.out.println("Doctor[ID:" + id +", Name: " + name + ", Age:"+ age+ ", Specialization: " + specialization + ", Contact: " + contact+"]");
        }
    }
class HospitalManager {
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor>doctors=new ArrayList<>();
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
        int age=validateAge();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();
        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();
        patients.add(new Patient(id, name, age, disease, contact));
        System.out.println("Patient added successfully!");
    }
    public void viewPatient() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patients) {
                p.displayInfo();
            }
        }
    }
public void updatePatient()
    {
        System.out.print("Enter Patient ID to update:");
        String id=sc.nextLine();
        Patient p=findPatientById(id);
        if(p==null)
        {
            System.out.println("Patient not found!");
            return;
        }
        System.out.print("Enter NewName:");
        p.name=sc.nextLine();
        System.out.print("Enter New Age:");
        p.age=validateAge();
        System.out.print("Enter New Disease:");
        p.disease=sc.nextLine();
        System.out.print("Enter New Contact:");
        p.contact=sc.nextLine();
        System.out.println("Patient updated successfully!");
    }
    public void deletePatient()
    {
       System.out.print("Enter Patient ID to delete:");
        String id=sc.nextLine();
        Patient p=findPatientById(id);
        if(p==null)
        {
            System.out.println("Patient not found!");
            return;
        }
        patients.remove(p);
        System.out.println("Patient deleted successfully!");
    }
    private Patient findPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
    private int validateAge()
    {
        try
            {
int age=Integer.parseInt(sc.nextLine());
                if(age<=0)
                {
                    throw new NumberFormatException();
                }}
catch(NumberFormatException e)
            {
                System.out.println("invalid age");
            }
			return 0;
}}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        HospitalManager hm = new HospitalManager();
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    hm.addPatient(); 
                    break;
                case 2:
                    hm.viewPatient(); 
                    break;
                case 3:
                    hm.updatePatient();
                    break;
                case 4:
                    hm.deletePatient();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default: 
                    System.out.println("Invalid choice.");
            }
        } while (choice !=5);
        sc.close();
    }
}
