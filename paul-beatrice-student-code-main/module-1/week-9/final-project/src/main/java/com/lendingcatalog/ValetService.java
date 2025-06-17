package com.lendingcatalog;



import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public abstract class ValetService implements Expense {
    private static final int MAX_SPACES = 100;
    private Map<Integer, ParkingSpot> parkingSpots;
    private List<Customer> customers;
    private List<String> logs;

    public ValetService() {
        this.parkingSpots = new HashMap<>();
        this.customers = new ArrayList<>();
        this.logs = new ArrayList<>();

        //Initialize parking spots
        for (int i = 1; i <= MAX_SPACES ; i++) {
            parkingSpots.put(i, new ParkingSpot(i, (i % 2 == 0) ? "compact" : "regular"));
        }
    }

    public void checkInVehicle(Customer customer, Vehicle vehicle, int spotNumber) throws IllegalAccessException {
        ParkingSpot spot = parkingSpots.get(spotNumber);

        //validate parking spot number
        if (spot == null) {
            throw new IllegalArgumentException("Invalid parking spot number.");
        }
        //check if spot is already occupied
        if (spot.isOccupied()) {
            throw new IllegalArgumentException(("Parking Spot " + spotNumber + "is already occupied."));
        }
        //assign the vehicle to the spot you picked
        customer.addVehicle(vehicle);
        spot.occupySpot();
        String logEntry = String.format("Checked in Vehicle: License Plate: %s, Make: %s, Model: %s, Year: %d, " +
                        "Color: %s to spot %d for customer: %s", vehicle.getLicensePlate(), vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getColor(),
                spotNumber, customer.getName());
            logs.add(logEntry);


    }
    //Check out a vehicle
    public void checkOutVehicle(int spotNumber) throws IllegalArgumentException {
        ParkingSpot spot = parkingSpots.get(spotNumber);

        //Validate parking spot
        if (spot == null || !spot.isOccupied()) {
            throw new IllegalArgumentException("Parking spot " + spotNumber + " is vacant or invalid.");
        }
        //Vacate the spot
        spot.vacateSpot();
        logs.add("Checked out vehicle from spot: " + spotNumber);
    }

    public void saveLogsToFile() throws IOException {
        //Specifies the directory and file name
        String directoryPath = " Customer Logs"; // Names a folder named "Customer Logs" in the project directory
        String fileName = "customers.txt"; //This is the file name we are using

        //Step to create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if(!directory.exists()) {
            if(directory.mkdir()) {
                System.out.println("Directory Created: " + directoryPath);
            } else {
                throw new IOException("Failed To Create Directory: " + directoryPath);
            }
        }
        //Create the file path
        File file = new File(directory, fileName); //Initialize "file" variable

        //Create the file if it doesn't exist
        if(!file.exists()) {
            if(file.createNewFile()) {
                System.out.println("File Created: " + file.getAbsolutePath());
            } else {
                throw new IOException("Failed To Create New File: " + fileName);
            }
        }

        // This is supposed to help me debug the print logs when they are written
        System.out.println("Logs to be Saved: ");
        for (String log : logs) {
            System.out.println(log);
        }

        //Write Customer Related Logs here
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String log : logs) {
                writer.write(log);
                writer.newLine();
            }
        }
        System.out.println("Logs Saved Successfully. " + file.getAbsolutePath());
    }

    // Add a log entry to the logs list
    public void addLog(String log) {
        logs.add(log);
    }

    public void loadDataFromFiles(String customerFile, String vehicleFile) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        //Load Customer Data
        try (BufferedReader reader = new BufferedReader(new FileReader(
            Objects.requireNonNull(classLoader.getResource(customerFile)).getFile()))) {
            String line;
            while((line = reader.readLine()) != null ) {
                String[] parts = line.split(";");
                customers.add(new Customer(parts[0], parts[1])); // parts [0] = name, parts [1] = contact
            }
        }

        //Load vehicle data
        try(BufferedReader reader = new BufferedReader(new FileReader(
                Objects.requireNonNull(classLoader.getResource(vehicleFile)).getFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                Vehicle vehicle = new Vehicle(
                        parts[0], // licensePlate
                        parts[1], // ownerName
                        parts[2], // make
                        parts[3], // model
                        Integer.parseInt(parts[4]), // year
                        parts[5] // color
                    );

                //Find the customer and associate the vehicle with the customer

                customers.stream()
                        .filter(c -> c.getName().equals(parts[1])) // Associate owner name with vehicle
                        .findFirst()
                        .ifPresent(c -> c.addVehicle(vehicle));
            }
        }
    }

    //TODO: look at putting this elsewhere (method below for displaying parking spots)

    //Display parking spots
    public void displayParkingSpots() {
        parkingSpots.values().forEach(System.out::println);
    }


    //TODO: HELP FIX THIS
    @Override
    public BigDecimal calculateCharge(long durationInHours) {
        BigDecimal ratePerTwoHours = BigDecimal.valueOf(10);
        BigDecimal overnightRate = BigDecimal.valueOf(40);

        if (durationInHours > 12) {
            return overnightRate;
        }

        long twoHourIncrements = (long) Math.ceil(durationInHours / 2.0);
        return ratePerTwoHours.multiply(BigDecimal.valueOf(twoHourIncrements));
    }

    @Override
    public void generateInvoice(String customerName, BigDecimal totalCost) {
        String invoice = String.format("Invoice For %s: Total Cost: $%.2f", customerName, totalCost);
        logs.add(invoice);
    }

    @Override
    public BigDecimal getTotalCost(int hours, boolean overnight) {
        if (overnight) {
            return BigDecimal.valueOf(40.00);
        }
        return BigDecimal.valueOf(Math.ceil(hours / 2.0) * 10.00);
    }
    @Override
    public void generateInvoice(String customerName, Vehicle vehicle, BigDecimal totalCost) {
        String logEntry = String.format("Generated Invoice for %s: Vehicle Details [License Plate: %s, Make: %s, Model: %s," +
                "Year: %d, Color: %s], Total Cost: $%.2f", customerName, vehicle.getLicensePlate(), vehicle.getMake(), vehicle.getModel(),
                vehicle.getYear(), vehicle.getColor(), totalCost);
                logs.add(logEntry);

        //Log the generated Invoice
        logs.add("Generated Invoice for " + customerName + ": $" +totalCost);
    }

    // MAIN METHOD FOR RUNNING APPLICATION

    //The Menu UI allows for several different options for the Valet employees to pick for different features

    public static void main(String[] args) {
        ValetService service = new ValetService() {
            @Override
            public String generateInvoice(String customerName, long durationInHours) {
                return null;
            }

            @Override
            public void generateInvoice(String customerName, BigDecimal totalCost) {

            }
        };

        try {
            service.loadDataFromFiles("customers.txt", "vehicles.txt");
        } catch (IOException e) {
            System.out.println("Error load date: " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("NullPointerException: Check File Path Or File Format.");
            e.printStackTrace();
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("Welcome to our Valet Service!");
                System.out.println("1. Check in a vehicle");
                System.out.println("2. Check out a vehicle");
                System.out.println("3. View parking spots");
                System.out.println("4. Calculate customer cost");
                System.out.println("5. Generate customer invoice");
                System.out.println("6. Save logs to file");
                System.out.println("0. Exit");
                System.out.println("Please enter your selection");

                choice = scanner.nextInt();

                switch(choice) {
                    case 1: // Check in a vehicle
                        System.out.print("Enter Customer name: ");
                        String name = scanner.next();
                        scanner.nextLine();

                        System.out.print("Enter Contact Info: ");
                        String contact = scanner.nextLine();

                        Customer customer = new Customer(name, contact);

                        System.out.print("Enter Vehicle License Plate: ");
                        String license = scanner.next();
                        scanner.nextLine();

                        System.out.print("Enter Vehicle Make: ");
                        String make = scanner.nextLine();

                        System.out.print("Enter Vehicle Model: ");
                        String model = scanner.nextLine();

                        System.out.print("Enter Vehicle Year: ");
                        int year = scanner.nextInt();

                        System.out.print("Enter Vehicle Color: ");
                        String color = scanner.next();

                        Vehicle vehicle = new Vehicle(license, name, make, model, year, color);

                        System.out.print("Enter Parking Spot Number: ");
                        int spotNumber = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            service.checkInVehicle(customer, vehicle, spotNumber);
                            System.out.println("Vehicle Checked In Successfully.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2: // Check out Vehicle
                        System.out.print("Enter Parking Spot Number: ");
                        spotNumber = scanner.nextInt();
                        try {
                            service.checkOutVehicle(spotNumber);
                            System.out.println("Vehicle Checked Out Successfully.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                    }
                        break;

                    case 3: // View parking spots
                        service.displayParkingSpots();;
                        break;

                    case 4: // Calculate customer cost
                        System.out.print("Enter Number of Hours Parked: ");
                        int hours = scanner.nextInt();
                        System.out.print("Is It An Overnight Stay (true/false)? ");
                        boolean overnight = scanner.nextBoolean();
                        BigDecimal cost = service.getTotalCost(hours, overnight);
                        System.out.printf("Total Cost: $%.2f%n", cost);
                        break;

                    case 5: // Generate Customer Invoice
                        System.out.print("Enter Customer Name: ");
                        String customerName = scanner.next();

                        System.out.print("Enter Total Cost: ");
                        BigDecimal totalCost;

                        //Step to validate Input for BigDecimal
                        while(true) {
                            try {
                                totalCost = scanner.nextBigDecimal(); // this reads the total cost
                                break; //Exit the loop if valid
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid numeric cost ex. 40.00.");
                                scanner.next();
                            }
                        }

                        // Step to generate the invoice
                        service.generateInvoice(customerName, totalCost);
                        break;


                        //TODO: FILE NAME
                    case 6: //Save Logs To File
                        System.out.print("Enter Log File Name: ");
                        String fileName = scanner.next();
                        try {
                            service.saveLogsToFile();
                            System.out.println("Logs Saved Successfully.");
                        } catch (IOException e) {
                            System.out.println("Error Saving Logs: " + e.getMessage());
                        }
                        break;

                    case 0: //EXIT SYSTEM
                        System.out.println("Exiting Valet Service. Goodbye. ");
                        break;

                    default:
                        System.out.println("Invalid Choice.");
                }
            } while (choice != 0);
        }
    }


    public Map <Integer, ParkingSpot>  getParkingSpots() {
        return parkingSpots;
    }

    public List<String> getLogs() {
        return logs;
    }
}





