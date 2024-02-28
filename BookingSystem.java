
/**
 *Name: Muhammad Faris Syazwan Bin Asmadi
 *Date: 28 FEBRUARI 2024
 *Title: Assignment
**/
import java.util.Scanner;
public class BookingSystem {
    private static final int MAX_APPOINTMENTS = 20;
    private static Appointment[] appointments = new Appointment[MAX_APPOINTMENTS];
    private static int numAppointments = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < MAX_APPOINTMENTS; i++) {
            System.out.println("Enter details for Appointment " + (i + 1) + ":");
            addAppointment();
        }

        displayAppointments();
        searchAppointments();
        cancelAppointment();
        displayAppointments();
    }

    private static void addAppointment() {
        System.out.print("Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Appointment Date (YYYY-MM-DD): ");
        String apptDate = scanner.nextLine();
        System.out.print("Appointment Time: ");
        String apptTime = scanner.nextLine();
        System.out.print("Dentist Name: ");
        String dentistName = scanner.nextLine();
        appointments[numAppointments++] = new Appointment(patientName, apptDate, apptTime, dentistName);
    }

    private static void displayAppointments() {
        System.out.println("\nAll Appointment Details:");
        for (int i = 0; i < numAppointments; i++) {
            System.out.println("Appointment " + (i + 1) + ":");
            System.out.println(appointments[i] + "\n");
        }
    }

    private static void searchAppointments() {
        System.out.print("\nEnter a date to search for appointments (YYYY-MM-DD): ");
        String searchDate = scanner.nextLine();
        System.out.println("\nAppointments on " + searchDate + ":");
        boolean found = false;
        for (int i = 0; i < numAppointments; i++) {
            if (appointments[i].getApptDate().equals(searchDate)) {
                System.out.println(appointments[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for " + searchDate);
        }
    }

    private static void cancelAppointment() {
        System.out.print("\nEnter the appointment number to cancel: ");
        int appointmentNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (appointmentNumber > 0 && appointmentNumber <= numAppointments) {
            for (int i = appointmentNumber - 1; i < numAppointments - 1; i++) {
                appointments[i] = appointments[i + 1];
            }
            numAppointments--;
            System.out.println("Appointment " + appointmentNumber + " cancelled successfully.");
        } else {
            System.out.println("Invalid appointment number.");
        }
    }
}