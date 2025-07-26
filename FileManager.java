import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_NAME = "bookings.txt";

    public static void saveReservation(Reservation res) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(res.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving booking.");
        }
    }

    public static void showAllReservations() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Bookings:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No bookings found.");
        }
    }

    public static void clearReservations() {
        try {
            new PrintWriter(FILE_NAME).close();
        } catch (IOException e) {
            System.out.println("Failed to clear bookings.");
        }
    }
}