public class Reservation {
    private String userName;
    private Room room;
    private String paymentStatus;

    public Reservation(String userName, Room room) {
        this.userName = userName;
        this.room = room;
        this.paymentStatus = "Paid";
    }

    public String getUserName() { return userName; }
    public Room getRoom() { return room; }
    public String getPaymentStatus() { return paymentStatus; }

    @Override
    public String toString() {
        return "Reservation for " + userName + " | " + room.toString() + " | Payment: " + paymentStatus;
    }
}