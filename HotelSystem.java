import java.util.Scanner;

public class HotelSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingManager manager = new BookingManager();

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manager.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room category (Standard/Deluxe/Suite): ");
                    String cat = sc.nextLine();
                    manager.bookRoom(name, cat);
                    break;
                case 3:
                    System.out.print("Enter your name to cancel: ");
                    String cancelName = sc.nextLine();
                    manager.cancelBooking(cancelName);
                    break;
                case 4:
                    FileManager.showAllReservations();
                    break;
                case 5:
                    System.out.println("Thank you! Visit Again.");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}