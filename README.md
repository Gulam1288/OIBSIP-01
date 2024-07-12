# Seat Reservation System

Welcome to the Seat Reservation System! This project is a simple console-based Java application designed to manage seat reservations. Users can register, log in, reserve seats, cancel reservations, and check seat availability.

## Features

- **User Registration and Login:** Secure user registration and login functionality.
- **Seat Reservation:** Users can reserve seats by specifying the seat number.
- **Cancellation:** Users can cancel their reserved seats.
- **Availability Check:** Users can check the availability of seats and view their own reservations.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code).

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/gulam1288/OIBSIP-01.git
    ```
2. Navigate to the project directory:
    ```sh
    cd OIBSIP
    ```

## Usage

1. Compile the Java files:
    ```sh
    javac SeatReservationSystem.java
    ```
2. Run the application:
    ```sh
    java SeatReservationSystem
    ```

3. Follow the on-screen instructions to register, log in, and manage seat reservations.

## Code Structure

The main logic of the application is in the `SeatReservationSystem` class. The class uses a few key data structures to manage users and reservations:

- `List<Boolean> seats`: Stores the reservation status of each seat.
- `Map<String, String> userDatabase`: Stores user credentials.
- `Map<String, List<Integer>> userReservations`: Stores reservations for each user.
- `Scanner scanner`: Handles user input.

## Example

Here's a simple example of how to interact with the system:

1. **Main Menu:**

    ```
    +====================================+
    |        SEAT RESERVATION SYSTEM     |
    +====================================+
    | 1. Register                        |
    | 2. Login                           |
    | 3. Exit                            |
    +====================================+
    Enter choice: 1
    ```

2. **Registration:**

    ```
    Enter username: johndoe
    Enter password: password123
    Registration successful!
    ```

3. **Login:**

    ```
    Enter username: johndoe
    Enter password: password123
    Login successful!
    ```

4. **User Menu:**

    ```
    +====================================+
    |              USER MENU             |
    +====================================+
    | 1. Reserve Seat                    |
    | 2. Cancel Reservation              |
    | 3. Check Availability              |
    | 4. Logout                          |
    +====================================+
    Enter choice: 1
    ```

## Acknowledgements

This project is part of my Java Development Internship at Oasis. Special thanks to my mentors and colleagues for their support and guidance.
