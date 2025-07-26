import java.util.*;

public class BookingManager {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public BookingManager() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        loadRooms();
    }

    private void loadRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public boolean bookRoom(String userName, String category) {
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                room.setAvailable(false);
                Reservation res = new Reservation(userName, room);
                reservations.add(res);
                FileManager.saveReservation(res);
                System.out.println("Booking Successful!\n" + res);
                return true;
            }
        }
        System.out.println("No available rooms in category: " + category);
        return false;
    }

    public void cancelBooking(String userName) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Reservation res = iterator.next();
            if (res.getUserName().equalsIgnoreCase(userName)) {
                res.getRoom().setAvailable(true);
                iterator.remove();
                found = true;
                System.out.println("Booking cancelled for: " + userName);
                FileManager.clearReservations();
                for (Reservation r : reservations) FileManager.saveReservation(r);
                break;
            }
        }

        if (!found) {
            System.out.println("No reservation found for user: " + userName);
        }
    }
}