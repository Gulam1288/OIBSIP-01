import java.util.*;

public class SeatReservationSystem {
    private static final int TOTAL_SEATS = 10;
    private static final List<Boolean> seats = new ArrayList<>(Collections.nCopies(TOTAL_SEATS, false));
    private static final Map<String, String> userDatabase = new HashMap<>(); // username -> password
    private static final Map<String, List<Integer>> userReservations = new HashMap<>(); // username -> list of reserved seats
    private static String currentUser = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("+====================================+");
            System.out.println("|        SEAT RESERVATION SYSTEM     |");
            System.out.println("+====================================+");
            System.out.println("| 1. Register                        |");
            System.out.println("| 2. Login                           |");
            System.out.println("| 3. Exit                            |");
            System.out.println("+====================================+");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("--------------------------------------");
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank you for using the Seat Reservation System!\n");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.print("Invalid choice. Please try again.");
            }
            System.out.println("\n");
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (userDatabase.containsKey(username)) {
            System.out.print("Username already exists. Please choose another one.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userDatabase.put(username, password);
        userReservations.put(username, new ArrayList<>());
        System.out.print("Registration successful!");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Login successful!\n");
            userMenu();
        } else {
            System.out.print("Invalid username or password.");
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("+====================================+");
            System.out.println("|              USER MENU             |");
            System.out.println("+====================================+");
            System.out.println("| 1. Reserve Seat                    |");
            System.out.println("| 2. Cancel Reservation              |");
            System.out.println("| 3. Check Availability              |");
            System.out.println("| 4. Logout                          |");
            System.out.println("+====================================+");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("--------------------------------------");
            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    checkAvailability();
                    break;
                case 4:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("\n");
        }
    }

    private static void reserveSeat() {
        System.out.print("Enter seat number (1-" + TOTAL_SEATS + "): ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (!seats.get(seatNumber - 1)) {
            seats.set(seatNumber - 1, true);
            userReservations.get(currentUser).add(seatNumber);
            System.out.println("Seat " + seatNumber + " reserved successfully!");
        } else {
            System.out.println("Seat not available.");
        }
    }

    private static void cancelReservation() {
        System.out.print("Enter seat number (1-" + TOTAL_SEATS + "): ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (seats.get(seatNumber - 1) && userReservations.get(currentUser).contains(seatNumber)) {
            seats.set(seatNumber - 1, false);
            userReservations.get(currentUser).remove((Integer) seatNumber);
            System.out.println("Reservation for seat " + seatNumber + " cancelled successfully!");
        } else {
            System.out.println("You have not reserved this seat.");
        }
    }

    private static void checkAvailability() {
        System.out.println("+====================================+");
        System.out.println("|         SEAT AVAILABILITY          |");
        System.out.println("+====================================+");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.printf("| Seat   %2d:     %10s          |\n", (i + 1), (seats.get(i) ? "Reserved" : "Available"));
        }
        System.out.println("+====================================+");
        System.out.println("Your Reservations:");
        List<Integer> reservedSeats = userReservations.get(currentUser);
        if (reservedSeats.isEmpty()) {
            System.out.println("You have no reservations.");
        } else {
            for (int seat : reservedSeats) {
                System.out.println("Seat " + seat);
            }
        }
    }
}
